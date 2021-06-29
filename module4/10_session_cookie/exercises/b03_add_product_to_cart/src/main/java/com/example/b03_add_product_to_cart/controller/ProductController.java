package com.example.b03_add_product_to_cart.controller;


import com.example.b03_add_product_to_cart.model.Cart;
import com.example.b03_add_product_to_cart.model.entity.Product;
import com.example.b03_add_product_to_cart.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/product/home");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("+")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("-")) {
            cart.subProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shopping-cart";
    }

    @GetMapping(value = {"/list"})
    public String showListProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/product/list";
    }

    @GetMapping(value = {"create"})
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping(value = "create-product")
    public ModelAndView saveProduct(@ModelAttribute Product product) {
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/product/create");
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
    @GetMapping(value = "product/product-buy/{id}")
    public String buyProduct(@PathVariable Long id,
                             @SessionAttribute Cart cart,
                             RedirectAttributes redirectAttributes){
        Product productObj = productService.findById(id).orElse(null);
        cart.addProduct(productObj);
        redirectAttributes.addFlashAttribute("msg", "Add buy product");
        return "redirect:/shop";
    }


    @GetMapping(value = "delete/{id}")
    public String deleteProduct(@PathVariable Long id,@SessionAttribute Cart cart){
        Product product = productService.findById(id).orElse(null);
        cart.deleteProduct(product);
        return "redirect:/shopping-cart";
    }
    @GetMapping(value = "product/{id}/show-product")
    public String showProduct(@PathVariable Long id, Model model){
        Product product = productService.findById(id).orElse(null);
        model.addAttribute("product", product);
        return "/product/view";
    }

}

