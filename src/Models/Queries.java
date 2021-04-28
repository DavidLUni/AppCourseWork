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
 * @author juan
 */
public class Queries {

    public static Integer selectCountPoints() {
        Integer count = 0;
        try {
            Connection connection = DB.getConnection();

            Statement stmt;
            String stmtString = "SELECT COUNT (*) AS count_points FROM count_point;";

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(stmtString);

            System.out.println("DATABASE: Query successfully.");
            while (rs.next()) {
                count = rs.getInt("count_points");
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrafficTable.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        return count;
    }


     public static ArrayList<Integer> selectTwoAndFourWheels() {
        ArrayList<Integer> twoAndFourWheelsList = new ArrayList();
        try {
            Connection connection = DB.getConnection();

            Statement stmt;
            String stmtString = "SELECT \n" +
                            "SUM(pedal_cycles + two_wheeled_motor_vehicles) AS two_wheels,\n" +
                            "SUM(cars_and_taxis + buses_and_coaches + lgvs) AS four_wheels\n" +
                            "FROM traffic_count;";

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(stmtString);

            System.out.println("DATABASE: Query successfully.");
            while (rs.next()) {
                Integer two = rs.getInt("two_wheels");
                Integer four = rs.getInt("four_wheels");
                twoAndFourWheelsList.add(two);
                twoAndFourWheelsList.add(four);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrafficTable.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        return twoAndFourWheelsList;

    }


    public static ArrayList<String> selectCountPointAndId() {
        ArrayList<String> countPointID = new ArrayList();
        try {
            Connection connection = DB.getConnection();

            Statement stmt;
            String stmtString = "SELECT count_point_id, road_name \n" +
                                "  FROM count_point;";

            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(stmtString);

            System.out.println("DATABASE: Query successfully.");
            while (rs.next()) {
                String Countname =  rs.getInt("count_point_id") + "-" + rs.getString("road_name");
                countPointID.add(Countname);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrafficTable.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        return countPointID;
    }
    
    
    public static ArrayList<Integer> selectYears() 
    {
        ArrayList<Integer> yearList = new ArrayList();
        try {
            Connection connection = DB.getConnection();
            
            Statement stmt;
            String stmtString = "SELECT year FROM traffic_count GROUP BY year";
            
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(stmtString);
            
            System.out.println("DATABASE: Query successully.");
            while(rs.next()) 
            {
                Integer year = rs.getInt("year");
                yearList.add(year);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(TrafficTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return yearList;
    }
    
    
    public static CountPointModel selectCountPointDetails( Integer count_point_id) {
        CountPointModel countPoint = null;
        try {
            Connection connection = DB.getConnection();

            PreparedStatement stmt;
            String stmtString = "SELECT \n" +
                                "    count_point_id,\n" +
                                "    road_name,\n" +
                                "    road_type,\n" +
                                "    latitude,\n" +
                                "    longitude\n" +
                                "  FROM count_point\n" +
                                "  WHERE count_point_id = ?";

            stmt = connection.prepareStatement(stmtString);
            stmt.setInt(1, count_point_id);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                countPoint = new CountPointModel();
                
                countPoint.setCount_point_id(rs.getInt("count_point_id"));
                countPoint.setRoad_name(rs.getString("road_name"));
                countPoint.setRoad_type(rs.getString("road_type"));
                countPoint.setLatitude(rs.getDouble("latitude"));
                countPoint.setLongitude(rs.getDouble("longitude"));
            }

            
            
        } catch (SQLException ex) {
            Logger.getLogger(TrafficTable.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        return countPoint;
    }

    
   
    public static TrafficCountModel selectTotalVehiclesByTypeInAYear( Integer count_point_id, Integer year) {
        
        TrafficCountModel model = null;
        try {
            Connection connection = DB.getConnection();

            PreparedStatement stmt;
            String stmtString = "SELECT\n" +
                            "    SUM(pedal_cycles) AS pedal_cycles,\n" +
                            "    SUM(two_wheeled_motor_vehicles) AS two_wheeled_motor_vehicles,\n" +
                            "    SUM(cars_and_taxis) AS cars_and_taxis, \n" +
                            "    SUM(buses_and_coaches) As buses_and_coaches, \n" +
                            "    SUM(lgvs) AS lgvs \n" +
                            "    FROM traffic_count \n" +
                            "    WHERE year = ? \n" +
                            "    AND count_point_id = ?;";

            stmt = connection.prepareStatement(stmtString);
            stmt.setInt(1, year);
            stmt.setInt(2, count_point_id);
            ResultSet rs = stmt.executeQuery();

            System.out.println("DATABASE: Query successfully.");
            while (rs.next()) {
               
                model = new TrafficCountModel();
                
                model.setPedal_cycles(rs.getInt("pedal_cycles"));
                model.setTwo_wheeled_motor_vehicles(rs.getInt("two_wheeled_motor_vehicles"));
                model.setCars_and_taxis(rs.getInt("cars_and_taxis"));
                model.setBuses_and_coaches(rs.getInt("buses_and_coaches"));
                model.setLgvs(rs.getInt("lgvs"));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrafficTable.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        return model;
     
    }
    
    public static ArrayList<TrafficCountModel> selectVehiclesDirectionInYear( Integer count_point_id, Integer year) {
        
        ArrayList<TrafficCountModel> list = new  ArrayList<>();
        try {
            Connection connection = DB.getConnection();

            PreparedStatement stmt;
            String stmtString = "SELECT \n" +
                                "    direction_of_travel,\n" +
                                "    SUM(\n" +
                                "      pedal_cycles + \n" +
                                "      two_wheeled_motor_vehicles + \n" +
                                "      cars_and_taxis + \n" +
                                "      buses_and_coaches + \n" +
                                "      lgvs) AS total\n" +
                                "    FROM traffic_count\n" +
                                "    WHERE year = ? \n" +
                                "    AND count_point_id = ?\n" +
                                "    GROUP BY direction_of_travel;";

            stmt = connection.prepareStatement(stmtString);
            stmt.setInt(1, year);
            stmt.setInt(2, count_point_id);
            ResultSet rs = stmt.executeQuery();

            System.out.println("DATABASE: Query successfully.");
            while (rs.next()) {
               TrafficCountModel model = new TrafficCountModel();
                
                model.setDirection_of_travel(rs.getString("direction_of_travel"));
                model.setTotal(rs.getInt("total"));
                list.add(model);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrafficTable.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        return list;
     
    }

    public static ArrayList<TrafficCountModel> selectVehicleTypeByTimeYear( Integer count_point_id, Integer year) {
        
        ArrayList<TrafficCountModel> list = new  ArrayList<>();
        try {
            Connection connection = DB.getConnection();

            PreparedStatement stmt;
            String stmtString = "SELECT\n" +
                                "    hour,\n" +
                                "    SUM(pedal_cycles) AS pedal_cycles,\n" +
                                "    SUM(two_wheeled_motor_vehicles) AS two_wheeled_motor_vehicles,\n" +
                                "    SUM(cars_and_taxis) AS cars_and_taxis,\n" +
                                "    SUM(buses_and_coaches) As buses_and_coaches,\n" +
                                "    SUM(lgvs) AS lgvs\n" +
                                "    FROM traffic_count\n" +
                                "    WHERE count_point_id = ? \n" +
                                "    AND year = ? \n" +
                                "    GROUP BY hour;";

            stmt = connection.prepareStatement(stmtString);
            stmt.setInt(2, year);
            stmt.setInt(1, count_point_id);
            ResultSet rs = stmt.executeQuery();

            System.out.println("DATABASE: Query successfully.");
            while (rs.next()) {
               TrafficCountModel model = new TrafficCountModel();
                
                model.setHour(rs.getInt("hour"));
                model.setPedal_cycles(rs.getInt("pedal_cycles"));
                model.setTwo_wheeled_motor_vehicles(rs.getInt("two_wheeled_motor_vehicles"));
                model.setCars_and_taxis(rs.getInt("cars_and_taxis"));
                model.setBuses_and_coaches(rs.getInt("buses_and_coaches"));
                model.setLgvs(rs.getInt("lgvs"));
                list.add(model);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrafficTable.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        return list;
     
    }
    
        
    /*
    public ArrayList<Integer> selectVehicleTypeByTimeYear() {
        ArrayList<Integer> vehicleTypeByTimeYearList = new ArrayList();
        try {
            Connection connection = DB.getConnection();

            Statement stmt;
            String stmtString = "* SELECT\n" + "    hour,\n" +
            "
SUM(pedal_cycles) AS pedal_cycles,\n
            " +"
SUM(two_wheeled_motor_vehicles) AS two_wheeled_motor_vehicles\n
            " +"
SUM(cars_and_taxis) AS cars_and_taxis,\n
            " +"    SUM(buses_and_taxis)
            As buses_and_taxis,\n
            " +"    SUM(lgvs) AS lgvs\n
            " +"    FROM traffic_count\n
            " +"    WHERE count_point_id = id \n
            " +"    AND year
                    = 2020\n
            " +"    GROUP BY hour
            ";

           stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(stmtString);

            System.out.println("DATABASE: Query successfully.");
            while (rs.next()) {
                Integer vehicleTypeByTimeYear
                        = rs.getInt("vehicleTypeByTimeYear ");
                vehicleTypeByTimeYearList.add(vehicleTypeByTimeYear);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrafficTable.class.getName()).log(Level.SEVERE,
                    null, ex);
        }

        return vehicleTypeByTimeYearList;
    }
}
    
    */
}
