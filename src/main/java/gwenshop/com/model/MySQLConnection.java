package gwenshop.com.model;


import java.sql.*;

public class MySQLConnection {
    public static Connection getMySQLConnection()
            throws SQLException, ClassNotFoundException
    {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306";
        String dbName = "gwenshop";
        String dbUsername = "root";
        String dbPassword = "phuc02012002";
        Connection conn = null;
        try {
            Class.forName(dbDriver);
            conn = (Connection) DriverManager.getConnection(dbURL, dbUsername, dbPassword);
//            PreparedStatement ps = (PreparedStatement) conn.prepareStatement("use myfirst;");
//            ps.executeUpdate();
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

}
