package gui.gpt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.jcalendar.pane.calendar.CalendarPane;

public class StundenplanPanel extends JPanel {

    public StundenplanPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(235, 235, 235));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        add(createHeader(), BorderLayout.NORTH);
        add(createContentRow(), BorderLayout.CENTER);
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new GridLayout(1, 3));
        header.setBackground(new Color(230, 230, 230));
        header.setBorder(new EmptyBorder(8, 12, 8, 12));

        JLabel lblTag = new JLabel("Tag");
        JLabel lblDatum = new JLabel("Datum");
        JLabel lblInhalt = new JLabel("Inhalt");

        lblTag.setFont(lblTag.getFont().deriveFont(Font.BOLD));
        lblDatum.setFont(lblDatum.getFont().deriveFont(Font.BOLD));
        lblInhalt.setFont(lblInhalt.getFont().deriveFont(Font.BOLD));

        header.add(lblTag);
        header.add(lblDatum);
        header.add(lblInhalt);

        return header;
    }

    private JPanel createContentRow() {
        JPanel row = new JPanel(new GridBagLayout());
        row.setBackground(Color.WHITE);
        row.setBorder(BorderFactory.createLineBorder(new Color(210, 210, 210)));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 12, 10, 12);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.BOTH;

        // Spalte 1: Tag
        JLabel lblMontag = new JLabel("Montag");
        lblMontag.setFont(lblMontag.getFont().deriveFont(Font.BOLD));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.15;
//        gbc.weighty = 1.0;
//        row.add(lblMontag, gbc);

        // Spalte 2: Datum
//        JLabel lblDatum = new JLabel("13.04.2026");
//
//        gbc.gridx = 1;
//        gbc.weightx = 0.15;
//        row.add(lblDatum, gbc);
        
     // Datum als Kalender-Komponente
        CalendarPane dateChooser = new CalendarPane();
//        JDateChooser dateChooser = new JDateChooser();
//        dateChooser.setDateFormatString("dd.MM.yyyy");
        dateChooser.setPreferredSize(new Dimension(140, 400));

        gbc.gridx = 1;
        gbc.weightx = 0.15;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        row.add(dateChooser, gbc);

        // Spalte 3: Inhalt + Checkboxes
        JPanel contentPanel = new JPanel(new BorderLayout(20, 0));
        contentPanel.setOpaque(false);

        JTextArea txtInhalt = new JTextArea(
                "Wiederholung: Objekt-Klasse-Instanz.\n" +
                "Erstellen eines Dokuments mit den Unterrichtsinhalten in Microsoft Word.\n\n" +
                "Weitere Objekte im Projekt „Klassenbuch“ erstellen und testen."
        );
        txtInhalt.setEditable(true);
        txtInhalt.setLineWrap(true);
        txtInhalt.setWrapStyleWord(true);
        txtInhalt.setOpaque(false);
        txtInhalt.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JPanel checkPanel = new JPanel();
        checkPanel.setOpaque(false);
        checkPanel.setLayout(new BoxLayout(checkPanel, BoxLayout.Y_AXIS));

        JCheckBox cbFrontal = new JCheckBox("Frontalunterricht");
        JCheckBox cbProjekt = new JCheckBox("Projektarbeit");
        JCheckBox cbGruppen = new JCheckBox("Gruppenarbeit");
        JCheckBox cbSelbst = new JCheckBox("Selbstlernphase");

        cbFrontal.setOpaque(false);
        cbProjekt.setOpaque(false);
        cbGruppen.setOpaque(false);
        cbSelbst.setOpaque(false);

        cbSelbst.setSelected(true);

        checkPanel.add(cbFrontal);
        checkPanel.add(cbProjekt);
        checkPanel.add(cbGruppen);
        checkPanel.add(cbSelbst);

        contentPanel.add(txtInhalt, BorderLayout.CENTER);
        contentPanel.add(checkPanel, BorderLayout.EAST);

        gbc.gridx = 2;
        gbc.weightx = 0.7;
        row.add(contentPanel, gbc);

        return row;
    }

    // Test
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JPanel Beispiel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1000, 220);
            frame.setLocationRelativeTo(null);
            frame.setContentPane(new StundenplanPanel());
            frame.setVisible(true);
        });
    }
}
