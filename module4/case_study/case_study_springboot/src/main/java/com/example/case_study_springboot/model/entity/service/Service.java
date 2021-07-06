package com.example.case_study_springboot.model.entity.service;

import com.example.case_study_springboot.model.entity.contract.Contract;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String serviceName;
    @Column(nullable = false)
    private String serviceCode;
    private Integer serviceArea;
    @Column(nullable = false)
    private Double serviceCost;
    private Integer serviceMaxPeople;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private RentType rentType;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private ServiceType serviceType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private Double poolArea;
    private Integer numberOfFloors;
    @OneToMany(mappedBy = "service")
    private List<Contract> contractList;
    private Boolean serviceFlag;

    public Service() {
    }

}
