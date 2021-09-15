package com.example.demo1.model;

import com.sun.javafx.beans.IDProperty;


public class Voucher {
    private Long id;
    private String code;
    private Double money;

    public Voucher() {
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Double getMoney() {
        return money;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
