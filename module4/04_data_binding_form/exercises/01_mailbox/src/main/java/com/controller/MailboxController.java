package com.controller;

import com.model.bean.Language;
import com.model.bean.Mailbox;
import com.model.service.ILanguageService;
import com.model.service.IMailboxService;
import com.model.service.ISizeservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MailboxController {
    @Autowired
    private IMailboxService iMailboxService;
    @Autowired
    private ILanguageService iLanguageService;
    @Autowired
    private ISizeservice iSizeservice;



    @GetMapping(value = "")
    public String home(ModelMap model) {
        List<Language> list = iLanguageService.findAll();
        model.addAttribute("languageList", list);
        model.addAttribute("sizeList", iSizeservice.findAll());
        return "home";
    }

    @PostMapping(value = "save")
    public String update(int lang_id, int size_id, String spamsFilter, String signature, Model model){
        Mailbox mailbox = new Mailbox((iMailboxService.size()+ 1), lang_id, size_id, spamsFilter, signature);
        iMailboxService.save(mailbox);

        model.addAttribute("mailbox", mailbox);
        List<Language> list = iLanguageService.findAll();
        model.addAttribute("languageList", list);
        model.addAttribute("sizeList", iSizeservice.findAll());
        return "info";
    }


}
