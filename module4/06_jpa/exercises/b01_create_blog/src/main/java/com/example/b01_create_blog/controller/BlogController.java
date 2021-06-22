package com.example.b01_create_blog.controller;

import com.example.b01_create_blog.model.bean.Blog;
import com.example.b01_create_blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping(value = "")
    public String showList(Model model){
        model.addAttribute("blogList", iBlogService.findAll() );
        return "views/list";
    }

    @GetMapping(value = "create")
    public String showCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "views/create";
    }

    @PostMapping(value = "createBlog")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "succession");
        return "redirect:";
    }

    @GetMapping(value = "/{id}/show")
    public String showBlog(@PathVariable long id, Model model){
        model.addAttribute("blog", iBlogService.findById(id));
        return "views/show";
    }
    @GetMapping(value = "/{id}/delete")
    public String showDelete(@PathVariable long id, RedirectAttributes redirectAttributes){
        iBlogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "delete is success");
        return "redirect:/";
    }
    @GetMapping(value = "/{id}/edit")
    public String showEdit(@PathVariable long id, Model model){
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog) ;
        return "views/edit";
    }
    @PostMapping(value = "editBlog")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "delete is success");
        return "redirect:";
    }
}
