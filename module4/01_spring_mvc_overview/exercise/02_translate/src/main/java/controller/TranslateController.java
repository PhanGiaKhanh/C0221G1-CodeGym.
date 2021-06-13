package controller;

import model.service.ITranslate;
import model.service.impl.TranslateImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {
    ITranslate iTranslate = new TranslateImpl();
    @GetMapping("")
    public String home(){
        return "/home";
    }
    @PostMapping("translate")
    public String translate(@RequestParam String eng, Model model){
        String vn = iTranslate.transVn(eng);
        model.addAttribute("vn", vn);
        return "/home";
    }
}
