/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleProjects.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDB {

    private static java.sql.Connection con = null;

    private ConnectionDB() {
    }

    public static java.sql.Connection getInstance() {
        if (con == null) {
            try {
                Class.forName("org.gjt.mm.mysql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EPFinterview?useSSL=false", "Pule", "P.zzle$0");
            } catch (SQLException se) {
                System.out.println("driver not found" + se.getMessage());
                return null;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Connection archieved");
        return con;
    }
    
    public static void main(String[] args) {
        
    }
}

