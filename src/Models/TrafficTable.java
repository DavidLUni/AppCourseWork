/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.year;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mohamedhassan
 */
public class TrafficTable {

    
    public static void insert(int count_point_id , String direction_of_travel  , String year , String count_date, String hour , String region_name, String local_authority_name, String road_name, String latitude, String longitude, String pedal_cycles, String two_wheeled_motor_vehicles, String cars_and_taxes, String buses_and_coaches, String lgvs ) throws SQLException
    {
        
        Connection connection = DB.getConnection();
        
        String sql = "INSERT INTO Traffic (count_point_id , direction_of_travel, year, count_date, hour, region_name, local_authority_name,road_name, latitude, longitude, pedal_cycles, two_wheeled_motor_vehicles, cars_and_taxes, buses_and_coaches, lgvs) VALUES "
                +"("
                +"'" + count_point_id + "',"
                +"'" + direction_of_travel+ "',"
                +"'" + year + "',"
                +"'" + count_date + "',"
                +"'" + hour + "',"
                +"'" + region_name + "',"
                +"'" + local_authority_name + "',"
                +"'" + road_name + "',"
                +"'" + latitude + "',"
                +"'" + longitude + "',"
                +"'" + pedal_cycles+ "',"
                +"'" + two_wheeled_motor_vehicles + "',"
                +"'" + cars_and_taxes + "',"
                +"'" + buses_and_coaches+ "',"
                +"'" + lgvs + "'"
                +")" ;
        
        try 
        {
        
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Traffic" + direction_of_travel + "inserted!");
        }
        catch (Exception e)
        {
            System.out.println("Error while inserting into Traffic table"  + e.getMessage());
        }
}
    
    public static void batchIntsert(ArrayList<String> input)
    {
        for (String currentLine : input)
        {
            String[] lineArray = currentLine.split(",");
            int count_point_id = Integer.parseInt(lineArray[0]);
            String direction_of_travel = lineArray[1];
            String year = lineArray[2];
            String count_date = lineArray[3];
            String hour = lineArray[4];
            String region_name = lineArray[5];
            String local_authority_name = lineArray[6];
            String road_name = lineArray[7];
            String latitude = lineArray[8];
            String longitude = lineArray[9];
            String pedal_cycles = lineArray[10];
            String two_wheeled_motor_vehicles = lineArray[11];
            String cars_and_taxes = lineArray[12];
            String buses_and_coaches = lineArray[13];
            String lgvs = lineArray[14];
            
            
            
            
            //insert(count_point_id,direction_of_travel,year,count_date ,hour, region_name,local_authority_name,road_name,latitude,longitude,pedal_cycles,two_wheeled_motor_vehicles,cars_and_taxes,buses_and_coaches,lgvs);
            
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

