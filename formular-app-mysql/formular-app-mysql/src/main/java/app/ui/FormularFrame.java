package app.ui;

import javax.swing.JFrame;

import app.application.FormularService;

public class FormularFrame extends JFrame {

    public FormularFrame(FormularService service) {
        setTitle("Formularverwaltung");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(760, 460);
        setLocationRelativeTo(null);
        setContentPane(new FormularPanel(service));
    }
}
