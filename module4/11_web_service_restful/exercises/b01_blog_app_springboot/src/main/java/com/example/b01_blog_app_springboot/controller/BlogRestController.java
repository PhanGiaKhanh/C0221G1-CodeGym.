package com.example.b01_blog_app_springboot.controller;


import com.example.b01_blog_app_springboot.model.entity.Blog;
import com.example.b01_blog_app_springboot.model.entity.Category;
import com.example.b01_blog_app_springboot.model.service.IBlogService;
import com.example.b01_blog_app_springboot.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/blogRest")
@RestController
public class BlogRestController {
    @Autowired
    IBlogService blogService;

    @Autowired
    ICategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getListCategory(){
        List<Category> categories = this.categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> getListBlog(){
        List<Blog> blogs = this.blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity<List<Blog>> getListBlogByIdCategory(@PathVariable Long id){
        List<Blog> blogs = this.blogService.findAllBlogByIdCategory(id);
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Blog> getInfoBlog(@PathVariable Long id){
        Blog blog = this.blogService.findById(id).orElse(null);
        if (blog == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
