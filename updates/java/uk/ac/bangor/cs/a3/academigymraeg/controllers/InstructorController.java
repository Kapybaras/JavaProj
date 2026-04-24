package uk.ac.bangor.cs.a3.academigymraeg.controllers;

import uk.ac.bangor.cs.a3.academigymraeg.models.Noun;
import uk.ac.bangor.cs.a3.academigymraeg.services.NounService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nouns/manage")
public class InstructorController {

    @Autowired
    private NounService nounService;

    @GetMapping
    public String listNouns(Model model) {
        model.addAttribute("nouns", nounService.getAllNouns());
        return "instructor/list-nouns";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("noun", new Noun());
        return "instructor/noun-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Noun noun = nounService.getNounById(id);
        model.addAttribute("noun", noun);
        return "instructor/noun-form";
    }

    @PostMapping("/save")
    public String saveNoun(@ModelAttribute("noun") Noun noun) {
        nounService.saveNoun(noun);
        return "redirect:/nouns/manage";
    }

    @GetMapping("/delete/{id}")
    public String deleteNoun(@PathVariable("id") Long id) {
        nounService.deleteNoun(id);
        return "redirect:/nouns/manage";
    }
}