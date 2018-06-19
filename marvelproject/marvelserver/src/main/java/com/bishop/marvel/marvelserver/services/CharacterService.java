package com.bishop.marvel.marvelserver.services;

import com.bishop.marvel.marvelserver.models.Hero;
import com.bishop.marvel.marvelserver.models.ResponseWrapper;
import com.bishop.marvel.marvelserver.util.Constants;
import com.bishop.marvel.marvelserver.util.MD5Util;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by BrentB on 6/16/2018.
 */
public class CharacterService {

    private RestTemplate restTemplate;
    private UriComponents uriComponents;

    public List<Hero> getCharacterList(){
        String url = generateUrl("/characters");
        restTemplate = new RestTemplateBuilder().build();
        ObjectMapper mapper = new ObjectMapper();
        ResponseWrapper response = restTemplate.getForObject(url, ResponseWrapper.class);
        return mapper.convertValue(response.getData().getResults(), new TypeReference<List<Hero>>() { });
    }

    private String generateUrl(String endpoint) {
        Date date = new Date();
        String timeStamp = new Timestamp(date.getTime()).toString();
        uriComponents = UriComponentsBuilder.newInstance()
        .scheme(Constants.scheme)
        .host(Constants.marvelHost)
        .path(Constants.marvelPathPrefix + endpoint)
        .queryParam("ts", timeStamp)
        .queryParam("apikey", Constants.publicKey)
        .queryParam("hash", MD5Util.hash(Constants.publicKey, Constants.privateKey, timeStamp))
        .buildAndExpand();

        return uriComponents.toString();
    }
}
