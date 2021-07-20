package com.example.bai_thi2.controller;

import com.example.bai_thi2.dto.QuestionDto;
import com.example.bai_thi2.model.entity.Question;
import com.example.bai_thi2.model.entity.QuestionType;
import com.example.bai_thi2.model.service.IQuestionService;
import com.example.bai_thi2.model.service.IQuestionTypeService;
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
import java.util.Optional;

@Controller
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    IQuestionService questionService;

    @Autowired
    IQuestionTypeService questionTypeService;

    @ModelAttribute("questionTypes")
    public Iterable<QuestionType> getList() {
        return questionTypeService.findAll();
    }

    @GetMapping("")
    public String showList(@RequestParam("keyTitle") Optional<String> keyTitle,
                           @RequestParam("keyQuestionTypeId") Optional<String> keyQuestionTypeId,
                           @PageableDefault(size = 2) Pageable pageable,
                           Model model) {
        Page<Question> questions =
                questionService.findAllTitleQuestionTypeId(keyTitle.orElse(""),
                        keyQuestionTypeId.orElse(""), pageable);
        model.addAttribute("keyTitle", keyTitle.orElse(""));
        model.addAttribute("keyQuestionTypeId", keyQuestionTypeId.orElse(""));
        model.addAttribute("questions", questions);
        return "/question/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("questionDto", new QuestionDto());
        return "question/create";
    }
    @PostMapping("/create")
    public String createCustomer(@ModelAttribute("questionDto") @Valid QuestionDto questionDto,
                                 BindingResult bindingResult,
                                 Model model, RedirectAttributes redirectAttributes) {
        new QuestionDto().validate(questionDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("questionDto", questionDto);
            return "/question/create";
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionDto, question);
        questionService.save(question);
        redirectAttributes.addFlashAttribute("msg", "Create new successfully");
        return "redirect:create";
    }
    @PostMapping("delete")
    private String removeCustomer(@RequestParam("idDel") Integer idDel, RedirectAttributes redirectAttributes) {
    Question question = questionService.findById(idDel).orElse(null);
        question.setFlag(false);
        questionService.save(question);
        redirectAttributes.addFlashAttribute("msg", "successful delete");
        return "redirect:/questions";
    }


    @GetMapping("/show")
    public String showQuestion(@RequestParam Integer id, Model model) {
        if (!questionService.findById(id).isPresent()){
            return "/error-404";
        }
        Question question = questionService.findById(id).orElse(null);
        model.addAttribute("question", question);
        return "question/show";
    }
//
//    @PostMapping("/update")
//    public ModelAndView updateCustomer(@ModelAttribute("questionDto") @Valid QuestionDto questionDto,
//                                       BindingResult bindingResult) {
//        new QuestionDto().validate(questionDto, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return new ModelAndView("/question/edit");
//        }
//        Question question = new Question();
//        BeanUtils.copyProperties(questionDto, question);
//        questionService.save(question);
//        return new ModelAndView("question/edit", "msg", "Edit successfully");
//    }

}
