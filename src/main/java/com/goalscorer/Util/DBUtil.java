package com.goalscorer.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static String url = "jdbc:mysql://localhost:3306/";
    private static String username = "root";
    private static String password = "ritiksql";
    private static String db = "score";
    static {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url + db, username, password);
    }

}
