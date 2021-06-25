package com.example.b01_form_registration_springboot.controller;

import com.example.b01_form_registration_springboot.dto.UserDto;
import com.example.b01_form_registration_springboot.model.entity.User;
import com.example.b01_form_registration_springboot.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

//    @GetMapping(value = "")
//    public String showHome(Model model){
//        model.addAttribute("user", new User());
//        return "/home";
//    }
//
//    @PostMapping("/validateUser")
//    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return new ModelAndView("/home");
//        }
//        return new ModelAndView("/result");
//    }

    @GetMapping(value= "")
    public String showCreate(Model model){
        model.addAttribute("user", new UserDto());
        return "/create";
    }

    @PostMapping(value = "createUser")
    public String createUser(@ModelAttribute("user") @Valid UserDto userDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model){
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("msg",
                "Create new successfully");
        return "/create";
    }
}
