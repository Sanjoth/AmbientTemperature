/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.temperature.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Author: Sanjoth Shaw
 * Purpose: Connection Handler for JDBC MySQL connection.
 * Language:  Java
 */
public class ConnectionHandler {

    // JDBC driver name and database URL
    static final String DB_URL = "jdbc:mysql://localhost:3306/tempraturedata";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    public static Connection conn = null;
    public static void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if(conn == null){
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
