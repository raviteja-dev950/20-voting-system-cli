package com.raviteja.voting.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USER = "voting_user";
    private static final String PASSWORD = "voting123";

    public static Connection getConnection() {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
        }

        return null;
    }
}