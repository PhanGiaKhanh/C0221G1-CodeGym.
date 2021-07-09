package com.example.case_study_springboot.controller;

import com.example.case_study_springboot.dto.ContractDto;
import com.example.case_study_springboot.dto.EmployeeDto;
import com.example.case_study_springboot.model.entity.contract.Contract;
import com.example.case_study_springboot.model.entity.customer.Customer;
import com.example.case_study_springboot.model.entity.employee.Employee;
import com.example.case_study_springboot.model.entity.service.Service;
import com.example.case_study_springboot.model.service.contract.IContractService;
import com.example.case_study_springboot.model.service.customer.ICustomerService;
import com.example.case_study_springboot.model.service.employee.IEmployeeService;
import com.example.case_study_springboot.model.service.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
    @RequestMapping("contracts")
public class ContractController {
    @Autowired
    IContractService contractService;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IServiceService serviceService;

    @ModelAttribute("employeeList")
    public Iterable<Employee> getEmployeeList(){
        return iEmployeeService.findAll();
    }
    @ModelAttribute("customerList")
    public Iterable<Customer> getCustomerList(){
        return customerService.findAll();
    }
    @ModelAttribute("serviceList")
    public Iterable<Service> getServiceList(){
        return serviceService.findAll();
    }
    @GetMapping("create")
    public ModelAndView showCreate(){
        return new ModelAndView("contract/create",
                "contractDto", new ContractDto());
    }

    @PostMapping("create")
    public ModelAndView createEmployee(@ModelAttribute("contractDto") @Valid ContractDto contractDto,
                                       BindingResult bindingResult){
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasErrors()){
            return new ModelAndView("contract/create","msg", "Fail");
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.save(contract);
        return new ModelAndView("contract/create", "msg", "create new contract successfully");
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
