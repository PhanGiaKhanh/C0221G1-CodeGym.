package com.example.bai_thi2.model.entity.customer;


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
    private Boolean customerFlag;

    public Customer() {
    }

}
