package com.bishop.marvel.marvelserver.rest;


import com.bishop.marvel.marvelserver.services.CharacterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BrentB on 6/16/2018.
 */

@RestController
public class MarvelRestService {

    CharacterService characterService;

    @GetMapping("/characters")
    @CrossOrigin(origins = "http://localhost:4200")
    public Object getCharacterList() {
        characterService = new CharacterService();
        return characterService.getCharacterList();
    }
}
