package com.test.articles.config;

import com.test.articles.config.cloudant.ArticlesDatabaseConfig;
import com.test.articles.config.cloudant.CloudantConfig;
import com.test.articles.config.swagger.SwaggerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Import({
        CloudantConfig.class,
        ArticlesDatabaseConfig.class,
        SwaggerConfig.class,
})
@PropertySources({
        @PropertySource("classpath:swagger.properties"),

})
@EnableSwagger2
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
