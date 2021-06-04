package model.repository;

import model.bean.employee.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    private static String SELECT_ALL_EMPLOYEE = "select * from employee;";
    private static String SELECT_ALL_DIVISION = "select * from division;";
    private static String SELECT_ALL_POSITION = "select * from position;";
    private static String SELECT_ALL_DEGREE = "select * from education_degree;";
    private static String INSERT_EMPLOYEE = "insert into employee (" +
            "employee_name, position_id, education_degree_id, division_id, " +
            "employee_birthday, employee_id_card, employee_salary, " +
            "employee_phone, employee_email, employee_address, username) values" +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private static String INSERT_USER = "insert into `user` (username, password )values (?, ?);";
    private static String SELECT_EMPLOYEE = "select * from employee where employee_id = ?;";
    private static String SET_EMPLOYEE = "update employee \n" +
            "set employee_name=? ,employee_birthday=?, employee_id_card = ?, employee_salary= ?,\n" +
            "employee_phone = ?, employee_email =?, employee_address = ?, position_id =?,\n" +
            "education_degree_id =?, division_id =?\n" +
            "where employee_id = ?;";
    private static String DELETE_EMPLOYEE = "delete from employee where employee_id =?;";
    private static String SEARCH_NAME = "select * from employee where employee_name like ?;";

    public List<Employee> searchName(String search) {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SEARCH_NAME);
            statement.setString(1, "%" + search + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");
                double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int positionId = rs.getInt("position_id");
                int degreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String userName = rs.getString("username");
                Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, degreeId, divisionId, userName);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public boolean delete(int id){
        boolean isDelete =false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE);
            statement.setInt(1, id);
            isDelete = statement.executeUpdate() > 0;

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDelete;
    }


    public boolean setEmployee(Employee employee){
        boolean isSet = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SET_EMPLOYEE);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getBirthday());
            statement.setString(3, employee.getIdCard());
            statement.setDouble(4, employee.getSalary());
            statement.setString(5, employee.getPhone());
            statement.setString(6, employee.getEmail());
            statement.setString(7, employee.getAddress());
            statement.setInt(8,employee.getIdPosition());
            statement.setInt(9,employee.getIdDegree());
            statement.setInt(10,employee.getIdDivision());
            statement.setInt(11,employee.getId());
            isSet =statement.executeUpdate()>0;
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isSet;
    }

    public Employee findEmployee(int id) {
        Employee employee = null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_EMPLOYEE);
            statement.setInt(1 , id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");
                double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int positionId = rs.getInt("position_id");
                int degreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String userName = rs.getString("username");
                 employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, degreeId, divisionId, userName);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public boolean insertUser(User user) {
        boolean isInsert = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_USER);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            isInsert = statement.executeUpdate() > 0;

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  isInsert;
    }

    public boolean insert(Employee employee){
        boolean isInsert = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE);
            statement.setString(1,employee.getName());
            statement.setInt(2, employee.getIdPosition());
            statement.setInt(3, employee.getIdDegree());
            statement.setInt(4, employee.getIdDivision());
            statement.setString(5, employee.getBirthday());
            statement.setString(6, employee.getIdCard());
            statement.setDouble(7, employee.getSalary());
            statement.setString(8, employee.getPhone());
            statement.setString(9, employee.getEmail());
            statement.setString(10, employee.getAddress());
            statement.setString(11, employee.getUserName());
            isInsert = statement.executeUpdate() > 0;

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInsert;
    }

    public List<Employee> findAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("employee_id");
                String name = rs.getString("employee_name");
                String birthday = rs.getString("employee_birthday");
                String idCard = rs.getString("employee_id_card");
                double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int positionId = rs.getInt("position_id");
                int degreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String userName = rs.getString("username");
                Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId, degreeId, divisionId, userName);
                employeeList.add(employee);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public List<Division> findAllDivision() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("division_id");
                String name = rs.getString("division_name");
                Division division = new Division(id, name);
                divisionList.add(division);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisionList;
    }

    public List<Position> findAllPosition() {
        List<Position> positionList = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_POSITION);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("position_id");
                String name = rs.getString("position_name");
                Position position = new Position(id, name);
                positionList.add(position);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }

    public List<EducationDegree> findAllDegree() {
        List<EducationDegree> degreeList = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_DEGREE);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("education_degree_id");
                String name = rs.getString("education_degree_name");
                EducationDegree degree = new EducationDegree(id, name);
                degreeList.add(degree);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return degreeList;
    }
}
