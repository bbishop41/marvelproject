package com.bishop.marvel.marvelserver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by BrentB on 6/16/2018.
 */

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate RestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper ObjectMapper() {
        return new ObjectMapper();
    }
}
