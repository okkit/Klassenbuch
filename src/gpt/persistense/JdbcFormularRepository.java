package gpt.persistense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import gpt.domain.Formular;

public class JdbcFormularRepository implements FormularRepository {

    public JdbcFormularRepository() {
        createTableIfNecessary();
    }

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

    private void createTableIfNecessary() {
        String sql = """
                CREATE TABLE IF NOT EXISTS formular (
                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                    titel VARCHAR(255) NOT NULL,
                    beschreibung CLOB NOT NULL,
                    newsletter BOOLEAN NOT NULL,
                    datenschutz_akzeptiert BOOLEAN NOT NULL,
                    kategorie VARCHAR(50) NOT NULL
                )
                """;

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("Datenbank konnte nicht initialisiert werden.", e);
        }
    }
}
