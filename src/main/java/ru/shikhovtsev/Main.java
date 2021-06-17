package ru.shikhovtsev;

import org.springframework.context.annotation.*;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.shikhovtsev.service.ConsoleService;
import ru.shikhovtsev.service.KnowledgeService;

@PropertySource("/application.properties")
@ComponentScan
@Configuration
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Main.class);
        var knowledgeService = context.getBean(KnowledgeService.class);
        knowledgeService.testStudent();
    }

    @Bean
    public ConsoleService consoleService() {
        return new ConsoleService(System.out, System.in);
    }

    @Bean
    public MessageSourceAccessor messageSourceAccessor() {
        var messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return new MessageSourceAccessor(messageSource);
    }
}
