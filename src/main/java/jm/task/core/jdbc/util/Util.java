package jm.task.core.jdbc.util;

import javax.sql.DataSource;

import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/javadb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";




    public static Connection connection;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        if (!connection.isClosed()) {
            System.out.println("Соединение установлено!!!");
        }
        return connection;
    }
}
