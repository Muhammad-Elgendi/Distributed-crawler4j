/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeapplication;


import java.sql.*;

public class DBConnection {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/crawler?autoReconnect=true&useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL,USER,PASS);
    }
}