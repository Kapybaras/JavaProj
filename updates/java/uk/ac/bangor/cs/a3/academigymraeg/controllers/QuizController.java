package uk.ac.bangor.cs.a3.academigymraeg.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import uk.ac.bangor.cs.a3.academigymraeg.models.Noun;
import uk.ac.bangor.cs.a3.academigymraeg.models.Test;
import uk.ac.bangor.cs.a3.academigymraeg.models.TestResult;
import uk.ac.bangor.cs.a3.academigymraeg.repositories.NounRepository;
import uk.ac.bangor.cs.a3.academigymraeg.repositories.TestRepository;

@Controller
@SessionAttributes("test") // Changed from 'currentTest' to match your form th:object="${test}"
public class QuizController {

    @Autowired
    private NounRepository nounRepo;

    @Autowired
    private TestRepository testRepo;

    @GetMapping("/start-test")
    public String startTest(Model model) {
        Test test = new Test();
        test.setUsername("crk24xgr"); 
        
        List<Noun> allNouns = nounRepo.findAll();
        Random rand = new Random();

        // Generate 20 questions immediately when the test starts
        for (int i = 0; i < 20; i++) {
            Noun target = allNouns.get(rand.nextInt(allNouns.size()));
            int type = rand.nextInt(3); // 0: Welsh->Eng, 1: Eng->Welsh, 2: Gender
            
            TestResult result = new TestResult();
            
            if (type == 0) {
                result.setQuestionText("What is the English for: " + target.getWelsh() + "?");
                result.setCorrectAnswer(target.getEnglish());
            } else if (type == 1) {
                result.setQuestionText("What is the Welsh for: " + target.getEnglish() + "?");
                result.setCorrectAnswer(target.getWelsh());
            } else {
                result.setQuestionText("What is the gender of: " + target.getWelsh() + "?");
                // Ensure this matches your radio button values (e.g., "Masculine" vs "masculine")
                result.setCorrectAnswer(target.getGender()); 
            }
            
            test.getDetails().add(result);
        }

        model.addAttribute("test", test);
        return "take-test"; // This returns your styled HTML page
    }

    @PostMapping("/test/submit") // Matches th:action="@{/test/submit}"
    public String submitTest(@ModelAttribute("test") Test test) {
        int finalScore = 0;

        for (TestResult res : test.getDetails()) {
            // Compare student answer to correct answer (ignoring case and whitespace)
            if (res.getStudentAnswer() != null && 
                res.getStudentAnswer().trim().equalsIgnoreCase(res.getCorrectAnswer().trim())) {
                res.setCorrect(true);
                finalScore++;
            } else {
                res.setCorrect(false);
            }
        }

        test.setScore(finalScore);
        
        // This saves the Test AND all 20 TestResults because of CascadeType.ALL
        testRepo.save(test); 
        
        return "redirect:/results";
    }
}