package com.example.budgetLesh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BudgetController {
    @GetMapping("/expenses")
    public String expensesMain(Model model) {
        return ("expenses");
    }

    @GetMapping("/currencies")
    public String currenciesMain(Model model) {
        return ("currencies");
    }

    @GetMapping("/sections")
    public String sectionsMain(Model model) {
        return ("sections");
    }
}
