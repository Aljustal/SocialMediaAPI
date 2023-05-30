package ru.mobile.effective.SocialMediaAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public void welcome() {
        System.out.println("welcome");
    }
}
