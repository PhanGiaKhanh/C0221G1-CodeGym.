package com.example.case_study_springboot.model.entity.service;

import javax.persistence.*;
import java.util.List;

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

    public RentType(Integer id, String rentTypeName, Double rentTypeCost, List<Service> serviceList) {
        this.id = id;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.serviceList = serviceList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
