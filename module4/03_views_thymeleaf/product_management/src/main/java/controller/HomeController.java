package controller;

import model.bean.Product;
import model.service.IProductService;
import model.service.impl.ProductImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    IProductService iProductService = new ProductImpl();

    @GetMapping("")
    public ModelAndView home(){
        List<Product> list = iProductService.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", list);
        return modelAndView;
    }
}
