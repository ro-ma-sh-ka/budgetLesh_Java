package com.example.budgetLesh.controllers;

import com.example.budgetLesh.Repo.BudgetRepository;
import com.example.budgetLesh.models.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class BudgetController {

    // annotation to link variable budgetRepository which connect to repository BudgetRepository
    @Autowired
    private BudgetRepository budgetRepository;

    @GetMapping("/expenses")
    public String expensesMain(Model model) {

        // create an iterable object with all data from repository
        Iterable<Budget> budget = budgetRepository.findAll();
        // send the object to a template as the variable "budget"
        model.addAttribute("budget", budget);
        return ("expenses");
    }

    // function to show a user form by annotation GetMapping
    @GetMapping("/expenses/add")
    public String expenseAddForm(Model model) {
        return("expense_add");
    }

    // the same address but we catch user data thanks to annotation PostMapping
    @PostMapping("/expenses/add")
    public String expenseAdd(@RequestParam Date date,
                             @RequestParam String what_is,
                             @RequestParam String section,
                             @RequestParam Float total,
                             @RequestParam String currency,
                             Model model) {
        Budget new_expense = new Budget(date, what_is, section, total, currency);
        budgetRepository.save(new_expense);
        return("redirect:/expenses");
    }
}
