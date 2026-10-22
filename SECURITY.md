# Sicherheit: Skullys Big Adventure

Dieser Bestand besitzt keine durch diese Datei zugesagte Sicherheitszertifizierung oder LTS-Garantie. Unterstützte Versionen und offene Befunde müssen anhand des tatsächlichen Projektstands geprüft werden.

## Schwachstelle melden

Wenn im Repository Private Vulnerability Reporting angeboten wird, den privaten Meldeweg im GitHub-Sicherheitsbereich verwenden. Andernfalls zunächst eine Issue ohne Exploit-, Zugangsdaten oder personenbezogene Details mit der Bitte um einen vertraulichen Kontaktweg an den Maintainer eröffnen. Vertrauliche Details erst über einen vereinbarten geschützten Kanal übertragen. Die Aktivierung eines privaten Meldewegs wird hier nicht behauptet.

Hilfreiche Angaben: betroffene Version/Commit, Voraussetzung, Auswirkung und kleinster synthetischer Reproduktionsfall. Niemals echte Tokens, Passwörter, private Schlüssel, Nutzerdaten oder Datenbankkopien beifügen.

## Bearbeitung

Befund nachvollziehen, tatsächliche Erreichbarkeit bewerten, Herstellerfix/Backport prüfen und mit passenden Tests korrigieren. Bei exponierten Secrets ist Rotation nötig; Löschen einer sichtbaren Zeile allein ist kein Nachweis vollständiger Bereinigung. Keine Ausnutzung gegen produktive Systeme oder fremde Konten zur Verifikation.

Fix, laufende Version, Rescan und verbleibende Risiken getrennt dokumentieren. Ein aktueller Tag, grüner Build oder fehlender Scannerfund belegt keine vollständige Schwachstellenfreiheit. Projektgrenzen: [AGENTS.md](AGENTS.md).
