package com.example.b01_complete_cart.controller;

import com.example.b01_complete_cart.dto.ProductDto;
import com.example.b01_complete_cart.model.entity.Product;
import com.example.b01_complete_cart.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@SessionAttributes("Cart")
@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("Cart")
    public List<Product> buyCartList(){
        return new ArrayList<>();
    }

    @GetMapping(value = "")
    public String showHome(@RequestParam("search") Optional<String> search,
                           @PageableDefault(size = 4) Pageable pageable,
    Model model){
        Page<Product> products = productService.searchNameAndPrice(search.orElse(""), pageable);
        model.addAttribute("search", search.orElse(""));
        model.addAttribute("products", products);

        return "/home";
    }
    @GetMapping(value = { "list"})
    public String showListProduct(@RequestParam("search")Optional<String> search,
                                  @PageableDefault(2)Pageable pageable,
                                  Model model){
        Page<Product> products = productService.searchNameAndPrice(search.orElse(""), pageable);
        model.addAttribute("search", search.orElse(""));
        model.addAttribute("products", products);
        return "/list";
    }
    @GetMapping(value = {"create"})
    public String showCreate(Model model){
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping(value = "create-product")
    public ModelAndView saveProduct(@ModelAttribute Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }

    @GetMapping(value = "product/{id}/show-product")
    public String showProduct(@PathVariable Integer id, Model model){
        Product product = productService.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "/show";
    }

    @GetMapping(value = "product/product-buy/{id}")
    public String buyProduct(@PathVariable Integer id,
                             @SessionAttribute("Cart") List<Product> cartList,
                             RedirectAttributes redirectAttributes){
        Product productObj = productService.findById(id).orElse(null);
        cartList.add(productObj);
        redirectAttributes.addFlashAttribute("msg", "Add buy product");
        return "redirect:/";
    }

}
