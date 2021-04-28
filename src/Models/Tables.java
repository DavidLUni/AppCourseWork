/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohamedhassan
 */
public class Tables {
    
    public static void createTrafficDataTables(){
        
        try {
            
        Connection connection = Connect.getConnection();
                
        String sql = "CREATE TABLE IF NOT EXISTS traffic_count (\n" +
                    "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "    count_point_id INTEGER NOT NULL,\n" +
                    "    hour INTEGER,\n" +
                    "    direction_of_travel TEXT,\n" +
                    "    year INTEGER,\n" +
                    "    count_date TEXT,\n" +
                    "    pedal_cycles INTEGER,\n" +
                    "    two_wheeled_motor_vehicles INTEGER,\n" +
                    "    cars_and_taxis INTEGER,\n" +
                    "    buses_and_taxis INTEGER,\n" +
                    "    lgvs INTEGER,\n" +
                    "    CONSTRAINT fk_count_point\n" +
                    "    FOREIGN KEY (count_point_id) \n" +
                    "    REFERENCES count_point (count_point_id));\n" +
                    "";
        
        

            Statement sqlStatement = connection.createStatement();
            sqlStatement.executeUpdate(sql);
            System.out.println("Traffic count created!");
            
        } 
        catch (SQLException e)
        
        {
            System.out.println("Error creating Traffic table!" + e.getMessage());
        }
        
    }
    
    
        public static void createCountPoint(){
        
        try {
        Connection connection = Connect.getConnection();
                
        String sql = "CREATE TABLE IF NOT EXISTS count_point (\n" +
            "\n" +
            "    count_point_id INTEGER NOT NULL PRIMARY KEY,\n" +
            "    region_name TEXT,\n" +
            "    local_authority_name TEXT,\n" +
            "    road_name TEXT NOT NULL,\n" +
            "    road_type TEXT NOT NULL,\n" +
            "    latitude REAL,\n" +
            "    longitude REAL,\n" +
            "    UNIQUE(count_point_id) );";
        
            Statement sqlStatement = connection.createStatement();
            sqlStatement.executeUpdate(sql);
            System.out.println("Count point table created!");
            
        } 
        catch (SQLException e)
        
        {
            System.out.println("Error creating Traffic table!" + e.getMessage());
        }

    }
    
} 

