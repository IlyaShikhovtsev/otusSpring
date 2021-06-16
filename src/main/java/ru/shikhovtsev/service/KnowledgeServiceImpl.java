package ru.shikhovtsev.service;

import lombok.RequiredArgsConstructor;
import ru.shikhovtsev.domain.Question;

import java.util.List;

@RequiredArgsConstructor
public class KnowledgeServiceImpl implements KnowledgeService {
    private final ConsoleService consoleService;
    private final QuestionService questionService;

    @Override
    public void testStudent() {
        consoleService.println("Hello, what's your first name?");
        String firstName = consoleService.readLine();
        consoleService.println("last name?");
        String lastName = consoleService.readLine();

        List<Question> questions = questionService.getQuestions();
        int result = askQuestions(questions);
        consoleService.println(String.format("%s %s, your result is %d", firstName, lastName, result));
    }

    private int askQuestions(List<Question> questions) {
        if (questions.isEmpty()) {
            consoleService.println("You are lucky! There are no questions for you!");
            return -1;
        }

        var result = 0;
        for (Question question : questions) {
            consoleService.println(question.question());
            String answer = consoleService.readLine();
            if (question.answer().equalsIgnoreCase(answer.trim())) {
                result++;
            }
        }
        return result;
    }
}
