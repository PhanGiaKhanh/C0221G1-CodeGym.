package com.example.b01_update_img_of_day.controller;


import com.example.b01_update_img_of_day.model.entity.Comment;
import com.example.b01_update_img_of_day.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
//@RequestMapping(value = {"","customer"})
public class HomeController {
    @Autowired
    private ICommentService commentService;

    @GetMapping(value = "/comments")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search, @PageableDefault(value = 5) Pageable pageable){
        Page<Comment> comments;

        if(search.isPresent()){
            comments = commentService.findAllByAuthorContaining(search.get(), pageable);
        } else {
            comments = commentService.findAllByOrderByStartDesc(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/home");
        modelAndView.addObject("comments", comments);
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }
    @PostMapping(value = "/save")
    public String saveComment(@ModelAttribute Comment comment){
        commentService.save(comment);
        return "redirect:/comments";
    }
    @GetMapping(value = "/comment/{id}/like")
    public String updateComment(@PathVariable Long id){
        commentService.like(id);
        return "redirect:/comments";
    }
}
