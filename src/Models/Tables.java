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
    
    public static void createTrafficDataTables() throws SQLException{
        
        Connection connection = DB.getConnection();
                
        String sql = "CREATE TABLE if not exists TrafficData"
                +"("
                + "count_point_id INTEGER PRIMARY KEY," 
                + "direction_of_travel VARCHAR(15)," 
                + "year VARCHAR (15),"
                + "count_date VARCHAR (15),"
                + "hour VARCHAR (15),"
                + "region_name VARCHAR (15),"
                + "local_authority_name VARCHAR (15),"
                + "road_name VARCHAR (15),"
                + "latitude VARCHAR (15),"
                + "longitude VARCHAR (15),"
                + "pedal_cycles VARCHAR (15),"
                + "two_wheeled_motor_vehicles VARCHAR (15),"
                + "cars_and_taxes VARCHAR (15),"
                + "buses_and_coaches VARCHAR (15),"
                + "lgvs VARCHAR (15)"
                + ")";
        
        
        try {
            
            Statement sqlStatement = connection.createStatement();
            sqlStatement.executeUpdate(sql);
            System.out.println("Traffic table created!");
            
        } 
        catch (Exception e)
        
        {
            System.out.println("Error creating Traffic table!" + e.getMessage());
        }
        
                
                
                
        
    }
    
} 

