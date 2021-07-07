package com.example.case_study_springboot.model.entity.service;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rentTypeName;
    private Double rentTypeCost;
    @OneToMany(mappedBy = "rentType")
    private List<Service> serviceList;

    public RentType() {
    }

}
