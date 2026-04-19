package app.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/formulardb?useSSL=false&serverTimezone=Europe/Berlin";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private ConnectionFactory() {
    }

    public static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
