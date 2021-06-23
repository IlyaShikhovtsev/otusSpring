package ru.shikhovtsev.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.shikhovtsev.config.YamlProps;
import ru.shikhovtsev.domain.Question;
import ru.shikhovtsev.exception.QuestionDaoException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionCsvDaoTest {

    @Test
    void simple() {
        var props = new YamlProps();
        props.setFilename("questions.csv");
        var questionDao = new QuestionCsvDao(props);
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
        var props = new YamlProps();
        props.setFilename("not-existing-file");
        assertThrows(QuestionDaoException.class, () -> new QuestionCsvDao(props));
    }

    @Test
    @DisplayName("file with questions is empty")
    void emptyFile() {
        var props = new YamlProps();
        props.setFilename("empty.csv");
        assertTrue(new QuestionCsvDao(props).getQuestions().isEmpty());
    }
}