package com.controller;

import com.model.entity.Blog;
import com.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller

public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping(value = "/blogs")
    public ModelAndView listCustomers(@RequestParam("search") Optional<String> search,@PageableDefault(value = 5)Pageable pageable){
        Page<Blog> blogList;

        if(search.isPresent()){
            blogList = blogService.findAllByTitleContaining(search.get(), pageable);
        } else {
            blogList = blogService.findAllByOrderByDateDesc(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping(value = "create")
    public String showCreateForm(Model model){
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping(value = "saveBlog")
    public String saveBlogForm(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "Create success");
        return "/list";
    }

    @GetMapping(value = "/{id}/show")
    public String showBlogForm(@PathVariable Long id, Model model){
        model.addAttribute("blog", blogService.findById(id).get());
        return "/show";
    }
    @GetMapping(value = "/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model){
        model.addAttribute("blog", blogService.findById(id).get());
        return "/edit";
    }

    @PostMapping(value = "editBlog")
    public String updateBlogForm(@ModelAttribute Blog blog, Model model){
        blogService.save(blog);
        model.addAttribute("blog", blog);
        model.addAttribute("message", "succession");
        return "/edit";
    }

    @GetMapping(value = "/{id}/delete")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }
    @PostMapping("deleteBlog")
    public String deleteCustomer(@ModelAttribute Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:/blogs";
    }
}
