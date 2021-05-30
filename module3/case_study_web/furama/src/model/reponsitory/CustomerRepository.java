package model.reponsitory;

import model.bean.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "Nguyễn Văn Hải", "22/12/1990", "Male", 201566666, "0905123123", "Hai@gmai.com", "vip", "Hà Nội"));
        customers.put(2, new Customer(2, "Lý Hải", "22/12/1990", "Male", 201566666, "0905123124", "Hai@gmai.com", "vip", "Đà Nẵng"));
        customers.put(3, new Customer(3, "Bộ Kinh Vân", "22/12/1990", "Male", 201566666, "0905123125", "Hai@gmai.com", "vip", "HCM"));
        customers.put(4, new Customer(4, "Nhiếp Phong", "22/12/1990", "Male", 201566666, "0905123126", "Hai@gmai.com", "vip", "Huế"));
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public Customer findById(int id) {
        return customers.get(id);
    }

    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    public void remove(int id) {
        customers.remove(id);
    }

    public int getSize() {
        return customers.size();
    }

    public List<Customer> findByName(String name) {
        List<Customer> findCustomers = new ArrayList<>();
        for (Customer customer : findAll()) {
            if (customer.getC_name().contains(name)) {
                findCustomers.add(customer);
            }
        }
        return findCustomers;
    }


}
