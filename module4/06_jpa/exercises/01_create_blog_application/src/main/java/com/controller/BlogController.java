package com.controller;

import com.model.bean.Blog;
import com.model.service.IBlogService;
import com.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.instrument.classloading.jboss.JBossLoadTimeWeaver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @Autowired
    ICommentService iCommentService;

    @GetMapping(value = "")
    public String showList(Model model){
        model.addAttribute("blogList", iBlogService.findAll() );
        model.addAttribute("commentList", iCommentService.findAll());
        return "/list";
    }

    @GetMapping(value = "create")
    public String showCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping(value = "createBlog")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "succession");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/show")
    public String showBlog(@PathVariable long id, Model model){
        model.addAttribute("blog", iBlogService.findById(id));
        return "/show";
    }
    @GetMapping(value = "/{id}/delete")
    public String showDelete(@PathVariable long id, RedirectAttributes redirectAttributes){
        iBlogService.remove(id);
        redirectAttributes.addFlashAttribute("message", "delete is success");
        return "redirect:/";
    }
    @GetMapping(value = "/{id}/edit")
    public String showEdit(@PathVariable long id, Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog) ;
        return "/edit";
    }
    @PostMapping(value = "editBlog")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "delete is success");
        return "redirect:/";
    }
}
