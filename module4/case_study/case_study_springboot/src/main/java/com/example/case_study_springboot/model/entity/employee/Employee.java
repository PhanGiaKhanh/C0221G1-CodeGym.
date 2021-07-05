package com.example.case_study_springboot.model.entity.employee;

import com.example.case_study_springboot.model.entity.contract.Contract;
import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String employeeName;
    @Column(nullable = false)
    private String birthday;
    @Column(nullable = false)
    private String salary;
    @Column(nullable = false)
    private String phone;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Division division;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Position position;
    @OneToMany(mappedBy = "employee")
    private List<Contract> contractList;
    private Boolean flag = true;

    public Employee() {
    }



    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
