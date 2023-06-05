package ru.mobile.effective.SocialMediaAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    @ResponseBody
    public String welcome() {
        return "welcome";
    }
}
