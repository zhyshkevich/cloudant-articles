package com.test.articles.config.cloudant;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.MalformedURLException;
import java.net.URL;

public class CloudantConfig {

    private static final Logger LOG = LoggerFactory.getLogger(CloudantConfig.class);

    private final Environment environment;

    @Autowired
    public CloudantConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public CloudantClient cloudantClient() throws MalformedURLException {

            return ClientBuilder.url(new URL(environment.getProperty("cloudant.secure.couchUrl")))
                    .build();
    }
}
