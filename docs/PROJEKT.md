# Skully’s Big Adventure – Projekt und Technik

## Entstehung

Skully’s Big Adventure entstand 2022 als gemeinsame Projektarbeit im Abitur (TGI11). Entwickelt wurde ein 2D-Abenteuer mit einer begehbaren Welt, animierten Figuren und Dialogen.

## Spiel und Technik

Das Projekt setzt ein 2D-Abenteuer mit Java, Swing und AWT um. Eine Spielschleife aktualisiert Bewegung und Darstellung. Die Welt besteht aus nummerierten Kacheln; Textdateien legen die Karte fest. Der Bildausschnitt folgt der Spielfigur. NPCs, Kollisionen, Dialoge und Ereignisse ergänzen die Bewegung. Herzen zeigen Lebenspunkte; ein Pausenmodus hält das Spiel an.

![Technikübersicht](media/technik.svg)

| Bereich | Umsetzung |
| --- | --- |
| Programmstart | `src/main/Main.java` |
| Spielschleife und Zustände | `GamePanel`: Titel, Spiel, Pause und Dialog |
| Eingabe und Oberfläche | `KeyHandler`, `UI`, Swing/AWT |
| Welt | `tile/TileManager`, PNG-Kacheln, Textkarten unter `res/maps` |
| Figuren | `entity/Player`, `NPC_OldMan`, Richtungsanimationen |
| Kollisionen und Ereignisse | `CollisionChecker`, `EventHandler` |
| Audio | Java Sound, WAV-Dateien |

## Spielversionen

Im Projekt gibt es die Spielversion mit ausgearbeiteten Karten und eine separate Testversion. Die Bilder in der [README](../README.md) zeigen die ausgearbeitete Welt.

| Ordner oder Datei | Inhalt |
| --- | --- |
| `Projekt/My2DGame` | Spielversion mit Gras, Wegen, Wasser und Bäumen |
| `My2DGame(Test)` | Testversion mit Platzhalterkacheln |
| `game/My2DGame` | Früher Prototyp |
| `skullys-big-adventure.jar` | Startet die Testversion |

## Kompilieren und starten

Die Spiel- und Testversion lassen sich mit **Temurin JDK 21.0.13+9 unter Windows** kompilieren. Für die Spielversion die folgenden PowerShell-Befehle im Projektordner ausführen; `javac` und `java` müssen erreichbar sein.

```powershell
$project = Join-Path (Get-Location) 'Projekt/My2DGame'
$classes = Join-Path ([IO.Path]::GetTempPath()) 'skully-graphic-classes'
New-Item -ItemType Directory -Force -Path $classes | Out-Null
$sources = @(Get-ChildItem -LiteralPath "$project/src" -Recurse -Filter *.java | ForEach-Object FullName)
javac -proc:none -encoding UTF-8 -d $classes @sources
java -cp "$classes;$project/res" main.Main
```

Die **Testversion** lässt sich direkt über die JAR-Datei starten:

```text
java -jar skullys-big-adventure.jar
```

Die Testversion verwendet schwarze Platzhalterkacheln. Sie ist in der [Galerie](GALERIE.md) zusätzlich zur Spielversion zu sehen.

## Bedienung und Ereignisse

| Eingabe | Aktion |
| --- | --- |
| Enter | NEW GAME starten; Dialog verlassen |
| W/A/S/D | Bewegung |
| F | Gespräche und Heilung |
| Escape | Pause ein-/ausschalten |

In der Spielversion löst Kachel (25, 21) mit Blickrichtung rechts ein Schadensereignis aus. Bei (23, 21) kann sich die Figur mit Blickrichtung oben und F heilen. In der Testversion liegt die Heilposition bei (24, 8).

Der Menüpunkt **LOAD GAME** hat keine Funktion. Schlüssel- und Truhenklassen sind im Code angelegt; in der Spielversion werden keine Sammelobjekte platziert.

## Bilder

Die [Galerie](GALERIE.md) zeigt Spielwelt, Dialoge, Pause, Schaden und Heilung. Für die NPC-Dialogaufnahme wurden Figuren positioniert und die Spielzeit angehalten. Die übrigen Bilder stammen aus normalen Spielläufen.

[Zur Projektübersicht](../README.md). Alle Angaben und Downloads ohne Gewähr.
