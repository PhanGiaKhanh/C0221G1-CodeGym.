package com.model.repository;

import com.model.bean.Size;

import java.util.*;

public class SizeRepository {
    private static Map<Integer, Size> sizeMap = new HashMap<>();

    static {
        sizeMap.put(1, new Size(1, 5));
        sizeMap.put(2, new Size(2, 10));
        sizeMap.put(3, new Size(3, 15));
        sizeMap.put(4, new Size(4, 25));
        sizeMap.put(5, new Size(5, 50));
        sizeMap.put(6, new Size(6, 100));
    }

    public List<Size> findAll(){
        return new ArrayList<>(sizeMap.values());
    }
}
