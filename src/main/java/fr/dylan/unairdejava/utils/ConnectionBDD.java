package fr.dylan.unairdejava.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionBDD {

    boolean connected = false;

    public void getConnection() {
        String db = "a_tune_of_java_db";
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/" + db;

        try {
            System.out.println(url);
            Connection databaseLink = DriverManager.getConnection(url, user, password);
            System.out.println("Connected");
            connected = true;

        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Erreur de connection");
        }

    }

    public boolean isConnected() {
        return connected;
    }

    public ConnectionBDD() {
        getConnection();
    }

}