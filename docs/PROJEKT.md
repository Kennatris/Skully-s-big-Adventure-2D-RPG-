# Skully’s Big Adventure – Projekt und Technik

## Entstehung

Skully’s Big Adventure entstand 2022 als Team-Projektarbeit im Abitur (TGI11). Die Dokumentation beschreibt die gemeinsame Arbeit und den im Repository erhaltenen Funktionsumfang. Individuelle Beiträge werden ohne zusätzliche Belege nicht einzelnen Personen zugeschrieben.

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

## Erhaltene Varianten

Der Hauptbranch enthält mehrere Entwicklungsstände nebeneinander. Ein späteres Dateidatum bedeutet hier keine vollständigere grafische Version.

| Pfad | Historischer Stand | Sichtbarer Schwerpunkt |
| --- | --- | --- |
| `game/My2DGame` | Früher Stand vom Mai 2022 | Frühe Spielstruktur |
| `Projekt/My2DGame` | Projektstand vom Juni 2022 | Ausgestaltete Gras-, Weg-, Wasser- und Baumwelt; 20 Java-Quellen |
| `My2DGame(Test)` | Späterer Teststand vom Juli 2022 | Platzhalterkacheln und getrennte Testdarstellung; 20 Java-Quellen |
| `skullys-big-adventure.jar` | Historische Root-JAR | Entspricht in 20 Klassen und 43 Ressourcen bytegenau dem Teststand |

Die [README](../README.md) verwendet Bilder der Grafikversion. Die [Galerie](GALERIE.md) zeigt zusätzlich den jüngeren Teststand und beschriftet beide eindeutig. Der ursprüngliche Hauptstand ist unter `old/main` gesichert; vorhandene Entwicklungsbranches bleiben erhalten.

## Kompilieren und starten

Die beiden späteren Quellvarianten wurden unverändert mit **Temurin JDK 21.0.13+9 unter Windows** kompiliert. Für die Grafikversion die folgenden PowerShell-Befehle im Repositoryroot ausführen; `javac` und `java` müssen erreichbar sein.

```powershell
$project = Join-Path (Get-Location) 'Projekt/My2DGame'
$classes = Join-Path ([IO.Path]::GetTempPath()) 'skully-graphic-classes'
New-Item -ItemType Directory -Force -Path $classes | Out-Null
$sources = @(Get-ChildItem -LiteralPath "$project/src" -Recurse -Filter *.java | ForEach-Object FullName)
javac -proc:none -encoding UTF-8 -d $classes @sources
java -cp "$classes;$project/res" main.Main
```

Den erhaltenen **Teststand** startet die historische Root-JAR:

```text
java -jar skullys-big-adventure.jar
```

Die JAR verwendet Platzhalterkacheln und zeigt deshalb eine überwiegend schwarze Welt. Die Testaufnahmen wurden mit einer angepassten JVM-Anzeigeskalierung aufgenommen, damit das große Originalfenster vollständig auf den Bildschirm passt. Am Quellcode oder an der JAR wurde nichts verändert.

## Bedienung und Ereignisse

| Eingabe | Aktion |
| --- | --- |
| Enter | NEW GAME starten; Dialog verlassen |
| W/A/S/D | Bewegung |
| F | NPC-Interaktion; vorgesehenes Heilereignis |
| Escape | Pause ein-/ausschalten |

Die Grafikversion enthält ein Schadensereignis bei Kachel (25, 21) mit Blickrichtung rechts sowie ein Heilereignis bei (23, 21) mit Blickrichtung oben und F. Der Teststand verwendet für die Heilung die andere Position (24, 8). Das Titelmenü enthält **LOAD GAME** als historischen Platzhalter; eine fertige Ladefunktion wird damit nicht zugesichert. Im späteren Projektstand ist `AssetSetter.setObject()` leer: vorhandene Schlüssel-/Truhenklassen allein belegen keine spielbare Sammelaufgabe.

## Prüfung und Einordnung

Nachgewiesen sind die Kompilierung beider Varianten, der Klassen-/Ressourcenabgleich der Root-JAR und echte Fensteraufnahmen des Spiels. Die NPC-Dialogaufnahme verwendet eine getrennte lokale Aufnahmehilfe mit eingefrorener Zeit und gesetzten Positionen; der historische Spielquellcode und Renderer bleiben unverändert. Eine vollständige Fehlerfreiheit oder aktuelle Betriebssystemkompatibilität wird nicht behauptet. Grafiken, Audiodateien und vorhandene Hinweise bleiben erhalten; diese Aufbereitung vergibt keine neue pauschale Lizenz für fremde Bestandteile.

> Automatisiert durch einen Agenten erstellte rückblickende Dokumentation. Am historischen Spielquellcode wurde nichts geändert. Texte und echte Aufnahmen dienen der Veranschaulichung. Alle Angaben und Downloads ohne Gewähr.
