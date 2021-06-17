package controller;

import model.bean.Product;
import model.service.IProductService;
import model.service.impl.ProductImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    IProductService iProductService = new ProductImpl();

    @GetMapping(value = "")
    public ModelAndView home(){
        List<Product> list = iProductService.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", list);
        return modelAndView;
    }
//    @GetMapping
//    public String home(Model model){
//        List<Product> list = iProductService.findAll();
//        model.addAttribute("products", list);
//        return "index";
//    }

    @GetMapping(value = "/create")
    public String create(){
        return "create";
    }
    @PostMapping("createProduct")
    public String save(String name, Double price, String description, String manufacturer, Model model){
        int size = iProductService.size();
        int id = size +1;
        Product product = new Product(id, name, price, description, manufacturer);
        iProductService.save(product);
        model.addAttribute("products", iProductService.findAll());
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/show")
    public String showProduct(@PathVariable int id, Model model){
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "show";
    }
    @GetMapping(value = "/{id}/edit")
    public String editProduct(@PathVariable int id, Model model){
        Product findProduct = iProductService.findById(id);
        model.addAttribute("product", findProduct);
        return "edit";
    }
    @PostMapping(value = "update")
    public String updateProduct(Product product, Model model){
        iProductService.update(product);
        model.addAttribute("product", product);
        return "edit";
    }
    @GetMapping(value = "/{id}/delete")
    public String showDelete(@PathVariable int id, Model model){
        Product product = iProductService.findById(id);
        model.addAttribute("product", product);
        return "delete";
    }
    @PostMapping(value = "/delete")
    public String remove(Product product){
        iProductService.remove(product.getId());
        return "redirect:/";
    }
}
