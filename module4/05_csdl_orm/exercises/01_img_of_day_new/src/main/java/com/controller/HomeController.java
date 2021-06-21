package com.controller;

import com.model.entity.Comment;
import com.model.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping(value = {"","customer"})
public class HomeController {
    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/")
    public String home(Model model) {
        List<Comment> list = commentService.findAll();
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", list);
        return "home";
    }

    @PostMapping(value = "/save")
    public String saveComment(@ModelAttribute Comment comment){
        commentService.save(comment);
        return "redirect:/";
    }
    @GetMapping(value = "/comment/{id}/like")
    public String updateComment(@PathVariable int id){
        commentService.like(id);
        return "redirect:/";
    }
}
