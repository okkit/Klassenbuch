package gpt.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gpt.application.FormularInput;
import gpt.application.FormularService;
import gpt.application.ValidationException;

public class FormularPanel extends JPanel {

    private final JTextField txtTitel = new JTextField(28);
    private final JTextArea txtBeschreibung = new JTextArea(7, 28);
    private final JCheckBox chkNewsletter = new JCheckBox("Newsletter abonnieren");
    private final JCheckBox chkDatenschutz = new JCheckBox("Datenschutz akzeptiert");
    private final JComboBox<String> cmbKategorie = new JComboBox<>(new String[] {
            "", "STANDARD", "WICHTIG", "SUPPORT", "INFO"
    });
    private final JButton btnSpeichern = new JButton("Speichern");
    private final JButton btnLoeschen = new JButton("Löschen");

    private final FormularService service;

    public FormularPanel(FormularService service) {
        this.service = service;

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        gbc.gridx = 0;
        gbc.gridy = row;
        formPanel.add(new JLabel("Titel:"), gbc);

        gbc.gridx = 1;
        formPanel.add(txtTitel, gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        formPanel.add(new JLabel("Beschreibung:"), gbc);

        txtBeschreibung.setLineWrap(true);
        txtBeschreibung.setWrapStyleWord(true);
        gbc.gridx = 1;
        formPanel.add(new JScrollPane(txtBeschreibung), gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(new JLabel("Optionen:"), gbc);

        JPanel checkboxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        checkboxPanel.add(chkNewsletter);
        checkboxPanel.add(chkDatenschutz);

        gbc.gridx = 1;
        formPanel.add(checkboxPanel, gbc);

        row++;
        gbc.gridx = 0;
        gbc.gridy = row;
        formPanel.add(new JLabel("Kategorie:"), gbc);

        gbc.gridx = 1;
        formPanel.add(cmbKategorie, gbc);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnLoeschen);
        buttonPanel.add(btnSpeichern);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        registerActions();
    }

    private void registerActions() {
        btnSpeichern.addActionListener(e -> speichern());
        btnLoeschen.addActionListener(e -> formularLeeren());
    }

    private void speichern() {
        try {
            validatePflichtfelder();

            FormularInput input = new FormularInput(
                    txtTitel.getText().trim(),
                    txtBeschreibung.getText().trim(),
                    chkNewsletter.isSelected(),
                    chkDatenschutz.isSelected(),
                    (String) cmbKategorie.getSelectedItem());

            service.speichern(input);

            JOptionPane.showMessageDialog(
                    this,
                    "Formular wurde erfolgreich gespeichert.",
                    "Erfolg",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (ValidationException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Validierungsfehler",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Fehler beim Speichern: " + ex.getMessage(),
                    "Fehler",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validatePflichtfelder() {
        if (txtTitel.getText() == null || txtTitel.getText().trim().isEmpty()) {
            throw new ValidationException("Das Feld 'Titel' darf nicht leer sein.");
        }

        if (txtBeschreibung.getText() == null || txtBeschreibung.getText().trim().isEmpty()) {
            throw new ValidationException("Das Feld 'Beschreibung' darf nicht leer sein.");
        }

        Object kategorie = cmbKategorie.getSelectedItem();
        if (kategorie == null || kategorie.toString().trim().isEmpty()) {
            throw new ValidationException("Bitte wählen Sie eine Kategorie aus.");
        }
    }

    private void formularLeeren() {
        txtTitel.setText("");
        txtBeschreibung.setText("");
        chkNewsletter.setSelected(false);
        chkDatenschutz.setSelected(false);
        cmbKategorie.setSelectedIndex(0);
    }
}

