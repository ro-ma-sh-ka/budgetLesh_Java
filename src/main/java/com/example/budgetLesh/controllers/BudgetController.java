package com.example.budgetLesh.controllers;

import com.example.budgetLesh.Repo.BudgetRepository;
import com.example.budgetLesh.models.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BudgetController {

    // annotation to link variable budgetRepository which connect to repository BudgetRepository
    @Autowired
    private BudgetRepository budgetRepository;

    @GetMapping("/expenses")
    public String expensesMain(Model model) {

        // create an iterable object with all data from repository
        Iterable<Budget> budget = budgetRepository.findAll();
        model.addAttribute("budget", budget);
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
