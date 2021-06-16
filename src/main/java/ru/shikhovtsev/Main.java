package ru.shikhovtsev;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.shikhovtsev.service.KnowledgeService;

public class Main {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("spring-context.xml");
        var knowledgeService = context.getBean(KnowledgeService.class);
        knowledgeService.testStudent();
    }
}
