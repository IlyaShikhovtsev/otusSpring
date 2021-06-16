package ru.shikhovtsev.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.shikhovtsev.domain.Question;
import ru.shikhovtsev.exception.QuestionDaoException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionCsvDaoTest {

    @Test
    void simple() {
        var questionDao = new QuestionCsvDao("questions.csv");
        List<Question> questions = questionDao.getQuestions();
        assertEquals(5, questions.size());
        assertEquals(new Question("1?", "yes"), questions.get(0));
        assertEquals(new Question("2?", "2"), questions.get(1));
        assertEquals(new Question("3?", "no"), questions.get(2));
        assertEquals(new Question("4?", "yes"), questions.get(3));
        assertEquals(new Question("5?", "no"), questions.get(4));
    }

    @Test
    @DisplayName("file with questions is not exist")
    void fileNotExist() {
        assertThrows(QuestionDaoException.class, () -> new QuestionCsvDao("not-existing-file"));
    }

    @Test
    @DisplayName("file with questions is empty")
    void emptyFile() {
        assertTrue(new QuestionCsvDao("empty.csv").getQuestions().isEmpty());
    }
}