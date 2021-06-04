package model.service;

import model.bean.Customer;
import model.bean.employee.*;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployee();
    List<Division> findAllDivision();
    List<Position> findAllPosition();
    List<EducationDegree> findAllDegree();
    boolean insert(Employee employee);
    boolean delete(int id);
    Employee findById(int id);
    boolean updateById(Employee employee);
    List<Employee> searchByName(String name);
    boolean insertUser(User user);
    Employee findEmployee(int id);
}
