package model.repository;

import model.bean.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//Connection connection = baseRepository.connectDataBase();
//PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
public class EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();

//#region SELECT ALL
    private static final String SELECT_ALL = "select * from employee;";

    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String eCode = rs.getString("e_code");
                String eName = rs.getString("e_name");
                String birthday = rs.getString("birthday");
                Employee employee = new Employee(id, eCode,eName, birthday);
                list.add(employee);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
//#endregion

//#region INSERT
    private static final String INSERT = "insert into employee (e_code, e_name, birthday) " +
        "values (?, ?, ?);";

    public boolean insert(Employee employee) {
        boolean isInsert = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, employee.getEmCode());
            preparedStatement.setString(2, employee.getEmName());
            preparedStatement.setString(3, employee.getBirthday());
            isInsert = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInsert;
    }
//#endregion

//#region SELECT ID
    private static final String SELECT_ID = "select * from employee where id = ?;";

    public Employee findById (int id) {
        Employee employee = null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String code = rs.getString("e_code");
                String name = rs.getString("e_name");
                String birthday = rs.getString("birthday");
                employee = new Employee(id, code, name, birthday);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
//#endregion
x`
//#region UPDATE
    private static final String UPDATE_ID = "update employee set " +
        "e_code  = ?, e_name = ?, birthday = ? where id = ?";

    public boolean update(Employee employee){
        boolean isUpdate = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ID);
            preparedStatement.setString(1, employee.getEmCode());
            preparedStatement.setString(2, employee.getEmName());
            preparedStatement.setString(3, employee.getBirthday());
            preparedStatement.setInt(4, employee.getId());
            isUpdate = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdate;
    }
//#endregion

//#region
    private static final String DELETE = "delete from employee\n" +
        "where id = ?;";
    public boolean deleleById(int id){
        boolean isDel = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);
            isDel = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDel;
    }
//#endregion
}
//Connection connection = baseRepository.connectDataBase();
//PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);