package com.example.case_study_springboot.controller;

import com.example.case_study_springboot.dto.CustomerDto;
import com.example.case_study_springboot.dto.ServiceDto;
import com.example.case_study_springboot.model.entity.service.RentType;
import com.example.case_study_springboot.model.entity.service.Service;
import com.example.case_study_springboot.model.entity.service.ServiceType;
import com.example.case_study_springboot.model.service.service.IRentTypeService;
import com.example.case_study_springboot.model.service.service.IServiceService;
import com.example.case_study_springboot.model.service.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    IServiceService serviceService;
    @Autowired
    IRentTypeService rentTypeService;
    @Autowired
    IServiceTypeService serviceTypeService;

    @ModelAttribute("rentTypeList")
    public Iterable<RentType> getRentType(){
        return rentTypeService.findAll();
    }
    @ModelAttribute("serviceTypeList")
    public Iterable<ServiceType> getServiceType(){
        return serviceTypeService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        return new ModelAndView("service/create", "serviceDto", new ServiceDto());
    }

    @PostMapping("create")
    public ModelAndView createService(@ModelAttribute("serviceDto") @Valid ServiceDto serviceDto,
                                      BindingResult bindingResult){
        new ServiceDto().validate(serviceDto, bindingResult);
        if (bindingResult.hasErrors()){
            return new ModelAndView("service/create");
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto, service);
        serviceService.save(service);
        return new ModelAndView("service/create", "msg", "create new service successfully");
    }
}
