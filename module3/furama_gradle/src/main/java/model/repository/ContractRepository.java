package model.repository;

import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    BaseRepository baseRepository = new BaseRepository();

    private static final String INSERT_CONTRACT = "insert into contract (" +
            "contract_start_date, contract_end_date, contract_deposit, contract_total_money, " +
            "employee_id, customer_id, service_id) " +
            "values (?, ?, ?, ?, ?, ?, ? );";
    private static final String SELECT_ALL = "select * from contract;";

    public List<Contract> findAll(){
        List<Contract> list = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("contract_id");
                String start = rs.getString("contract_start_date");
                String end = rs.getString("contract_end_date");
                double deposit = rs.getDouble("contract_deposit");
                double total = rs.getDouble("contract_total_money");
                int eId = rs.getInt("employee_id");
                int cId = rs.getInt("customer_id");
                int sId = rs.getInt("service_id");
                Contract contract = new Contract(id, start, end, deposit, total, eId, cId, sId);
                list.add(contract);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertContract(Contract contract) {
        boolean isInsert = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CONTRACT);
            preparedStatement.setString(1, contract.getStartDate());
            preparedStatement.setString(2, contract.getEndDate());
            preparedStatement.setDouble(3, contract.getDeposit());
            preparedStatement.setDouble(4, contract.getTotalMoney());
            preparedStatement.setInt(5, contract.getEmployeeId());
            preparedStatement.setInt(6, contract.getCustomerId());
            preparedStatement.setInt(7, contract.getServiceId());
            isInsert = preparedStatement.executeUpdate() > 0;

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isInsert;
    }

}
