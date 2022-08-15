package com.danilorocha.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todo_app";
    public static final String USER = "danilo";
    public static final String PASS = "m@nU1108";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar fazer a conexão com bando de dados: ", e);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar fechar a conexão com banco de dados", e);
        }
    }



}
