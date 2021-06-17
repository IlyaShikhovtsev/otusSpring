package ru.shikhovtsev.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.shikhovtsev.domain.Question;
import ru.shikhovtsev.exception.QuestionDaoException;

import javax.annotation.Nonnull;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class QuestionCsvDao implements QuestionDao {
    private final List<Question> questions;

    public QuestionCsvDao(@Value("${filename}") String filename) {
        Objects.requireNonNull(filename);

        this.questions = loadFromCsv(filename);
    }

    private List<Question> loadFromCsv(String filename) {
        InputStream streamFromCsv = this.getClass().getClassLoader().getResourceAsStream(filename);
        if (streamFromCsv == null) {
            throw new QuestionDaoException("file is not exists");
        }

        var reader = new BufferedReader(new InputStreamReader(streamFromCsv));
        List<String> linesWithQuestion = reader.lines().collect(Collectors.toList());

        return linesWithQuestion.stream().map(line -> line.split(";"))
                .filter(splitted -> splitted.length == 2)
                .map(splitted -> new Question(splitted[0], splitted[1])).collect(Collectors.toList());
    }

    @Nonnull
    @Override
    public List<Question> getQuestions() {
        return questions;
    }
}
