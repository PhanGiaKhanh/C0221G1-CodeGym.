package com.example.case_study_springboot.model.repository.employee;

import com.example.case_study_springboot.model.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer> {
    @Query(value = "select * from employee where concat(employee_name, ' ', birthday) like %?1% " +
            "&& flag=1 order by id desc ", nativeQuery = true)
    Page<Employee> findAllByKeyWord(String keyWord, Pageable pageable);
}
