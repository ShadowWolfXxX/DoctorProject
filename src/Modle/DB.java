/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class DB {

    private static DB db;

    private DB() {
    }

    public static DB getinstend() {
        if (db == null) {
            db = new DB();
            return db;

        } else {
            return db;

        }

    }
    
    public Connection getConntectin() throws SQLException {
        String url1 = "jdbc:mysql://127.0.0.1:3306/clinic_appointment?serverTimezone=UTC";
            String usernameD = "root";
            String passwordD = "";
     Connection   c =  DriverManager.getConnection(url1, usernameD, passwordD);
     return c;
    }

}
