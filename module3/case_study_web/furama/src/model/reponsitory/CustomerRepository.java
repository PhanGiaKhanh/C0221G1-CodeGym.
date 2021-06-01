package model.reponsitory;

import model.bean.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {
    BaseCustomerRepository baseCustomerRepository = new BaseCustomerRepository();
    private static final String SELECT_ALL_CUSTOMERS =
            "select kh.id_khach_hang, kh.ho_ten, kh.ngay_sinh, kh.gioi_tinh, kh.so_cmnd, kh.sdt, kh.email, lk.ten_loai_khach, kh.dia_chi\n" +
            "from khach_hang kh join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach;";
    private static final String SELECT_CUSTOMER_ID =
            "select kh.id_khach_hang, kh.ho_ten, kh.ngay_sinh, kh.gioi_tinh, kh.so_cmnd, kh.sdt, kh.email, lk.ten_loai_khach, kh.dia_chi\n" +
            "from khach_hang kh join loai_khach lk on kh.id_loai_khach = lk.id_loai_khach " +
            "when kh.id_khach_hang = ?;";
    private static final String INSERT_CUSTOMER =
            "insert into khach_hang(id_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, sdt, email, dia_chi)\n " +
            "values (?, ?, ?, ?, ?, ?, ?, ?);";
    public boolean insert(Customer customer) {
        boolean isInsert = false;

        return isInsert;
    }

    public List<Customer> findByAll() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = baseCustomerRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_khach_hang");
                String name = rs.getString("ho_ten");
                String birthday = rs.getString("ngay_sinh");
                String gender = rs.getString("gioi_tinh");
                int id_card = rs.getInt("so_cmnd");
                String phone = rs.getString("sdt");
                String email = rs.getString("email");
                String type = rs.getString("ten_loai_khach");
                String address = rs.getString("dia_chi");
                Customer customer = new Customer(id, name, birthday, gender, id_card, phone, email, type, address);
                customers.add(customer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = baseCustomerRepository.connectDataBase();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("ho_ten");
                String birthday = rs.getString("ngay_sinh");
                String gender = rs.getString("gioi_tinh");
                int id_card = rs.getInt("so_cmnd");
                String phone = rs.getString("sdt");
                String email = rs.getString("email");
                String type = rs.getString("ten_loai_khach");
                String address = rs.getString("dia_chi");
                customer = new Customer(id, name, birthday, gender, id_card, phone, email, type, address);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
        public void save (Customer customer){
            customers.put(customer.getId(), customer);
        }


        public void update ( int id, Customer customer){
            customers.put(id, customer);
        }

        public void remove ( int id){
            customers.remove(id);
        }

        public int getSize () {
            return customers.size();
        }

//        public List<Customer> findByName (String name){
//            List<Customer> findCustomers = new ArrayList<>();
//            for (Customer customer : findAll()) {
//                if (customer.getC_name().contains(name)) {
//                    findCustomers.add(customer);
//                }
//            }
//            return findCustomers;
//        }

        private static Map<Integer, Customer> customers;
//
//    static {
//        customers = new HashMap<>();
//        customers.put(1, new Customer(1, "Nguyễn Văn Hải", "22/12/1990", "Male", 201566666, "0905123123", "Hai@gmai.com", "vip", "Hà Nội"));
//        customers.put(2, new Customer(2, "Lý Hải", "22/12/1990", "Male", 201566666, "0905123124", "Hai@gmai.com", "vip", "Đà Nẵng"));
//        customers.put(3, new Customer(3, "Bộ Kinh Vân", "22/12/1990", "Male", 201566666, "0905123125", "Hai@gmai.com", "vip", "HCM"));
//        customers.put(4, new Customer(4, "Nhiếp Phong", "22/12/1990", "Male", 201566666, "0905123126", "Hai@gmai.com", "vip", "Huế"));
//    }
    }
