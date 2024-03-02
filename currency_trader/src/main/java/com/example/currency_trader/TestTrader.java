package com.example.currency_trader;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.format.DateTimeFormatter;

public class TestTrader {
    private static String url = "jdbc:postgresql://localhost:5432/MyDB";
    private static final String USERNAME= "postgres";
    private static final String PASSWORD = "hoxa-95-hoxa";

    public static void main(String[] args) {
    }

    public static void test() {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = connect();
            connection.setSchema("currencies");
            statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("select * from \"current_currency\"");
            while (resultSet.next()){
                Date date = resultSet.getDate("date");
                String char_code = resultSet.getString("char_code");
                Float value = resultSet.getFloat("value");
                System.out.println("date: " + date + "  valute: " + char_code + "   value: " + value);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        disconnect(connection);
    }



    private static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }


    private static void disconnect(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
