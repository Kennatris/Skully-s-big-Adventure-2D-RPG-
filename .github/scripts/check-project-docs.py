#!/usr/bin/env python3
"""Validate the declared documentation contract without running application code."""
import argparse
import json
from pathlib import Path
import re
from urllib.parse import unquote,urlsplit

def main():
    parser=argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--known-paths',type=Path,help='verified Git-tree paths for an offline partial checkout')
    args=parser.parse_args()
    root=Path(__file__).resolve().parents[2]
    contract=json.loads((root/'.github/project-standards.json').read_text(encoding='utf-8'))
    known=set(args.known_paths.read_text(encoding='utf-8').splitlines()) if args.known_paths else set()
    errors=[]
    secret_patterns=[r'(?:github_pat_|gh[pousr]_)[A-Za-z0-9_]{25,}',r'-----BEGIN (?:[A-Z0-9]+ )?PRIVATE KEY-----',r'\bAGE-SECRET-KEY-1[A-Z0-9]{40,}',r'https://(?:discord(?:app)?\.com)/api/webhooks/\d+/[A-Za-z0-9_-]+']
    for name in contract['required_paths']:
        path=root/name
        if not path.is_file() or not path.read_bytes().strip():errors.append(name+': required non-empty file missing');continue
        text=path.read_text(encoding='utf-8')
        if re.search(r'(?m)^(?:<<<<<<< |=======\s*$|>>>>>>> )',text):errors.append(name+': merge marker')
        if any(re.search(pattern,text) for pattern in secret_patterns):errors.append(name+': potential secret; matched value withheld')
    link=re.compile(r'(?<!!)\[[^\]\n]+\]\(([^)\n]+)\)')
    for name in contract['managed_link_files']:
        text=(root/name).read_text(encoding='utf-8')
        for match in link.finditer(text):
            target=match.group(1);parts=urlsplit(target)
            if parts.scheme or parts.netloc or target.startswith('#'):continue
            resolved=((root/name).parent/unquote(parts.path)).resolve()
            if not resolved.is_relative_to(root):errors.append(name+': link escapes repository');continue
            if not resolved.exists() and resolved.relative_to(root).as_posix() not in known:errors.append(name+': local target missing')
    for error in errors:print('FAIL | '+error)
    if errors:return 1
    print('OK | required project documents, managed links, merge markers and secret patterns checked; application tests separate')
    return 0

if __name__=='__main__':raise SystemExit(main())
