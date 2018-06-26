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

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper mapper;

    private UriComponents uriComponents;

    public List<Hero> getCharacterList(){
        String url = generateUrl("/characters", "");
        ResponseWrapper response = restTemplate.getForObject(url, ResponseWrapper.class);
        return mapper.convertValue(response.getData().getResults(), new TypeReference<List<Hero>>() { });
    }

    public Hero getHero(Integer id) {
        String url = generateUrl("/characters", "/" + id);
        ResponseWrapper response = restTemplate.getForObject(url, ResponseWrapper.class);
        return mapper.convertValue(response.getData().getResults().get(0), new TypeReference<Hero>() { });
    }

    private String generateUrl(String endpoint, String pathParams) {
        Date date = new Date();
        String timeStamp = new Timestamp(date.getTime()).toString();
        uriComponents = UriComponentsBuilder.newInstance()
        .scheme(Constants.scheme)
        .host(Constants.marvelHost)
        .path(Constants.marvelPathPrefix + endpoint + pathParams)
        .queryParam("ts", timeStamp)
        .queryParam("apikey", Constants.publicKey)
        .queryParam("hash", MD5Util.hash(Constants.publicKey, Constants.privateKey, timeStamp))
        .buildAndExpand();

        return uriComponents.toString();
    }
}
