package com.example.budgetLesh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


// this class responsible for processing all transition between pages of our site
@Controller
public class MainController {

    // GetMapping call function home when we go to page home
    @GetMapping("/")
    public String home(Model model) {

        // send parameters to template
        model.addAttribute("title", "Main page");

        // call html template HOME
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "about");
        return "about";
    }

}