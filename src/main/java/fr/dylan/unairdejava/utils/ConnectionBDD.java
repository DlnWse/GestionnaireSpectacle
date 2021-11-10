package fr.dylan.unairdejava.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBDD {

    private Connection connection;
    private boolean connected = false;

    public void openConnection() {
        String db = "a_tune_of_java_db";
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/" + db;

        try {
            System.out.println(url);
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
            connected = true;

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Erreur de connection");
        }
    }

    public void closeConnection() {
        try {
            connection.close();
            connected = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        return connected;
    }

    public Connection getConnection() {return connection;}

    public ConnectionBDD() {
        openConnection();
    }

}