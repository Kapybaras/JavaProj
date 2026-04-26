package uk.ac.bangor.cs.a3.academigymraeg.controllers;

import uk.ac.bangor.cs.a3.academigymraeg.models.Test;
import uk.ac.bangor.cs.a3.academigymraeg.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/test")
public class StudentController {

    @Autowired
    private TestService testService;

    @GetMapping("/take")
    public String takeTest(Model model, Authentication auth) {
        String username = (auth != null) ? auth.getName() : "Guest";
        Test test = testService.generateNewTest(username);
        model.addAttribute("test", test);
        return "student/take-test";
    }

    @PostMapping("/submit")
    public String submitTest(@ModelAttribute("test") Test test, Model model) {
        Test gradedStats = testService.submitTest(test);
        model.addAttribute("result", gradedStats);
        return "student/test-results";
    }
}