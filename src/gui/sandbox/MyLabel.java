package gui.sandbox;

import javax.swing.JLabel;

public class MyLabel extends JLabel implements GUIConstants{
	String text;
	public MyLabel(String text) {
		super(text);
		setFont(FONT);
		setForeground(SCHRIFT_COLOR);
	}
}
