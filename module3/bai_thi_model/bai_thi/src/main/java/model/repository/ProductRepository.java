package model.repository;

import model.bean.Category;
import model.bean.Product;
import model.bean.StudentDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    BaseRepository baseRepository = new BaseRepository();
    //#region DELETE
    private static final String DELETE = "delete from products where id = ?";

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

    //#region UPDATE
    private static final String UPDATE_ID = "update products set " +
            "p_name = ?, price = ?, amount = ?, color = ?, p_description = ?, c_id = ? where id = ?";

    public boolean update(Product product) {
        boolean isUpdate = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ID);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getC_id());
            preparedStatement.setInt(7, product.getId());
            isUpdate = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUpdate;
    }
//#endregion

    //#region SELECT ID
    private static final String SELECT_ID = "select * from products where id = ?;";

    public Product findById(int id) {
        Product product = null;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("p_name");
                String price = rs.getString("price");
                String amount = rs.getString("amount");
                String color = rs.getString("color");
                String p_description = rs.getString("p_description");
                String c_id = rs.getString("c_id");
                product = new Product(id, name, price, amount, color, p_description, c_id);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
//#endregion

    //#region SEARCH
    private static final String SEARCH = "select * from products where " +
            "p_name like ?";

    public List<Product> search(String search) {
        List<Product> list = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + search + "%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("p_name");
                String price = rs.getString("price");
                String amount = rs.getString("amount");
                String color = rs.getString("color");
                String p_description = rs.getString("p_description");
                String c_id = rs.getString("c_id");
                Product product = new Product(id, name, price, amount, color, p_description, c_id);
                list.add(product);
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
    private static final String INSERT = "insert into products (p_name,price, amount, color, p_description, c_id) " +
            "values (?, ?, ?, ?, ?, ?);";

    public boolean insert(Product product) {
        boolean isInsert = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getPrice());
            preparedStatement.setString(3, product.getAmount());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setString(6, product.getC_id());
            isInsert = preparedStatement.executeUpdate() > 0;
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isInsert;
    }
//#endregion

    //#region SELECT ALL CATEGORY
    private static final String SELECT_ALL_CATEGORY = "select * from category;";

    public List<Category> findAllCategory() {
        List<Category> list = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("c_id");
                String name = rs.getString("c_name");
                Category category = new Category(id, name);
                list.add(category);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
//#endregion

    //#region SELECT ALL
    private static final String SELECT_ALL = "select * from products;";

    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("p_name");
                String price = rs.getString("price");
                String amount = rs.getString("amount");
                String color = rs.getString("color");
                String p_description = rs.getString("p_description");
                String c_id = rs.getString("c_id");
                Product product = new Product(id, name, price, amount, color, p_description, c_id);
                list.add(product);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
//#endregion
}
