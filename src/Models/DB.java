/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mohamedhassan
 */
public class DB {
    public static Connection getConnection() throws SQLException
    {
        String urlSQLite = "jdbc:sqlite:db.db"; 
    
    
        try
        {
        
            Driver driverSQLite = new org.sqlite.JDBC();
            DriverManager.registerDriver(driverSQLite);
            System.out.println("SQLite Driver loaded up");
        }
        catch(SQLException e)
        {
            System.out.println("Problem with SQLite Driver: " + e.getMessage());
        }
        
        Connection connection = null;
        try
        {
        
         connection = DriverManager.getConnection(urlSQLite);
         System.out.println("Connected to the database!");
        }
        catch(Exception e)
        {
            System.out.println("Error connection to the database: "+ e.getMessage());
        } 
        
        return connection;
    }        
    
}

