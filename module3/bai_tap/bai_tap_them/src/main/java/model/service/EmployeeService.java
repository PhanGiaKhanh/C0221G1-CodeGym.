package model.service;

import model.bean.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee> findAll();
    Map<String, String> insert(Employee employee);
    boolean deleteById(int id);
    boolean updateById(Employee employee);
    Employee findById(int id);
    List<Employee> findByName(String Name);
}
