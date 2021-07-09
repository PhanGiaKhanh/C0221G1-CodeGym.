package com.example.case_study_springboot.controller;

import com.example.case_study_springboot.dto.CustomerDto;
import com.example.case_study_springboot.model.entity.contract.Contract;
import com.example.case_study_springboot.model.entity.contract.ContractDetail;
import com.example.case_study_springboot.model.entity.customer.Customer;
import com.example.case_study_springboot.model.service.contract.IContractDetailService;
import com.example.case_study_springboot.model.service.contract.IContractService;
import com.example.case_study_springboot.model.service.customer.ICustomerService;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("customerUsing")
public class CustomerUsingController {
    @Autowired
    ICustomerService customerService;

    @Autowired
    IContractService contractService;

    @Autowired
    IContractDetailService contractDetailService;

    @GetMapping("")
    public String showlist(@ModelAttribute("search")Optional<String> search,
                          @PageableDefault(size = 2)Pageable pageable,
                          Model model) {
        Page<Contract> contractList = contractService.findAllContractUsing(search.orElse(""), pageable);
        for (Contract contract :contractList){
            try {
                Date sDate= new SimpleDateFormat("yyyy-MM-dd").parse(contract.getStartDate());
                Date eDate= new SimpleDateFormat("yyyy-MM-dd").parse(contract.getEndDate());
                Double totalMoney=eDate.compareTo(sDate)*contract.getService().getServiceCost();
//                List<ContractDetail> con = contractDetailService.findAllByContractDetailByAttachService();
                for (ContractDetail cd: contract.getContractDetail()){
                    totalMoney+=cd.getQuantity()*cd.getAttachService().getAttachServiceCost();
                }
                contract.setContractTotalMoney(totalMoney);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("search", search.orElse(""));
        model.addAttribute("contractList", contractList);
        model.addAttribute("contractDetailList", contractDetailService.findAllByContractDetailByAttachService());
        return "/customer_using/list";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam Integer id, Model model) {
        Customer customer = customerService.findById(id).orElse(null);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        model.addAttribute("customerDto", customerDto);
        return "customer_using/edit";
    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@ModelAttribute("customerDto") @Valid CustomerDto customerDto,
                                       BindingResult bindingResult) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ModelAndView("/customer_using/edit");
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customerService.save(customer);
        return new ModelAndView("customer_using/edit", "msg", "Edit successfully");
    }

    @PostMapping("delete")
    private String removeCustomer(@RequestParam("idDel") Integer idDel, RedirectAttributes redirectAttributes) {
        Contract contract = contractService.findById(idDel).orElse(null);
        contract.setContractFlag(false);
        contractService.save(contract);
        redirectAttributes.addFlashAttribute("msg", "successful delete");
        return "redirect:/";
    }
}
