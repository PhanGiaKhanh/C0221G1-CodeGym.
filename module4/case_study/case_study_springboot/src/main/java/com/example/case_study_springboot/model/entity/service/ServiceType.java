package com.example.case_study_springboot.model.entity.service;

import javax.persistence.*;
import java.util.List;
@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String serviceTypeName;
    @OneToMany(mappedBy = "serviceType")
    private List<Service> serviceList;

    public ServiceType() {
    }

    public ServiceType(Integer id, String serviceTypeName, List<Service> serviceList) {
        this.id = id;
        this.serviceTypeName = serviceTypeName;
        this.serviceList = serviceList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
