package com.example.b01_blog_app_springboot.controller;


import com.example.b01_blog_app_springboot.model.entity.Category;
import com.example.b01_blog_app_springboot.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable){
        return new ModelAndView("/category/list","categoryList", categoryService.findAll(pageable));
    }
    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        return new ModelAndView("/category/create","category",new Category());
    }

    @PostMapping("/create")
    public ModelAndView saveBlog(@ModelAttribute Category category) {
        categoryService.save(category);
        return new ModelAndView("/category/create", "category", category).addObject("message", "Create is success");
    }

}
