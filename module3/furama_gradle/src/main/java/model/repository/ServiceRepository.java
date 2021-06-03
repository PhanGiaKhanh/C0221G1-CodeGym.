package model.repository;

import model.bean.service.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_SERVICE ="select * from service;";

    public List<Service> findByAll(){
        List<Service> services = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try{
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_SERVICE);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("service_id");
                String name = rs.getString("service_name");
                int area = rs.getInt("service_area");
                double cost = rs.getDouble("service_cost");
                int maxPeople = rs.getInt("service_max_people");
                int rentType = rs.getInt("rent_type_id");
                int serviceType = rs.getInt("service_type_id");
                String standardRoom = rs.getString("standard_room");
                String description = rs.getString("description_other_convenience");
                double pool = rs.getDouble("pool_area");
                int floor = rs.getInt("number_of_floor");
                Service service = new Service(id, name, area, cost, maxPeople, rentType, serviceType, standardRoom, description, pool, floor);
                services.add(service);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return services;
    }

}
