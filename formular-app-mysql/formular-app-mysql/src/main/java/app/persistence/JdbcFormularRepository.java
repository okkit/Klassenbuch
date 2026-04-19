package app.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.domain.Formular;

public class JdbcFormularRepository implements FormularRepository {

    @Override
    public void save(Formular formular) {
        String sql = """
                INSERT INTO formular
                (titel, beschreibung, newsletter, datenschutz_akzeptiert, kategorie)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection connection = ConnectionFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, formular.getTitel());
            statement.setString(2, formular.getBeschreibung());
            statement.setBoolean(3, formular.isNewsletter());
            statement.setBoolean(4, formular.isDatenschutzAkzeptiert());
            statement.setString(5, formular.getKategorie());
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Datenbankfehler beim Speichern des Formulars.", e);
        }
    }
}
