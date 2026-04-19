# Formular-App mit MySQL

Kleine Java-Swing-Anwendung in mehrschichtiger Architektur.

## Enthaltene Schichten

- `ui`: Swing-Oberfläche mit `JPanel`
- `application`: Use-Case und Transportobjekt
- `domain`: Fachlogik des Formulars
- `persistence`: JDBC-Repositorium mit MySQL

## Formularfelder

- `JTextField` für Titel
- `JTextArea` für Beschreibung
- zwei `JCheckBox`
- `JComboBox`
- Button `Speichern`
- Button `Löschen`

## Validierung

### Technische Validierung in der UI
- Titel darf nicht leer sein
- Beschreibung darf nicht leer sein
- Kategorie muss ausgewählt sein

### Fachliche Validierung in der Domain
- Titel mindestens 3 Zeichen
- Beschreibung mindestens 10 Zeichen
- Datenschutz muss akzeptiert sein
- Bei Kategorie `WICHTIG` muss Newsletter aktiviert sein

## MySQL vorbereiten

1. MySQL starten.
2. Die Datei `sql/mysql-schema.sql` ausführen.
3. Zugangsdaten bei Bedarf in `ConnectionFactory.java` anpassen.

Standardwerte im Projekt:

- Datenbank: `formulardb`
- Benutzer: `root`
- Passwort: `root`
- URL: `jdbc:mysql://localhost:3306/formulardb?useSSL=false&serverTimezone=Europe/Berlin`

## Starten

```bash
mvn compile
mvn exec:java
```
