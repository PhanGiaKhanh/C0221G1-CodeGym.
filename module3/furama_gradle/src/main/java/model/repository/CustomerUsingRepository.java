package model.repository;

import model.bean.customer.CustomerUsing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUsingRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_CUSTOMER_USING = "select * from customer_use_service;";
    private static final String SEARCH_CUSTOMER_USING = "select * from customer_use_service where customer_name like ?;";

    public List<CustomerUsing> search(String name){
        List<CustomerUsing> list = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_USING);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int conId = rs.getInt("contract_id");
                int cusId = rs.getInt("customer_id");
                int serId = rs.getInt("service_id");
                String start = rs.getString("contract_start_date");
                String end = rs.getString("contract_end_date");
                String nameSearch = rs.getString("customer_name");
                String phone = rs.getString("customer_phone");
                String serName = rs.getString("service_name");
                double cost = rs.getDouble("service_cost");
                CustomerUsing customerUsing = new CustomerUsing(conId, cusId, serId, start, end, nameSearch, phone, serName, cost);
                list.add(customerUsing);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<CustomerUsing> findAll(){
        List<CustomerUsing> list = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_USING);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int conId = rs.getInt("contract_id");
                int cusId = rs.getInt("customer_id");
                int serId = rs.getInt("service_id");
                String start = rs.getString("contract_start_date");
                String end = rs.getString("contract_end_date");
                String name = rs.getString("customer_name");
                String phone = rs.getString("customer_phone");
                String serName = rs.getString("service_name");
                double cost = rs.getDouble("service_cost");
                CustomerUsing customerUsing = new CustomerUsing(conId, cusId, serId, start, end, name, phone, serName, cost);
                list.add(customerUsing);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
