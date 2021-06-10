package model.service.impl;

import model.bean.Employee;
import model.common.Validate;
import model.repository.EmployeeRepository;
import model.service.EmployeeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Map<String, String> insert(Employee employee) {
        Map<String, String> stringMap = new HashMap<>();
        String name = Validate.checkNameVN(employee.getEmName());
        if (!name.equals("")){
            stringMap.put("name", name);
        }
        String birthday = Validate.checkBirthday18(employee.getBirthday());
        if (!birthday.equals("")){
            stringMap.put("birthday", birthday);
        }
        if (stringMap.isEmpty()) {
            employeeRepository.insert(employee);
        }
        return stringMap;
    }

    @Override
    public boolean deleteById(int id) {
        return employeeRepository.deleleById(id);
    }

    @Override
    public boolean updateById(Employee employee) {

        return employeeRepository.update(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByName(String Name) {
        return null;
    }



}
