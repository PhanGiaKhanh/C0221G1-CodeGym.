package model.repository;

import model.bean.contract.AttachService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ATTACH = "select * from attach_service;";

    public List<AttachService> findAll() {
        List<AttachService> list = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ATTACH);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("attach_service_id");
                String name = rs.getString("attach_service_name");
                double cost = rs.getDouble("attach_service_cost");
                int unit = rs.getInt("attach_service_unit");
                String status = rs.getString("attach_service_status");
                AttachService attachService = new AttachService(id, name, cost, unit, status);
                list.add(attachService);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
