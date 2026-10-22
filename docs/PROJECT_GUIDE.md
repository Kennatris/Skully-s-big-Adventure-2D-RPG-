# Skullys Big Adventure: Projektleitfaden

[Einstieg](../README.md) · [Agentenregeln](../AGENTS.md) · Inventarstand 22.10.2026.

## Zweck und vorhandener Stand

Java-2D-Spiel mit mehreren historischen Projektständen, Ressourcen und vorhandener JAR-Datei.

Geprüfter Branch: `main`; Ausgangscommit `03bb0f3567fcb28d50b25c694a1580531395ac3b`. Die folgende Struktur stammt aus dem vorhandenen Git-Baum, nicht aus einer behaupteten erfolgreichen Installation.

## Aufbau und Einstieg

- [My2DGame(Test)/src/main/Main.java](../My2DGame%28Test%29/src/main/Main.java)
- [Projekt/My2DGame/src/main/Main.java](../Projekt/My2DGame/src/main/Main.java)
- [game/My2DGame/src/main/Main.java](../game/My2DGame/src/main/Main.java)

Weitere vorhandene Hauptbereiche: `My2DGame(Test)`, `Projekt`, `README.md`, `game`, `skullys-big-adventure.jar`.

## Einrichtung und Prüfungen

Zuerst die vorhandenen Projekt-/Paketdateien und Agentenregeln lesen. Verfügbare Toolchain und Versionen vor Installation feststellen. Nur vorhandene Manifeste/Lockfiles verwenden; keine Abhängigkeiten aus dem Projektnamen erfinden.

```bash
python3 .github/scripts/check-project-docs.py
```

Das Dokumentationsgate arbeitet ohne Anwendungsausführung oder externe APIs. Weitere aufgeführte Befehle sind aus dem Projekt abgeleitete nächste Prüfungen; ihr erfolgreicher Lauf auf der Zielumgebung wird durch diesen Leitfaden nicht behauptet. Bei geräte-, GUI-, Broker- oder Datenbankabhängigen Prüfungen gelten die folgenden Grenzen.

## Daten, Betrieb und Sicherheit

Historische Spielstände nicht zusammenwerfen oder wegen ähnlicher Namen löschen. Führendes Quellprojekt vor einer Änderung bestimmen. Keine fremden JARs/Spielstände blind ausführen; Grafik-/Audioquellen und relative Ressourcenpfade erhalten.

Konfigurationen, Datenquellen, erzeugte Artefakte und ihre Aufbewahrung dokumentieren. Produktiv-/Nutzerdaten haben eine getrennte Sicherung und einen geprüften Rückweg. Keine Cloudübertragung, Kosten, Releases oder Deployments als Nebenwirkung eines Dokumentationstests.

## Änderungen und Abnahme

[Beitragsablauf](../CONTRIBUTING.md) beschreibt Branch, PR und Tests; [Sicherheitsmeldungen](../SECURITY.md) beschreibt den vertraulichen Meldeweg. Änderungen an Schnittstellen, Datenformaten oder Betrieb aktualisieren die Dokumentation im selben Change. Kleine nachvollziehbare Änderungen und ein datenkompatibler Rückweg gehören bei relevanten Eingriffen zur Abnahme.

## Lizenz und Herkunft

Im geprüften Baum wurde keine eigenständige Lizenzdatei nachgewiesen. Vor externer Wiederverwendung Rechte und Lizenz mit den Rechteinhabern klären; dieser Change wählt keine neue Lizenz.

## Offene Nachweise

- Branchschutz aktuell nicht als aktiv gemeldet; konkrete Regeln, Secret Scanning, Push Protection und Code Scanning wurden mit diesem Dokumentationschange nicht als vollständig eingerichtet nachgewiesen.
