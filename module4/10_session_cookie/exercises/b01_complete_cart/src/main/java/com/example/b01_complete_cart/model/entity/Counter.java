package com.example.b01_complete_cart.model.entity;

import lombok.Data;

@Data
public class Counter {
    private Integer count;

    public int increment() {
        return count++;
    }
}
