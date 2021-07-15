package com.example.shop_clothes.controller;

import com.example.shop_clothes.dto.ClothesDto;
import com.example.shop_clothes.model.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("clothes")
public class ClothesController {
    @Autowired
    IClothesService clothesService;

    @GetMapping("create")
    public ModelAndView showCreate(){
        return new ModelAndView("test",
                "clothesDto", new ClothesDto());
    }
}
