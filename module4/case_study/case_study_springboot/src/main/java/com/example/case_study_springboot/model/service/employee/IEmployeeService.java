package com.example.case_study_springboot.model.service.employee;

import com.example.case_study_springboot.model.entity.employee.Division;
import com.example.case_study_springboot.model.entity.employee.EducationDegree;
import com.example.case_study_springboot.model.entity.employee.Employee;
import com.example.case_study_springboot.model.entity.employee.Position;
import com.example.case_study_springboot.model.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService extends IGenericService<Employee> {
    Iterable<Division> findAllDivision();
    Iterable<EducationDegree> findAllEducationDegree();
    Iterable<Position> findAllPosition();
    Page<Employee> findAllByKeyWord(String keyWord, Pageable pageable);
}
