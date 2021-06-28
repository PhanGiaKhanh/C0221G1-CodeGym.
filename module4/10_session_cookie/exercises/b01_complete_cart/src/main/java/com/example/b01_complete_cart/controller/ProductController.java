package com.example.b01_complete_cart.controller;

import com.example.b01_complete_cart.dto.ProductDto;
import com.example.b01_complete_cart.model.entity.Product;
import com.example.b01_complete_cart.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping(value = "")
    public String showHome(@RequestParam("search") Optional<String> search,
                           @PageableDefault(size = 2) Pageable pageable,
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
        model.addAttribute("productDto", new ProductDto());
        return "/create";
    }

    @PostMapping(value = "create-product")
    public ModelAndView saveProduct(@ModelAttribute ProductDto productDto) {
        MultipartFile multipartFile = productDto.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(productDto.getImage().getBytes(), new File(fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Product product = new Product(
                productDto.getId(),
                productDto.getProductId(),
                productDto.getProductName(),
                fileName,
                productDto.getPrice(),
                productDto.getPrice(),
                productDto.getAmount(),
                productDto.getDescription(),
                productDto.getDate());
        System.out.println(product);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm", productDto);
        modelAndView.addObject("message", "Created new product successfully !");
        return modelAndView;
    }
}
