package assignment5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String URL = "jdbc:sqlite:mpj.db";

    private static final String CREATE_EMPLOYEES_TABLE = "CREATE TABLE IF NOT EXISTS employees ("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "name TEXT NOT NULL,"
            + "email TEXT NOT NULL UNIQUE,"
            + "department TEXT NOT NULL,"
            + "salary REAL NOT NULL"
            + ")";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException exception) {
            throw new SQLException("SQLite JDBC driver not found.", exception);
        }

        Connection connection = DriverManager.getConnection(URL);
        initializeSchema(connection);
        return connection;
    }

    private static void initializeSchema(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(CREATE_EMPLOYEES_TABLE);
        }
    }
}
