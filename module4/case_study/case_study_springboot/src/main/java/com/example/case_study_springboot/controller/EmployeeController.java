package com.example.case_study_springboot.controller;

import com.example.case_study_springboot.dto.CustomerDto;
import com.example.case_study_springboot.dto.EmployeeDto;
import com.example.case_study_springboot.model.entity.customer.Customer;
import com.example.case_study_springboot.model.entity.employee.Division;
import com.example.case_study_springboot.model.entity.employee.EducationDegree;
import com.example.case_study_springboot.model.entity.employee.Employee;
import com.example.case_study_springboot.model.entity.employee.Position;
import com.example.case_study_springboot.model.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @ModelAttribute("divisionList")
    public Iterable<Division> getDivisionList(){
        return employeeService.findAllDivision();
    }
    @ModelAttribute("educationDegreeList")
    public Iterable<EducationDegree> getEducationDegreeList(){
        return employeeService.findAllEducationDegree();
    }
    @ModelAttribute("positionList")
    public Iterable<Position> getPositionList(){
        return employeeService.findAllPosition();
    }

    @GetMapping("create")
    public ModelAndView showCreate(){
        return new ModelAndView("employee/create",
                "employeeDto", new EmployeeDto());
    }

    @PostMapping("create")
    public ModelAndView createEmployee(@ModelAttribute("employeeDto") @Valid EmployeeDto employeeDto,
                                       BindingResult bindingResult){
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()){
            return new ModelAndView("employee/create","msg", "Fail");
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.save(employee);
        return new ModelAndView("employee/create", "msg", "create new employee successfully");
    }

    @GetMapping("")
    public ModelAndView showList(@RequestParam("search")Optional<String> search,
                                 @PageableDefault(size = 2)Pageable pageable){
        Page<Employee> employees = employeeService.findAllByKeyWord(search.orElse(""), pageable);
        ModelAndView modelAndView = new ModelAndView("employee/list","search", search.orElse(""));
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showEdit(@PathVariable Integer id){
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employeeService.findById(id).orElse(null), employeeDto);
        return new ModelAndView("employee/edit", "employeeDto", employeeDto);
    }

    @PostMapping("edit/{id}")
    public ModelAndView updateCustomer(@ModelAttribute("employeeDto") @Valid EmployeeDto employeeDto,
                                       BindingResult bindingResult) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ModelAndView("employee/edit");
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employeeService.save(employee);
        return new ModelAndView("employee/edit", "msg", "Edit successfully");
    }

    @PostMapping("delete")
    private String removeEmployee(@RequestParam("idDel") Integer idDel, RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.findById(idDel).orElse(null);
        employee.setFlag(false);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg", "successful delete");
        return "redirect:/employees";
    }
}
