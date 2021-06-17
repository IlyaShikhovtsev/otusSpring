package ru.shikhovtsev.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.shikhovtsev.dao.QuestionDao;
import ru.shikhovtsev.domain.Question;

import javax.annotation.Nonnull;
import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionDao questionDao;

    @Nonnull
    @Override
    public List<Question> getQuestions() {
        return questionDao.getQuestions();
    }
}
