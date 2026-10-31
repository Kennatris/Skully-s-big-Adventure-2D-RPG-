# Skully’s Big Adventure

**2D-Abenteuer · Teamprojekt im Abitur · TGI11 / 2022**

Skully’s Big Adventure ist ein Java-Spielprojekt mit einer begehbaren Waldwelt, animierten Figuren und NPC-Dialogen. Ein früher Sammelspiel-Prototyp dreht sich um Schlüssel, verschlossene Türen und die Suche nach einem Schatz.

![Skully unterwegs in der Spielwelt](docs/media/15-laufanimation.gif)

[Projekt und Technik](docs/PROJEKT.md) · [Bildergalerie](docs/GALERIE.md) · [Quellcode herunterladen](https://github.com/Kennatris/Skully-s-big-Adventure-2D-RPG-/archive/refs/heads/main.zip)

## Abenteuerwelt

Waldwege, Wasser und Bäume bilden die Karte. Die Kamera folgt der Spielfigur. Kollisionen begrenzen die Bewegung, NPCs führen Gespräche und Herzen zeigen die verbleibenden Lebenspunkte. Kartenereignisse können Schaden verursachen oder die Figur heilen. Mit Escape lässt sich das Spiel pausieren.

| NPC-Gespräch | Heilung |
| --- | --- |
| ![Gespräch mit einem NPC](docs/media/06-npc-dialog-aufnahmeversion.jpg) | ![Heilung](docs/media/05-heilung.jpg) |

## Schatzsuche im Prototyp

Schlüssel öffnen Türen und werden dabei verbraucht. Stiefel erhöhen die Laufgeschwindigkeit. Wer die Schatztruhe erreicht, beendet das Spiel. Schlüsselzähler, Meldungen und Zeitanzeige begleiten die Suche.

| Verschlossene Tür | Schatz gefunden |
| --- | --- |
| ![Eine Tür benötigt einen Schlüssel](docs/media/11-prototyp-tuer-verschlossen-aufnahmeversion.jpg) | ![Abschluss der Schatzsuche](docs/media/14-prototyp-schatz-aufnahmeversion.jpg) |

Die Abenteuerwelt liegt unter `Projekt/My2DGame`, die Schatzsuche unter `game/My2DGame`. [Alle Spielversionen und Startbefehle](docs/PROJEKT.md#spielversionen).

![Technikübersicht: Java, Swing/AWT, Spielsysteme und Ressourcen](docs/media/technik.svg)

## Spielen

Bewegung: **W/A/S/D**, Spielstart in der Abenteuerwelt: **Enter**, Gespräche und Heilung: **F**, Pause: **Escape**. Die Schatzsuche startet direkt und verwendet W/A/S/D. [Kompilieren und starten](docs/PROJEKT.md#kompilieren-und-starten).

Für die Dialog-, Prototyp- und Animationsaufnahmen wurden Figuren positioniert und Abläufe gezielt ausgelöst. Die Spielzeit im Prototyp ist angehalten und zeigt keine erspielte Bestzeit. [Weitere Bilder](docs/GALERIE.md).

> **Hinweis:** Dokumentation und Zusammenfassung wurden automatisiert durch einen Agenten erstellt und dienen der Veranschaulichung. Der Spielcode ist unverändert. Alle Angaben und Downloads ohne Gewähr.
