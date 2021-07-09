package com.example.case_study_springboot.controller;

import com.example.case_study_springboot.dto.ContractDetailDto;
import com.example.case_study_springboot.model.entity.contract.AttachService;
import com.example.case_study_springboot.model.entity.contract.Contract;
import com.example.case_study_springboot.model.entity.contract.ContractDetail;
import com.example.case_study_springboot.model.service.contract.IAttachServiceService;
import com.example.case_study_springboot.model.service.contract.IContractDetailService;
import com.example.case_study_springboot.model.service.contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/contractDetails")
public class ContractDetailController {
    @Autowired
    IContractDetailService contractDetailService;

    @Autowired
    IAttachServiceService attachServiceService;

    @Autowired
    IContractService contractService;

    @ModelAttribute("contractList")
    public Iterable<Contract> getContractList(){ return contractService.findAll();}

    @ModelAttribute("attachServiceList")
    public Iterable<AttachService> getAttactServiceList(){return attachServiceService.findAll();}

    @GetMapping("/create")
    public ModelAndView showCreate(){
        return new ModelAndView("contract_detail/create",
                "contractDetailDto", new ContractDetailDto());
    }

    @PostMapping("/create")
    public ModelAndView createContractDetail(@ModelAttribute("contractDetailDto") @Valid ContractDetailDto contractDetailDto,
                                             BindingResult bindingResult){
        new ContractDetailDto().validate(contractDetailDto, bindingResult);
        if(bindingResult.hasErrors()){
            return new ModelAndView("contract_detail/create", "msg", "Fail");
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        contractDetailService.save(contractDetail);
        return new ModelAndView("contract_detail/create", "msg", "Create successfully");
    }
}
