/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author juan
 */
public class Connect 
{

    public static Connection getConnection()
    {
        try {
            String url = "jdbc:sqlite:db.db";
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(url);
            System.out.println("Connection established");
            return con;
        } catch (ClassNotFoundException | SQLException e)
        {
            System.out.println("Problem with connection to SQLite: " + e.getMessage());
            return null;
        }
        
    }
}
