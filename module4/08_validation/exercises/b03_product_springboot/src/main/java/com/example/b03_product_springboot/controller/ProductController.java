package com.example.b03_product_springboot.controller;

import com.example.b03_product_springboot.dto.ProductDto;
import com.example.b03_product_springboot.model.entity.Product;
import com.example.b03_product_springboot.model.service.IProductService;
import com.example.b03_product_springboot.model.service.impl.ProductImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = {"", "/product"})
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping(value = "")
    public ModelAndView showListForm(@RequestParam("search") Optional<String> search, @PageableDefault(size = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/index");
        Page<Product> products = iProductService.searchNameAndDate(search.orElse(""), pageable);
        modelAndView.addObject("search", search.orElse(""));
        modelAndView.addObject("products", products);
        return modelAndView;
    }


    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "create";
    }

    @PostMapping("createProduct")
    public String saveProduct(@ModelAttribute("productDto") @Valid ProductDto productDto,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        new ProductDto().validate(productDto, bindingResult);
        if(bindingResult.hasErrors()){
            return "create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("msg", "Create new successfully");
        return "redirect:/";
    }


    @GetMapping(value = "/{id}/show")
    public String showProduct(@PathVariable int id, Model model) {
        Optional product = iProductService.findById(id);
        model.addAttribute("product", product.orElse(null));
        return "show";
    }

    @GetMapping(value = "/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional findProduct = iProductService.findById(id);
        model.addAttribute("product", findProduct.orElse(null));
        return "edit";
    }

    @PostMapping(value = "update")
    public String updateProduct(Product product, Model model) {
        iProductService.save(product);
        model.addAttribute("product", product);
        return "edit";
    }

    @GetMapping(value = "/{id}/delete")
    public String showDeleteForm(@PathVariable Integer id, Model model) {
        Optional product = iProductService.findById(id);
        model.addAttribute("product", product.orElse(null));
        return "delete";
    }

    @PostMapping(value = "/delete")
    public String remove(Product product) {
        iProductService.remove(product.getId());
        return "redirect:/";
    }


}
