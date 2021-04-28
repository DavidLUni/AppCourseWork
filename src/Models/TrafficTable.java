/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohamedhassan
 */
public class TrafficTable {

    
    public static void insertCountPoint(
            Integer count_point_id, 
            String region_name,
            String local_authority_name,
            String road_type,
            String road_name,
            Double latitude,
            Double longitude
            ) 
    {
        
        Connection conn = Connect.getConnection();
        PreparedStatement stmt;
        String createString;

        createString = "INSERT INTO count_point ("
                + "count_point_id, "
                + "region_name,"
                + "local_authority_name,"
                + "road_name,"
                + "road_type,"
                + "latitude,"
                + "longitude)"
                + " VALUES (?,?,?,?,?,?,?);";

        try {
            stmt = conn.prepareStatement(createString);
            stmt.setInt(1, count_point_id);
            stmt.setString(2, region_name);
            stmt.setString(3, local_authority_name);
            stmt.setString(4, road_name);
            stmt.setString(5, road_type);
            stmt.setDouble(6, latitude);
            stmt.setDouble(7, longitude);

            stmt.executeUpdate();
            System.out.println("DATABASE: countpoint successfully created ");
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("DATABASE: countpoint error to create.");
 
        }
}
    
    
    public static void batchCountPoint(ArrayList<String> input)
    {
        
        for (String currentLine : input)
        {
            String[] lineArray = currentLine.split(",");
            
            Integer count_point_id = Integer.parseInt(lineArray[0]);
            String region_name = lineArray[1];
            String local_authority_name = lineArray[2];
            String road_name = lineArray[3];
            String road_type = lineArray[4];
            Double latitude = Double.parseDouble(lineArray[5]);
            Double longitude = Double.parseDouble(lineArray[6]);
          
            insertCountPoint(
                    count_point_id, 
                    region_name, 
                    local_authority_name, 
                    road_type, 
                    road_name, 
                    latitude, 
                    longitude);
            
  
            //insert(count_point_id,direction_of_travel,year,count_date ,hour, region_name,local_authority_name,road_name,latitude,longitude,pedal_cycles,two_wheeled_motor_vehicles,cars_and_taxes,buses_and_coaches,lgvs);
            
        }
    }
    
    
    public static void insertTrafficCount(
            Integer count_point_id, 
            Integer hour,
            String direction_of_travel,
            Integer year,
            String count_date,
            Integer pedal_cycles,
            Integer two_wheeled_motor_vehicles,
            Integer cars_and_taxis,
            Integer buses_and_coaches,
            Integer lgvs
            ) 
    {
        
        Connection conn = Connect.getConnection();
        PreparedStatement stmt;
        String createString;

        createString = "INSERT INTO traffic_count ("
                + "count_point_id, "
                + "hour,"
                + "direction_of_travel,"
                + "year,"
                + "count_date,"
                + "pedal_cycles,"
                + "two_wheeled_motor_vehicles,"
                + "cars_and_taxis,"
                + "buses_and_coaches,"
                + "lgvs)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?);";

        try {
            stmt = conn.prepareStatement(createString);
            stmt.setInt(1, count_point_id);
            stmt.setInt(2, hour);
            stmt.setString(3, direction_of_travel);
            stmt.setInt(4, year);
            stmt.setString(5, count_date);
            stmt.setInt(6, pedal_cycles);
            stmt.setInt(7, two_wheeled_motor_vehicles);
            stmt.setInt(8, cars_and_taxis);
            stmt.setInt(9, buses_and_coaches);
            stmt.setInt(10, lgvs);

            stmt.executeUpdate();
            System.out.println("DATABASE: countpoint successfully created ");
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("DATABASE: countpoint error to create.");
 
        } 
    
    }
    
    public static void batchTrafficCount(ArrayList<String> input)
    {
        
        for (String currentLine : input)
        {
            String[] lineArray = currentLine.split(",");
            
            
            Integer count_point_id = Integer.parseInt(lineArray[0]);
            Integer hour = Integer.parseInt(lineArray[7]);
            String direction_of_travel = lineArray[8];
            Integer year = Integer.parseInt(lineArray[9]);
            String count_date = lineArray[10];
            Integer pedal_cycles = Integer.parseInt(lineArray[11]);
            Integer two_wheeled_motor_vehicles = Integer.parseInt(lineArray[12]);
            Integer cars_and_taxis = Integer.parseInt(lineArray[13]);
            Integer buses_and_coaches = Integer.parseInt(lineArray[14]);
            Integer lgvs = Integer.parseInt(lineArray[15]);
            
            
            insertTrafficCount(
                    count_point_id,
                    hour, 
                    direction_of_travel, 
                    year, 
                    count_date, 
                    pedal_cycles, 
                    two_wheeled_motor_vehicles, 
                    cars_and_taxis, 
                    buses_and_coaches, 
                    lgvs);
        }
    
    }
    
    

    public static ResultSet get(int count_point_id) throws SQLException
    {
        Connection connection = DB.getConnection();
        
        String sql = "SELECT * FROM Traffic WHERE count_point_id =  " + count_point_id;
        ResultSet result = null;
        
        try 
        {
        
            Statement statement = connection.createStatement();
            result = statement.executeQuery(sql);
            
            if(result.next())
            {
                System.out.println("Traffic" + result.getString ("direction_of_travel") + " retrieved");
            }
            
        }
        catch (Exception e)
        {
            System.out.println("Error while reading from Traffic table"  + e.getMessage());
        }
        finally
        {
            return result;
        }
        
                
    }
    public static void update(int count_point_id , String direction_of_travel  , String year , String count_date, String hour , String region_name, String local_authority_name, String road_name, String latitude, String longitude, String pedal_cycles, String two_wheeled_motor_vehicles, String cars_and_taxes, String buses_and_coaches, String lgvs ){
         
        //String sql = "UPDATE Traffic SET direction_of_travel = '" +  direction_of_travel + "', year = '" + year "' count_date = '" +  count_date + "' hour = '" + hour "', region_name = '" + region_name + "' , local_authority_name = '"  + local_authority_name "',road_name = '" + road_name "', latitude = '" 
    }
    
}

