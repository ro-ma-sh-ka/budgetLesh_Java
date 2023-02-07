package com.example.budgetLesh.controllers;

import com.example.budgetLesh.Repo.CurrencyRepository;
import com.example.budgetLesh.models.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class CurrencyController {

    // annotation to link variable currencyRepository which connect to repository CurrencyRepository
    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping("/currencies")
    public String currenciesMain(Model model) {
        Iterable<Currency> currencies = currencyRepository.findAll();
        model.addAttribute("currencies", currencies);
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

    @GetMapping("/currency_edit/{id}")
    public String currencyEditForm(@PathVariable(value = "id") long id, Model model) {
        Optional<Currency> currency = currencyRepository.findById(id);
        ArrayList<Currency> currencyToEdit = new ArrayList<>();
        currency.ifPresent(currencyToEdit::add);
        model.addAttribute("currency", currencyToEdit);
        return ("currency_edit");
    }

    @PostMapping("/currency_edit/{id}")
    public String currencyEdit(@PathVariable(value = "id") long id,
                               @RequestParam String currency,
                               @RequestParam String country,
                               Model model) {

        // method orElseThrow calls exception if something wrong
        Currency currencyToEdit = currencyRepository.findById(id).orElseThrow();
        currencyToEdit.setCurrency(currency);
        currencyToEdit.setCountry(country);
        currencyRepository.save(currencyToEdit);
        return("redirect:/currencies");
    }

    @PostMapping("/currency_delete/{id}")
    public String currencyDelete(@PathVariable(value = "id") long id,
                                 Model model) {
        currencyRepository.deleteById(id);
        return("redirect:/currencies");
    }
}
