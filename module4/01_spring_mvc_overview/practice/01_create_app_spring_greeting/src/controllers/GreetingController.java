package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


//dấu lớp GreetingController là một controller (đối tượng sẽ xử lý các request)
@Controller
public class GreetingController {

//    annotation để đánh dấu phương thức greeting() là một phương thức dùng để xử lý request ở get
//    @GetMapping("/greeting")
//    public String greeting() {
//        return "index";
//    }


    //    @RequestParam: là annotation để đánh dấu rằng name là tham số được truyền vào
    @GetMapping("/greeting")
    public String greeting(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
//        modle.addAttribute("name1", name1);
        return "index";
    }

//        model: là đối tượng để truyền dữ liệu từ controller sang view
//        model.addAttribute(): là phương thức để truyền một dữ liệu từ controller sang view



}
