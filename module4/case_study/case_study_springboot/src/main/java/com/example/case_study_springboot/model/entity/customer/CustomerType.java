package com.example.case_study_springboot.model.entity.customer;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;

    public CustomerType() {
    }

    public CustomerType(Integer id, String customerTypeName, List<Customer> customerList) {
        this.id = id;
        this.customerTypeName = customerTypeName;
        this.customerList = customerList;
    }
}
