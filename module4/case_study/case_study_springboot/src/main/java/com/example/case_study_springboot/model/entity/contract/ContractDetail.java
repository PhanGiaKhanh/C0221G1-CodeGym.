package com.example.case_study_springboot.model.entity.contract;

import com.example.case_study_springboot.model.entity.employee.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private AttachService attachService;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id", nullable = false)
    private Contract contract;
    @Column(nullable = false)
    private Integer quantity;

    public ContractDetail() {
    }

}
