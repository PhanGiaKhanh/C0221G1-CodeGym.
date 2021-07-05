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

    public Customer(Integer id, CustomerType customerType, String customerName, String customerBirthday, String customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, List<Contract> contractList, Boolean customerFlag) {
        this.id = id;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.contractList = contractList;
        this.customerFlag = customerFlag;
    }

}
