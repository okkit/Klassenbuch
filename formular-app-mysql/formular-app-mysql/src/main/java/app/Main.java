package app;

import javax.swing.SwingUtilities;

import app.application.FormularService;
import app.persistence.FormularRepository;
import app.persistence.JdbcFormularRepository;
import app.ui.FormularFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormularRepository repository = new JdbcFormularRepository();
            FormularService service = new FormularService(repository);

            FormularFrame frame = new FormularFrame(service);
            frame.setVisible(true);
        });
    }
}
