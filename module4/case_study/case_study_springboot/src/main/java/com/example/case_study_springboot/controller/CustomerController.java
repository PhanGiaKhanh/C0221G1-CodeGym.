package com.example.case_study_springboot.controller;

import com.example.case_study_springboot.dto.CustomerDto;
import com.example.case_study_springboot.model.entity.customer.Customer;
import com.example.case_study_springboot.model.entity.customer.CustomerType;
import com.example.case_study_springboot.model.service.customer.ICustomerService;
import com.example.case_study_springboot.model.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    ICustomerService customerService;
    @Autowired
    ICustomerTypeService customerTypeService;

    @ModelAttribute("customerTypeList")
    public Iterable<CustomerType> getList() {
        return customerTypeService.findAll();
    }

    @GetMapping("")
    public String showList(@RequestParam("keyName") Optional<String> keyName,
                           @RequestParam("keyGender") Optional<String> keyGender,
                           @RequestParam("keyBirthday") Optional<String> keyBirthday,
                           @PageableDefault(size = 2) Pageable pageable,
                           Model model) {
        Page<Customer> customerPage =
                customerService.findAllNameGenderBirthday(keyName.orElse(""),
                        keyGender.orElse(""),
                        keyBirthday.orElse(""),pageable);
        model.addAttribute("keyName", keyName.orElse(""));
        model.addAttribute("keyGender", keyGender.orElse(""));
        model.addAttribute("keyBirthday", keyBirthday.orElse(""));
        model.addAttribute("customerList", customerPage);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("customerDto") @Valid CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 Model model, RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerDto", customerDto);
            return "/customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Create new successfully");
        return "redirect:create";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam Integer id, Model model) {
        Customer customer = customerService.findById(id).orElse(null);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        return "customer/edit";
    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@ModelAttribute("customerDto") @Valid CustomerDto customerDto,
                                       BindingResult bindingResult) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/customer/edit");
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return new ModelAndView("customer/edit", "msg", "Edit successfully");
    }


//    @PostMapping("delete")
//    private String removeCustomer(@RequestParam("idDel") Integer idDel, RedirectAttributes redirectAttributes) {
//        Customer customer = customerService.findById(idDel).orElse(null);
//        customer.setCustomerFlag(false);
//        customerService.save(customer);
//        redirectAttributes.addFlashAttribute("msg", "successful delete");
//        return "redirect:/customers";
//    }
    @PostMapping("delete2")
    private String removeCustomer(@RequestParam("listId") Optional<List<Integer>> listId, RedirectAttributes redirectAttributes) {
        if (listId.isPresent()){
            for (Integer id : listId.get()){
                Customer customer = customerService.findById(id).orElse(null);
                if (customer == null){
                    return "/error-404";
                }
                customer.setCustomerFlag(false);
                customerService.save(customer);
            }
            redirectAttributes.addFlashAttribute("msg", "successful delete");
            return "redirect:/customers";
        }
        return "redirect:/customers";
    }
}
