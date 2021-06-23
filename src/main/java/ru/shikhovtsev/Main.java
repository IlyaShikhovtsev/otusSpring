package ru.shikhovtsev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.MessageSourceAccessor;
import ru.shikhovtsev.config.YamlProps;
import ru.shikhovtsev.service.ConsoleService;
import ru.shikhovtsev.service.KnowledgeService;

@SpringBootApplication
@EnableConfigurationProperties(YamlProps.class)
public class Main {
    public static void main(String[] args) {
        var context = SpringApplication.run(Main.class);

        var knowledgeService = context.getBean(KnowledgeService.class);
        knowledgeService.testStudent();
    }

    @Bean
    public ConsoleService consoleService() {
        return new ConsoleService(System.out, System.in);
    }

    @Bean
    public MessageSourceAccessor messageSourceAccessor(MessageSource messageSource) {
        return new MessageSourceAccessor(messageSource);
    }
}
