package gui.sandbox;

import javax.swing.JCheckBox;

public class MyCheckBox extends JCheckBox implements GUIConstants{

	public MyCheckBox(String text) {
		super(text);
		setFont(FONT);
		setForeground(SCHRIFT_COLOR);
	}
}
