package gwenshop.com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
    public static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException
    {
        String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL = "jdbc:sqlserver://localhost:1433";
        // Database name to access
        String dbName = "GwenShop";
        String dbUsername = "sa";
        String dbPassword = "123456";
        String connectionURL = dbURL + ";databaseName=" + dbName; // +
        Connection conn = null;
        try {
            Class.forName(dbDriver);
            conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword); //
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

}
