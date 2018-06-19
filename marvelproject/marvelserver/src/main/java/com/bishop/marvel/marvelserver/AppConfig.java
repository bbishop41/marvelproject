package com.bishop.marvel.marvelserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by BrentB on 6/16/2018.
 */

@Configuration
public class AppConfig {

    @Bean
    @Autowired
    public RestTemplate RestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
