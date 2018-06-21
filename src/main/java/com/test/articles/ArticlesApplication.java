package com.test.articles;

import com.test.articles.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)

public class ArticlesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticlesApplication.class, args);
    }
}
