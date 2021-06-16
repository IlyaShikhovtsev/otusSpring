package ru.shikhovtsev.dao;

import ru.shikhovtsev.domain.Question;

import javax.annotation.Nonnull;
import java.util.List;

public interface QuestionDao {

    @Nonnull
    List<Question> getQuestions();

}
