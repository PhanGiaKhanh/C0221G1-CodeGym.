package com.example.case_study_springboot.model.entity.contract;

import javax.persistence.*;
import java.util.List;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String attachServiceName;
    @Column(nullable = false)
    private Double attachServiceCost;
    @Column(nullable = false)
    private Integer attachServiceUnit;
    private String attachServiceStatus;
    @OneToMany(mappedBy = "attachService")
    private List<ContractDetail> contractDetail;

    public AttachService() {
    }

    public AttachService(Integer id, String attachServiceName, Double attachServiceCost, Integer attachServiceUnit, String attachServiceStatus, List<ContractDetail> contractDetail) {
        this.id = id;
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
        this.contractDetail = contractDetail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public Double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public Integer getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(Integer attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public List<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(List<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }
}
