package com.example.case_study_springboot.controller;

import com.example.case_study_springboot.dto.CustomerDto;
import com.example.case_study_springboot.model.entity.customer.Customer;
import com.example.case_study_springboot.model.service.customer.ICustomerService;
import com.example.case_study_springboot.model.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        return "customer/create";
    }

//    @PostMapping("/create")
//    public String createCustomer(@ModelAttribute @Valid CustomerDto customerDto,
//                                 BindingResult bindingResult,
//                                 RedirectAttributes redirectAttributes) {
//        new CustomerDto().validate(customerDto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return "/customer/create";
//        }
//        Customer customer = new Customer();
//        BeanUtils.copyProperties(customerDto, customer);
//        customerService.save(customer);
//        redirectAttributes.addFlashAttribute("msg", "Create new successfully");
//        return "customer/create";
//    }

}
