package model.repository;

import model.bean.service.RentType;
import model.bean.service.Service;
import model.bean.service.ServiceType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_ALL_SERVICE ="select * from service;";
    private static final String SELECT_RENT_TYPE = "select * from rent_type;";
    private static final String SELECT_SERVICE_TYPE = "select * from service_type;";
    private static final String SELECT_SERVICE_ID = "select * from service where service_id = ?;";
    private static final String INSERT_SERVICE = "insert into service (service_name, service_area," +
            "service_cost, service_max_people, rent_type_id, service_type_id, standard_room, " +
            "description_other_convenience, pool_area, number_of_floor) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public boolean insert(Service service){
        boolean isInsert = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE);
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getArea());
            preparedStatement.setDouble(3, service.getCost());
            preparedStatement.setInt(4, service.getMaxPeople());
            preparedStatement.setInt(5, service.getRentType());
            preparedStatement.setInt(6, service.getServiceType());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescription());
            preparedStatement.setString(9, service.getPoolArea());
            preparedStatement.setString(10, service.getNumberOfFloor());
            isInsert = preparedStatement.executeUpdate() > 0;

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInsert;
    }

    public Service findById(int id){
        Service service = null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("service_name");
                int area = rs.getInt("service_area");
                double cost = rs.getDouble("service_cost");
                int maxPeople = rs.getInt("service_max_people");
                int rentType = rs.getInt("rent_type_id");
                int serviceType = rs.getInt("service_type_id");
                String standardRoom = rs.getString("standard_room");
                String description = rs.getString("description_other_convenience");
                String pool = String.valueOf(rs.getDouble("pool_area"));
                String floor = String.valueOf(rs.getInt("number_of_floor"));
                service = new Service(id, name, area, cost, maxPeople, rentType, serviceType, standardRoom, description, pool, floor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    public List<ServiceType> findServiceType(){
        List<ServiceType> serviceTypes = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_TYPE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("service_type_id");
                String name = rs.getString("service_type_name");
                ServiceType serviceType = new ServiceType(id, name);
                serviceTypes.add(serviceType);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypes;
    }

    public List<RentType> findRentType(){
        List<RentType> rentTypes = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RENT_TYPE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("rent_type_id");
                String name = rs.getString("rent_type_name");
                double cost = rs.getDouble("rent_type_cost");
                RentType rentType = new RentType(id, name, cost);
                rentTypes.add(rentType);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentTypes;
    }

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
                String pool = String.valueOf(rs.getDouble("pool_area"));
                String floor = String.valueOf(rs.getInt("number_of_floor"));
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
