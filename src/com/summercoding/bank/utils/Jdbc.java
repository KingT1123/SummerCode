/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cynthiaabi
 */
public class Jdbc {
    private final static String URL = "jdbc:mysql://localhost:3306/summerbankdb"; //protocole, adresse serveur, port
    
    private final static String USER = "root";
    
    private final static String PASSWORD = "";
    
    public static Connection getConnexion() {
        try {
            Connection connexion = null; 
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");  //method to dynamically load the MySQL JDBC driver
            
            return  (Connection) DriverManager.getConnection(URL,USER,PASSWORD); //The code attempts to establish a connection to the database using the DriverManager.getConnection() method,
                                                                                                 //passing the URL, username, and password as arguments. 
                                                                                                 //The getConnection() method returns a connection object if the connection is successful.
        } 
        
        catch (ClassNotFoundException ex) {  //this exception is thrown when the class "com.mysql.jdbc.Driver is not found"
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex); //by logging the exception, you capture the spefic error such as the class that was not found
        } 
        
        catch (SQLException ex) { //This exception is thrown when an error occurs in the SQL statements or the database connection
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex); //logging the exceptions helps get specific details about the error
        }
        //Once the exception is logged, the catch block does not perform any additional actions, and the control flows out of the catch block
                    
        return null;
    }
        
            
    
}
