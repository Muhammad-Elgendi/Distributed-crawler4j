/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jadeapplication;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author muhammad
 */
public class DBController {

    Statement s;
    
       public void insert(String str) {
        try {
            s = DBConnection.getConnection().createStatement();

            s.executeUpdate("insert into backlinks values ('" + str +"')");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
