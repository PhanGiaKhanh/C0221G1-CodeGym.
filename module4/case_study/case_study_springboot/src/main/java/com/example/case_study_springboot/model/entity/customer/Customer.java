package com.example.case_study_springboot.model.entity.customer;

import com.example.case_study_springboot.model.entity.contract.Contract;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private CustomerType customerType;
    private String customerCode;
    @Column(nullable=false)
    private String customerName;
    @Column(nullable=false)
    private String customerBirthday;
    @Column(nullable=false)
    private String customerGender;
    @Column(nullable=false)
    private String customerIdCard;
    @Column(nullable=false)
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;
    @OneToMany(mappedBy = "customer")
    private List<Contract> contractList;
    private Boolean customerFlag;

    public Customer() {
    }

}
