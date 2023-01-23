package com.example.budgetLesh.controllers;

import com.example.budgetLesh.Repo.BudgetRepository;
import com.example.budgetLesh.Repo.currencyRepository;
import com.example.budgetLesh.models.Budget;
import com.example.budgetLesh.models.Currency;
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
    @Autowired
    private com.example.budgetLesh.Repo.currencyRepository currencyRepository;

    @GetMapping("/expenses")
    public String expensesMain(Model model) {

        // create an iterable object with all data from repository
        Iterable<Budget> budget = budgetRepository.findAll();
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
        Budget expense = new Budget(date, what_is, section, total, currency);
        budgetRepository.save(expense);
        return("redirect:/expenses");
    }

    @GetMapping("/currencies")
    public String currenciesMain(Model model) {
        Iterable<Currency> currency = currencyRepository.findAll();
        model.addAttribute("currency", currency);
        return ("currencies");
    }

    // function to show a user form by annotation GetMapping
    @GetMapping("/currencies/add")
    public String currencyAddForm(Model model) {
        return("currency_add");
    }

    // the same address but we catch user data thanks to annotation PostMapping
    @PostMapping("/currencies/add")
    public String currencyAdd(@RequestParam String currency,
                              @RequestParam String country,
                              Model model) {
        Currency new_currency = new Currency(currency, country);
        currencyRepository.save(new_currency);
        return("redirect:/currencies");
    }

    @GetMapping("/sections")
    public String sectionsMain(Model model) {
        return ("sections");
    }
}
