package com.example.case_study_springboot.model.entity.contract;

import com.example.case_study_springboot.model.entity.customer.Customer;
import com.example.case_study_springboot.model.entity.employee.Employee;
import com.example.case_study_springboot.model.entity.service.Service;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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


}
