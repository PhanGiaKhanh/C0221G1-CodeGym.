package com.example.case_study_springboot.model.entity.contract;

import com.example.case_study_springboot.model.entity.employee.Employee;

import javax.persistence.*;
import java.util.List;

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



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
