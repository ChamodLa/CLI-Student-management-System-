package com.saegis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class DatabaseConnection {
    private static Connection connection;

    static {
        try {
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/db.properties");
            props.load(fis);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully.");
        } catch (IOException | RuntimeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed!", e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}

