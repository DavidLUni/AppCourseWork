/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author juan
 */
public class CountPointModel {
    
    Integer count_point_id;
    String region_name;
    String local_authority_name;
    String road_name;
    String road_type;
    Double latitude;
    Double longitude;

    public CountPointModel(Integer count_point_id, String region_name, String local_authority_name, String road_name, String road_type, Double latitude, Double longitude) {
        this.count_point_id = count_point_id;
        this.region_name = region_name;
        this.local_authority_name = local_authority_name;
        this.road_name = road_name;
        this.road_type = road_type;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public CountPointModel() {
    }

    public Integer getCount_point_id() {
        return count_point_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public String getLocal_authority_name() {
        return local_authority_name;
    }

    public String getRoad_name() {
        return road_name;
    }

    public String getRoad_type() {
        return road_type;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setCount_point_id(Integer count_point_id) {
        this.count_point_id = count_point_id;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public void setLocal_authority_name(String local_authority_name) {
        this.local_authority_name = local_authority_name;
    }

    public void setRoad_name(String road_name) {
        this.road_name = road_name;
    }

    public void setRoad_type(String road_type) {
        this.road_type = road_type;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "CountPointModel{" + "count_point_id=" + count_point_id + ", region_name=" + region_name + ", local_authority_name=" + local_authority_name + ", road_name=" + road_name + ", road_type=" + road_type + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }
    
    

}
