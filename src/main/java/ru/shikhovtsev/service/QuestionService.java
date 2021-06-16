package ru.shikhovtsev.service;

import ru.shikhovtsev.domain.Question;

import javax.annotation.Nonnull;
import java.util.List;

public interface QuestionService {

    @Nonnull
    List<Question> getQuestions();
}
