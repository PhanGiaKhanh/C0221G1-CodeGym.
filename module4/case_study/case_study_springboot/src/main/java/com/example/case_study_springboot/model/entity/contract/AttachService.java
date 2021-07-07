package com.example.case_study_springboot.model.entity.contract;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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

}
