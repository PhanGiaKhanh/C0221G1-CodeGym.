package com.example.case_study_springboot.model.service.impl;

import com.example.case_study_springboot.model.entity.employee.Division;
import com.example.case_study_springboot.model.entity.employee.EducationDegree;
import com.example.case_study_springboot.model.entity.employee.Employee;
import com.example.case_study_springboot.model.entity.employee.Position;
import com.example.case_study_springboot.model.repository.employee.IDivisionRepository;
import com.example.case_study_springboot.model.repository.employee.IEducationDegreeRepository;
import com.example.case_study_springboot.model.repository.employee.IEmployeeRepository;
import com.example.case_study_springboot.model.repository.employee.IPositionRepository;
import com.example.case_study_springboot.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    IDivisionRepository divisionRepository;

    @Autowired
    IPositionRepository positionRepository;

    @Autowired
    IEducationDegreeRepository educationDegreeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Iterable<Division> findAllDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public Iterable<EducationDegree> findAllEducationDegree() {
        return educationDegreeRepository.findAll();
    }

    @Override
    public Iterable<Position> findAllPosition() {
        return positionRepository.findAll();
    }

    @Override
    public Page<Employee> findAllByKeyWord(String keyWord, Pageable pageable) {
        return employeeRepository.findAllByKeyWord(keyWord, pageable);
    }
}
