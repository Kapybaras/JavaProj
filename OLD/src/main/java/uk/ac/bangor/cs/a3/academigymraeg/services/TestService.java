package uk.ac.bangor.cs.a3.academigymraeg.services;

import uk.ac.bangor.cs.a3.academigymraeg.models.Noun;
import uk.ac.bangor.cs.a3.academigymraeg.models.Test;
import uk.ac.bangor.cs.a3.academigymraeg.models.TestResult;
import uk.ac.bangor.cs.a3.academigymraeg.repositories.NounRepository;
import uk.ac.bangor.cs.a3.academigymraeg.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TestService {

    @Autowired
    private NounRepository nounRepository;

    @Autowired
    private TestRepository testRepository;

    private final Random random = new Random();

    public Test generateNewTest(String username) {
        List<Noun> randomNouns = nounRepository.findRandomNouns(20);
        Test test = new Test();
        test.setUsername(username);
        
        List<TestResult> details = new ArrayList<>();
        for (Noun noun : randomNouns) {
            details.add(createRandomQuestion(noun));
        }
        test.setDetails(details);
        return test;
    }

    private TestResult createRandomQuestion(Noun noun) {
        int type = random.nextInt(3);
        TestResult result = new TestResult();

        switch (type) {
            case 0:
                result.setQuestionText("Gender of '" + noun.getWelsh() + "'?");
                result.setCorrectAnswer(noun.getGender());
                break;
            case 1:
                result.setQuestionText("Meaning of '" + noun.getWelsh() + "'?");
                result.setCorrectAnswer(noun.getEnglish());
                break;
            case 2:
                result.setQuestionText("Welsh for '" + noun.getEnglish() + "'?");
                result.setCorrectAnswer(noun.getWelsh());
                break;
        }
        return result;
    }

    public Test submitTest(Test test) {
        int score = 0;
        for (TestResult row : test.getDetails()) {
            if (row.getStudentAnswer() != null && 
                row.getStudentAnswer().trim().equalsIgnoreCase(row.getCorrectAnswer().trim())) {
                row.setCorrect(true);
                score++;
            } else {
                row.setCorrect(false);
            }
        }
        test.setScore(score);
        return testRepository.save(test);
    }
}