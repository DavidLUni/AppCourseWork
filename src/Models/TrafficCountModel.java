/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author 
 */
public class TrafficCountModel {
    Integer id;
    Integer count_point_id;
    Integer hour;
    String direction_of_travel;
    Integer year;
    String count_date;
    Integer pedal_cycles;
    Integer two_wheeled_motor_vehicles;
    Integer cars_and_taxis;
    Integer buses_and_coaches;
    Integer lgvs;
    Integer total;

    public TrafficCountModel() {
    }

    public TrafficCountModel(Integer id, Integer count_point_id, Integer hour, String direction_of_travel, Integer year, String count_date, Integer pedal_cycles, Integer two_wheeled_motor_vehicles, Integer cars_and_taxis, Integer buses_and_coaches, Integer lgvs) {
        this.id = id;
        this.count_point_id = count_point_id;
        this.hour = hour;
        this.direction_of_travel = direction_of_travel;
        this.year = year;
        this.count_date = count_date;
        this.pedal_cycles = pedal_cycles;
        this.two_wheeled_motor_vehicles = two_wheeled_motor_vehicles;
        this.cars_and_taxis = cars_and_taxis;
        this.buses_and_coaches = buses_and_coaches;
        this.lgvs = lgvs;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCount_point_id() {
        return count_point_id;
    }

    public Integer getHour() {
        return hour;
    }

    public String getDirection_of_travel() {
        return direction_of_travel;
    }

    public Integer getYear() {
        return year;
    }

    public String getCount_date() {
        return count_date;
    }

    public Integer getPedal_cycles() {
        return pedal_cycles;
    }

    public Integer getTwo_wheeled_motor_vehicles() {
        return two_wheeled_motor_vehicles;
    }

    public Integer getCars_and_taxis() {
        return cars_and_taxis;
    }

    public Integer getBuses_and_coaches() {
        return buses_and_coaches;
    }

    public Integer getLgvs() {
        return lgvs;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCount_point_id(Integer count_point_id) {
        this.count_point_id = count_point_id;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public void setDirection_of_travel(String direction_of_travel) {
        this.direction_of_travel = direction_of_travel;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setCount_date(String count_date) {
        this.count_date = count_date;
    }

    public void setPedal_cycles(Integer pedal_cycles) {
        this.pedal_cycles = pedal_cycles;
    }

    public void setTwo_wheeled_motor_vehicles(Integer two_wheeled_motor_vehicles) {
        this.two_wheeled_motor_vehicles = two_wheeled_motor_vehicles;
    }

    public void setCars_and_taxis(Integer cars_and_taxis) {
        this.cars_and_taxis = cars_and_taxis;
    }

    public void setBuses_and_coaches(Integer buses_and_coaches) {
        this.buses_and_coaches = buses_and_coaches;
    }

    public void setLgvs(Integer lgvs) {
        this.lgvs = lgvs;
    }

    @Override
    public String toString() {
        return "TrafficCountModel{" + "id=" + id + ", count_point_id=" + count_point_id + ", hour=" + hour + ", direction_of_travel=" + direction_of_travel + ", year=" + year + ", count_date=" + count_date + ", pedal_cycles=" + pedal_cycles + ", two_wheeled_motor_vehicles=" + two_wheeled_motor_vehicles + ", cars_and_taxis=" + cars_and_taxis + ", buses_and_coaches=" + buses_and_coaches + ", lgvs=" + lgvs + ", total=" + total + '}';
    }


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
    
    
    
}
