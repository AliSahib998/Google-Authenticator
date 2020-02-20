package az.pashabank.google.authenticator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @RequestMapping("/index")
    public String index(@RequestParam(value = "user") String userName, Model model) {
        model.addAttribute("user", userName);
        return "index";
    }

    @GetMapping("/invalidSession")
    public String invalidSession() {
        return "invalidSession";
    }










}
