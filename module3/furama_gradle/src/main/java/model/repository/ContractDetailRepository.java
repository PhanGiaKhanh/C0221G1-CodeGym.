package model.repository;

import model.bean.contract.AttachService;
import model.bean.contract.ContractDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String INSERT_CONTRACT_DETAIL = "insert into contract_detail " +
            "(contract_id, attach_service_id, quantity) " +
            "values (?, ?, ?)";
    private static final String SELECT_ALL = "select * from contract_detail;";

    public List<ContractDetail> findAll() {
        List<ContractDetail> list = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("contract_detail_id");
                int conId = rs.getInt("contract_id");
                int attId = rs.getInt("attach_service_id");
                int quantity = rs.getInt("quantity");
                ContractDetail contractDetail = new ContractDetail(id, conId, attId, quantity);
                list.add(contractDetail);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    public boolean insert(ContractDetail contractDetail){
        boolean isInsert = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT_DETAIL);
            preparedStatement.setInt(1, contractDetail.getContractId());
            preparedStatement.setInt(2, contractDetail.getAttachServiceID());
            preparedStatement.setInt(3, contractDetail.getQuantity());
            isInsert = preparedStatement.executeUpdate() > 0;

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isInsert;
    }
}
