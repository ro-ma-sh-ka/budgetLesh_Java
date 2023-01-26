package com.example.budgetLesh.controllers;

import com.example.budgetLesh.Repo.SectionRepository;
import com.example.budgetLesh.models.Section;
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
public class SectionController {

    @Autowired
    private SectionRepository sectionRepository;

    @GetMapping("/sections")
    public String sectionsMain(Model model) {
        Iterable<Section> sections = sectionRepository.findAll();
        model.addAttribute("sections", sections);
        return ("sections");
    }

    @GetMapping("/sections/add")
    public String sectionAddForm(Model model) {
        return ("section_add");
    }

    @PostMapping("sections/add")
    public String sectionAdd(@RequestParam String section,
                             Model model) {
        Section new_section = new Section(section);
        sectionRepository.save(new_section);
        return("redirect:/sections");
    }

    @GetMapping("/section_edit/{id}")
    public String sectionEditForm(@PathVariable(value = "id") long id, Model model) {
        Optional<Section> section = sectionRepository.findById(id);
        ArrayList<Section> sectionToEdit = new ArrayList<>();
        section.ifPresent(sectionToEdit::add);
        model.addAttribute("section", sectionToEdit);
        return ("section_edit");
    }

    @PostMapping("/section_edit/{id}")
    public String sectionEdit(@PathVariable(value = "id") long id,
                              @RequestParam String section,
                              Model model) {
        Section sectionToEdit = sectionRepository.findById(id).orElseThrow();
        sectionToEdit.setSection(section);
        sectionRepository.save(sectionToEdit);
        return("redirect:/sections");
    }

    @PostMapping("/section_delete/{id}")
    public String sectionDelete(@PathVariable(value = "id") long id,
                                Model model) {
        sectionRepository.deleteById(id);
        return("redirect:/sections");
    }
}
