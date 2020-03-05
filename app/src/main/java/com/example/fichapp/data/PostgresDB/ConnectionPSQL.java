package com.example.fichapp.data.PostgresDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPSQL {
    private Connection connection;

    public ConnectionPSQL(){
        myThread.start();
    }

    public Connection getConnection() {
        return connection;
    }

    private Thread myThread = new Thread(){
        public void run() {
            Connection conn;
            try{
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(
                        "jdbc:postgresql://192.168.0.22:5432/fichapp",
                        "maggy",
                        "hamilton"
                );
                connection = conn;
                /*Statement st = conn.createStatement();
                st.executeQuery("INSERT INTO user_table VALUES(1, 'Raul');");*/
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    };
}
