# Beiträge zu Skullys Big Adventure

Vor Änderungen [AGENTS.md](AGENTS.md) und den [Projektleitfaden](docs/PROJECT_GUIDE.md) lesen. Aktuellen Branch, Dateistand und vorhandene Änderungen prüfen; Nutzer- und Teamarbeit erhalten.

1. Ein abgegrenztes Problem mit gewünschtem Verhalten und Abnahmekriterien festhalten.
2. Auf einem thematischen Branch arbeiten; vorhandene projektspezifische Branch- und Taskregeln haben Vorrang.
3. Quelländerung und passende Dokumentation zusammen pflegen. Keine echten Secrets, privaten Daten oder unkontrollierten Binär-/Cacheartefakte aufnehmen.
4. Zuerst `python3 .github/scripts/check-project-docs.py` ausführen; danach die relevanten vorhandenen Anwendungstests aus dem Leitfaden. Daten-/Netzwerknebenwirkungen vorher prüfen.
5. Im PR Problem, resultierendes Verhalten, tatsächlich ausgeführte Prüfungen, offene Grenzen und gegebenenfalls Rückweg nennen. Keine unbewiesenen Erfolgs- oder Sicherheitsbehauptungen.
6. Review und erforderliche CI-Prüfungen abwarten. Keine automatische Umgehung von Schutzregeln, erzwungene History-Umschreibung oder Übernahme fremder uncommitteter Änderungen.

Dokumentationsänderungen brauchen kein erfundenes Anwendungstestgerüst. Sicherheits-, Migrations- oder Verhaltensänderungen erhalten passende positive und negative Tests. Bestehende Tests werden nicht zur bloßen Erzielung eines grünen Status abgeschwächt.
