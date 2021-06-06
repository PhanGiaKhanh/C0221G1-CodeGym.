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
    private static final String UPDATE_CONTRACT = "update contract\n" +
            "set contract_start_date = ?, contract_end_date =?, contract_deposit = ?, contract_total_money = ?, employee_id = ?, customer_id = ?, service_id =?\n" +
            "where contract_id = ?;";
    private static final String SELECT_BY_ID = "select * from contract where contract_id = ?;";
    private static final String DELETE = "delete from contract\n" +
            "where contract_id = ?;";

    public boolean delete(int id){
        boolean isDelete = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDelete;
    }

    public Contract findById(int id) {
        Contract contract = null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String startD = rs.getString("contract_start_date");
                String endD = rs.getString("contract_end_date");
                double deposit = rs.getDouble("contract_deposit");
                double total = rs.getDouble("contract_total_money");
                int eId = rs.getInt("employee_id");
                int cId = rs.getInt("customer_id");
                int sId = rs.getInt("service_id");
                contract = new Contract(id, startD, endD, deposit, total, eId, cId, sId);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contract;
    }

    public boolean update(Contract contract){
        boolean isUpdate = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CONTRACT);
            preparedStatement.setString(1, contract.getStartDate());
            preparedStatement.setString(2, contract.getEndDate());
            preparedStatement.setDouble(3, contract.getDeposit());
            preparedStatement.setDouble(4, contract.getTotalMoney());
            preparedStatement.setInt(5, contract.getEmployeeId());
            preparedStatement.setInt(6, contract.getCustomerId());
            preparedStatement.setInt(7, contract.getServiceId());
            preparedStatement.setInt(8, contract.getId());
            isUpdate = preparedStatement.executeUpdate() > 0;

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdate;
    }

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
