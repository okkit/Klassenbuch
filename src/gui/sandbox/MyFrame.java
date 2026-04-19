package gui.sandbox;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame<E> extends JFrame {

	public MyFrame() {
		super("Meine Sandbox");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(1000, 100, 400, 600);
		
		JPanel panel = new JPanel();
		add(panel);
		
		GridLayout layout = new GridLayout(0, 1);
		panel.setLayout(layout);
		Color color = new Color(143, 200, 255);
		panel.setBackground(color);
		
		Font font = new Font("Arial", Font.PLAIN, 24);
		
		// Checkbox
		JCheckBox box = new JCheckBox("Meine hübsche checkbox");
		box.setOpaque(false);
		box.setFont(font);
		panel.add(box);
		
		// Textfeld
		JTextField textfield = new JTextField("Schreibe was hinein");
		panel.add(textfield);
		textfield.setOpaque(false);
		textfield.setForeground(Color.RED);		
		textfield.setFont(font);
	
		// Label
		JLabel label = new JLabel("Mein Labelchen");
		label.setFont(font);
		panel.add(label);
		
		// Button
		JButton button = new JButton("Klick mich mal");
		button.setFont(font);
		panel.add(button);
		
		// Label (von der Klasse MyLabel)
		MyLabel myL = new MyLabel("Label gemacht aus MyLabel");
		panel.add(myL);
		
		// Combobox (auswählbare Liste)
		String[] students = {"Ada", "Boris", "Cesar"};
		JComboBox<String> combobox = new JComboBox<String>(students);
		combobox.setFont(font);
		panel.add(combobox);
		
		// Radiobuttons
		JRadioButton radio1 = new JRadioButton("Radio WDR2");
		JRadioButton radio2 = new JRadioButton("Radio Köln");
		ButtonGroup group = new ButtonGroup();
		group.add(radio1);
		group.add(radio2);
		panel.add(radio1);
		panel.add(radio2);
		
		
		// TextArea
		JTextArea textarea = new JTextArea("Mehrzeiliges Textfeld");
		textarea.setFont(font);
		textarea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		ScrollPane sp = new ScrollPane();
		sp.add(textarea);
		panel.add(sp);
		
		// Tabelle
		String[] columnNames = {"Datum", "Gruppe", "Dozent", "Inhalt"};
		Object[][] data = {
			{"2026-04-15", "AE-23", "Herr Schmidt", "Java Swing Grundkurs"},
			{"2026-04-16", "FI-22", "Frau Müller", "Datenbank Design"}
		};
 
		JTable table = new JTable(data, columnNames);
		table.setRowHeight(30);
			
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
				
		// setVisible muss immer am Ende des Konstruktors stehen.
		// Sonst könnte das GUI falsch angezeigt werden.
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
