package az.pashabank.google.authenticator.controller;

import az.pashabank.google.authenticator.model.RegistrationDto;
import az.pashabank.google.authenticator.service.UserService;
import az.pashabank.google.authenticator.util.QrCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private QrCode qrCode;


    @GetMapping("/registration")
    public String registration () {
        return "registration";
    }

    @GetMapping("/login")
    public String login () {
        return "login";
    }

    @PostMapping("/registration/confirm")
    public String registration (RegistrationDto registrationDto, Model model) {
        if(registrationDto.isUsing2FA()){
            String token = userService.registration(registrationDto);
            return "redirect:/qr?token="+token;
        }
        return "redirect:/registration?confirm=true";
    }

    @GetMapping ("/qr")
    public String qr (@RequestParam(value = "token") String token, Model model) {

        token = qrCode.qrCodeGenerator(token);
        model.addAttribute("token", token);
        return "qrcode";
    }




}
