package com.example.b01_count_view_page.model.entity;

import lombok.Data;

@Data
public class Counter {
    private int count;

    public int increment() {
        return count++;
    }
}
