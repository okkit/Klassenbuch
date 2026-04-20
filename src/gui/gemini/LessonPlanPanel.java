package gui.gemini;

import javax.swing.*;
import java.awt.*;

public class LessonPlanPanel extends JPanel {

    public LessonPlanPanel() {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE); // Panel Hintergrund weiß setzen

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10); // Abstand zwischen Komponenten

        // Header Row
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1; // "Tag" Spalte
        gbc.anchor = GridBagConstraints.WEST;
        add(createBoldLabel("Tag"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.1; // "Datum" Spalte
        gbc.anchor = GridBagConstraints.WEST;
        add(createBoldLabel("Datum"), gbc);

        gbc.gridx = 2;
        gbc.weightx = 0.6; // "Inhalt" Spalte
        gbc.anchor = GridBagConstraints.WEST;
        add(createBoldLabel("Inhalt"), gbc);

        gbc.gridx = 3;
        gbc.weightx = 0.2; // Checkbox Spalte
        gbc.anchor = GridBagConstraints.WEST;
        // Für den Header der Checkboxen gibt es keine explizite Beschriftung im Bild,
        // daher lassen wir diesen Bereich vorerst leer oder fügen einen Platzhalter hinzu.
        add(new JLabel(" "), gbc); // Leerer Platzhalter

        // Separator below header
        JSeparator headerSeparator = new JSeparator(JSeparator.HORIZONTAL);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0); // Keine zusätzlichen Insets für Separator
        add(headerSeparator, gbc);

        // Content Row for Monday
        gbc.gridwidth = 1; // Zurücksetzen
        gbc.fill = GridBagConstraints.NONE; // Zurücksetzen
        gbc.insets = new Insets(5, 10, 5, 10); // Standard Insets

        // Montag
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST; // Oben links für "Montag"
        JLabel montagLabel = createBoldLabel("Montag");
        montagLabel.setBackground(new Color(240, 240, 240)); // Hintergrundfarbe wie im Bild
        montagLabel.setOpaque(true); // Wichtig, damit die Hintergrundfarbe sichtbar ist
        add(montagLabel, gbc);

        // Datum
        gbc.gridx = 1;
        JLabel dateLabel = new JLabel("13.04.2026");
        dateLabel.setBackground(new Color(240, 240, 240)); // Hintergrundfarbe wie im Bild
        dateLabel.setOpaque(true);
        add(dateLabel, gbc);

        // Inhalt
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST; // Oben links für den Inhalt
        JTextArea contentArea = new JTextArea();
        contentArea.setText("Wiederholung: Objekt-Klasse-Instanz.\n" +
                            "Erstellen eines Dokuments mit den Unterrichtsinhalten in Microsoft Word.\n" +
                            "Weitere Objekte im Projekt \"Klassenbuch\" erstellen und testen.");
        contentArea.setWrapStyleWord(true);
        contentArea.setLineWrap(true);
        contentArea.setEditable(false);
        contentArea.setBackground(new Color(240, 240, 240)); // Hintergrundfarbe wie im Bild
        // Den JTextArea in ein JScrollPane packen, um bei Bedarf Scrollbarkeit zu ermöglichen
        // (Im aktuellen Fall ist es nicht direkt sichtbar, aber gute Praxis für längere Texte)
        // JScrollPane scrollPane = new JScrollPane(contentArea);
        // scrollPane.setBorder(BorderFactory.createEmptyBorder()); // Optional: keine Border
        // add(scrollPane, gbc);
        add(contentArea, gbc);


        // Checkboxen
        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new BoxLayout(checkboxPanel, BoxLayout.Y_AXIS));
        checkboxPanel.setBackground(new Color(240, 240, 240)); // Hintergrundfarbe wie im Bild

        JCheckBox frontalunterricht = new JCheckBox("Frontalunterricht");
        JCheckBox projektarbeit = new JCheckBox("Projektarbeit");
        JCheckBox gruppenarbeit = new JCheckBox("Gruppenarbeit");
        JCheckBox selbstlernphase = new JCheckBox("Selbstlernphase"); // Diese ist angehakt

        selbstlernphase.setSelected(true); // Setzt die Selbstlernphase als angehakt

        // Setzt den Hintergrund der Checkboxen auf die gleiche Farbe wie die Zelle
        frontalunterricht.setBackground(new Color(240, 240, 240));
        projektarbeit.setBackground(new Color(240, 240, 240));
        gruppenarbeit.setBackground(new Color(240, 240, 240));
        selbstlernphase.setBackground(new Color(240, 240, 240));

        checkboxPanel.add(frontalunterricht);
        checkboxPanel.add(projektarbeit);
        checkboxPanel.add(gruppenarbeit);
        checkboxPanel.add(selbstlernphase);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST; // Oben links für die Checkboxen
        add(checkboxPanel, gbc);

        // Um den Hintergrund der gesamten Zeile (Montag, Datum, Inhalt, Checkboxen)
        // einheitlich zu gestalten, muss man den Hintergrund direkt bei den Einzelkomponenten setzen
        // oder ein weiteres JPanel für die gesamte Zeile verwenden und dessen Hintergrund setzen.
        // Im aktuellen Setup wird der Hintergrund der Labels/Textarea/CheckboxPanel direkt gesetzt
        // um den Effekt der hellgrauen Zeile zu erzielen.
        // Die Zelle für "Montag" im originalen Bild ist breiter und der graue Hintergrund erstreckt sich
        // über die gesamte Zeile. Dies ist mit GridBagLayout nicht trivial für _alle_ Zellen genau so zu machen,
        // ohne für jede Zelle eine Komponente mit dem Hintergrund zu füllen oder eine custom painting Methode zu überschreiben.

        // Für den Effekt des grauen Hintergrunds der gesamten Zeile, der über "Montag" hinausgeht,
        // müsste man ein separates JPanel für diese Zeile erstellen und dieses JPanel dann zu 'this' Panel hinzufügen.
        // Hier eine verbesserte Art, den Hintergrund der Zeile zu verwalten, indem man ein zusätzliches JPanel verwendet:

        // Entfernen der vorherigen Komponenten für die Montag-Zeile, wenn man eine neue Zeilen-Panel-Struktur verwendet.
        removeAll(); // Entfernt alle Komponenten

        // Header Row (redefinieren)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.1;
        gbc.anchor = GridBagConstraints.WEST;
        add(createBoldLabel("Tag"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.1;
        add(createBoldLabel("Datum"), gbc);

        gbc.gridx = 2;
        gbc.weightx = 0.6;
        add(createBoldLabel("Inhalt"), gbc);

        gbc.gridx = 3;
        gbc.weightx = 0.2;
        add(new JLabel(" "), gbc); // Leerer Platzhalter

        // Separator below header
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(headerSeparator, gbc);

        gbc.gridwidth = 1; // Zurücksetzen
        gbc.fill = GridBagConstraints.NONE; // Zurücksetzen
        gbc.insets = new Insets(5, 10, 5, 10); // Standard Insets

        // Creating a panel for the entire "Montag" row to set a unified background
        JPanel mondayRowPanel = new JPanel(new GridBagLayout());
        mondayRowPanel.setBackground(new Color(240, 240, 240)); // Hintergrundfarbe für die ganze Zeile
        GridBagConstraints mondayGbc = new GridBagConstraints();
        mondayGbc.insets = new Insets(5, 10, 5, 10);
        mondayGbc.anchor = GridBagConstraints.NORTHWEST;

        // Montag in mondayRowPanel
        mondayGbc.gridx = 0;
        mondayGbc.gridy = 0;
        mondayGbc.weightx = 0.1;
        mondayRowPanel.add(createBoldLabel("Montag"), mondayGbc);

        // Datum in mondayRowPanel
        mondayGbc.gridx = 1;
        mondayGbc.weightx = 0.1;
        mondayRowPanel.add(new JLabel("13.04.2026"), mondayGbc);

        // Inhalt in mondayRowPanel
        mondayGbc.gridx = 2;
        mondayGbc.weightx = 0.6;
        JTextArea contentAreaRow = new JTextArea();
        contentAreaRow.setText("Wiederholung: Objekt-Klasse-Instanz.\n" +
                               "Erstellen eines Dokuments mit den Unterrichtsinhalten in Microsoft Word.\n" +
                               "Weitere Objekte im Projekt \"Klassenbuch\" erstellen und testen.");
        contentAreaRow.setWrapStyleWord(true);
        contentAreaRow.setLineWrap(true);
        contentAreaRow.setEditable(false);
        contentAreaRow.setOpaque(false); // Macht den Hintergrund des JTextArea transparent, damit der des Panels durchscheint
        mondayRowPanel.add(contentAreaRow, mondayGbc);

        // Checkboxen in mondayRowPanel
        JPanel checkboxPanelRow = new JPanel();
        checkboxPanelRow.setLayout(new BoxLayout(checkboxPanelRow, BoxLayout.Y_AXIS));
        checkboxPanelRow.setOpaque(false); // Macht den Hintergrund des Checkbox-Panels transparent

        JCheckBox frontalunterrichtRow = new JCheckBox("Frontalunterricht");
        JCheckBox projektarbeitRow = new JCheckBox("Projektarbeit");
        JCheckBox gruppenarbeitRow = new JCheckBox("Gruppenarbeit");
        JCheckBox selbstlernphaseRow = new JCheckBox("Selbstlernphase");

        selbstlernphaseRow.setSelected(true);
        frontalunterrichtRow.setOpaque(false); // Transparente Checkboxen
        projektarbeitRow.setOpaque(false);
        gruppenarbeitRow.setOpaque(false);
        selbstlernphaseRow.setOpaque(false);

        checkboxPanelRow.add(frontalunterrichtRow);
        checkboxPanelRow.add(projektarbeitRow);
        checkboxPanelRow.add(gruppenarbeitRow);
        checkboxPanelRow.add(selbstlernphaseRow);

        mondayGbc.gridx = 3;
        mondayGbc.weightx = 0.2;
        mondayRowPanel.add(checkboxPanelRow, mondayGbc);

        // Add the mondayRowPanel to the main panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 4; // Erstreckt sich über alle 4 Spalten des Hauptpanels
        gbc.fill = GridBagConstraints.HORIZONTAL; // Füllt die horizontale Breite
        gbc.weighty = 1.0; // Damit die Zeile vertikal expandieren kann
        add(mondayRowPanel, gbc);
    }

    private JLabel createBoldLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        return label;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Stundenplan");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new LessonPlanPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

