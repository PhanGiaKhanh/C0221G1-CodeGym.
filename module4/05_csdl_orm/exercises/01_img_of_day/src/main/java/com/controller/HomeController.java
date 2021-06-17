package com.controller;

import com.model.Comment;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public String home() {
        return "home";
    }

    @PostMapping("save")
    public String saveComment(@RequestParam int like, String nameAuthor, String text, Model model){
        Comment comment = new Comment(like, nameAuthor, text);
        commentService.save(comment);
        model.addAttribute("comment", comment);
        return "home2";
    }
}
