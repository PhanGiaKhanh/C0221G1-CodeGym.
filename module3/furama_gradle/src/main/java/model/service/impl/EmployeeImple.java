package model.service.impl;

import model.bean.Customer;
import model.bean.employee.*;
import model.repository.EmployeeRepository;
import model.service.EmployeeService;

import java.util.List;

public class EmployeeImple implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAllEmployee();
    }

    @Override
    public List<Division> findAllDivision() {
        return employeeRepository.findAllDivision();
    }

    @Override
    public List<Position> findAllPosition() {
        return employeeRepository.findAllPosition();
    }

    @Override
    public List<EducationDegree> findAllDegree() {
        return employeeRepository.findAllDegree();
    }

    @Override
    public boolean insert(Employee employee) {
        return employeeRepository.insert(employee);
    }

    @Override
    public boolean delete(int id) {
        return employeeRepository.delete(id);
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public boolean updateById( Employee employee) {
        return employeeRepository.setEmployee(employee);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return employeeRepository.searchName(name);
    }

    @Override
    public boolean insertUser(User user) {
        return employeeRepository.insertUser(user);
    }

    @Override
    public Employee findEmployee(int id) {
        return employeeRepository.findEmployee(id);
    }
}
