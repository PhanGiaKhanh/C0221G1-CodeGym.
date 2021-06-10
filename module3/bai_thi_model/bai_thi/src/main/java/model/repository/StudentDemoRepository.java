package model.repository;

import model.bean.StudentDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDemoRepository {
    BaseRepository baseRepository = new BaseRepository();

    //#region SELECT ALL
    private static final String SELECT_ALL = "select * from students;";

    public List<StudentDemo> findAll() {
        List<StudentDemo> list = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("s_name");
                String gender = rs.getString("gender");
                String birthday = rs.getString("birthday");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String point = rs.getString("point");
                StudentDemo studentDemo = new StudentDemo(id, name, gender, birthday, email, address, point);
                list.add(studentDemo);
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
    private static final String INSERT = "insert into students (s_name,gender, birthday, email, address, point) " +
            "values (?, ?, ?, ?, ?, ?);";

    public boolean insert(StudentDemo studentDemo) {
        boolean isInsert = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, studentDemo.getName());
            preparedStatement.setString(2, studentDemo.getGender());
            preparedStatement.setString(3, studentDemo.getBirthday());
            preparedStatement.setString(4, studentDemo.getEmail());
            preparedStatement.setString(5, studentDemo.getAddress());
            preparedStatement.setString(6, studentDemo.getPoint());
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
    private static final String SELECT_ID = "select * from students where id = ?;";

    public StudentDemo findById(int id) {
        StudentDemo studentDemo = null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("s_name");
                String gender = rs.getString("gender");
                String birthday = rs.getString("birthday");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String point = rs.getString("point");
                studentDemo = new StudentDemo(id, name, gender, birthday, email, address, point);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentDemo;
    }
//#endregion

    //#region UPDATE
    private static final String UPDATE_ID = "update students set " +
            "s_name = ?, gender = ?, birthday = ?, email = ?, address = ?, point = ? where id = ?";

    public boolean update(StudentDemo studentDemo) {
        boolean isUpdate = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ID);
            preparedStatement.setString(1, studentDemo.getName());
            preparedStatement.setString(2, studentDemo.getGender());
            preparedStatement.setString(3, studentDemo.getBirthday());
            preparedStatement.setString(4, studentDemo.getEmail());
            preparedStatement.setString(5, studentDemo.getAddress());
            preparedStatement.setString(6, studentDemo.getPoint());
            preparedStatement.setInt(7, studentDemo.getId());
            isUpdate = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdate;
    }
//#endregion

    //#region SEARCH
    private static final String SEARCH = "select * from students where " +
            "id like ? or s_name like ? or gender like ?";

    public List<StudentDemo> search(String search) {
        List<StudentDemo> list = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            String fixSearchString = "\'%" + search + "%\'";
            String SQL = SEARCH.replaceAll("\\?", fixSearchString);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("s_name");
                String gender = rs.getString("gender");
                String birthday = rs.getString("birthday");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String point = rs.getString("point");
                StudentDemo studentDemo = new StudentDemo(id, name, gender, birthday, email, address, point);
                list.add(studentDemo);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

//#endregion

    //#region DELETE
    private static final String DELETE = "delete from students where id = ?";

    public boolean delete(int id) {
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

//Connection connection = baseRepository.connectDataBase();
//PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
}
