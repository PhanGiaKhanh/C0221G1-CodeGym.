package com.example.case_study_springboot.model.entity.contract;

import com.example.case_study_springboot.model.entity.customer.Customer;
import com.example.case_study_springboot.model.entity.employee.Employee;
import com.example.case_study_springboot.model.entity.service.Service;

import javax.persistence.*;
import java.util.List;
@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String startDate;
    @Column(nullable = false)
    private String endDate;
    @Column(nullable = false)
    private Double contractDeposit;
    @Column(nullable = false)
    private Double contractTotalMoney;
    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetail;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Service service;

    private Boolean customerFlag = true;

    public Contract() {
    }



    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Boolean getCustomerFlag() {
        return customerFlag;
    }

    public void setCustomerFlag(Boolean customerFlag) {
        this.customerFlag = customerFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public List<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(List<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }
}
