package ru.shikhovtsev.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import ru.shikhovtsev.domain.Question;

import java.util.List;

@RequiredArgsConstructor
@Service
public class KnowledgeServiceImpl implements KnowledgeService {
    private final MessageSourceAccessor messageSourceAccessor;
    private final ConsoleService consoleService;
    private final QuestionService questionService;

    @Override
    public void testStudent() {
        consoleService.println(messageSourceAccessor.getMessage("hello"));
        String firstName = consoleService.readLine();
        consoleService.println(messageSourceAccessor.getMessage("lastname"));
        String lastName = consoleService.readLine();

        List<Question> questions = questionService.getQuestions();
        int result = askQuestions(questions);
        consoleService.println(messageSourceAccessor.getMessage("result", new Object[]{firstName, lastName, result}));
    }

    private int askQuestions(List<Question> questions) {
        if (questions.isEmpty()) {
            consoleService.println(messageSourceAccessor.getMessage("lucky"));
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
