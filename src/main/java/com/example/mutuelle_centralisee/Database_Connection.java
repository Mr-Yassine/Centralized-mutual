package com.example.mutuelle_centralisee;
import java.sql.Connection;
import java.sql.DriverManager;


public class Database_Connection {


    public Connection databaseLink;

    public Connection getConnection() {

        String databaseName = "client_database";
        String databaseUser = "root";
        String databasePassword = "1234";
        String url = "jdbc:mysql://localhost/" + databaseName ;



        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        }catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }




}
