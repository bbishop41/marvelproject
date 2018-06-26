package com.bishop.marvel.marvelserver.rest;


import com.bishop.marvel.marvelserver.services.CharacterService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BrentB on 6/16/2018.
 */

@RestController
public class MarvelRestService {

    private CharacterService characterService;

    @GetMapping("/characters")
    @CrossOrigin(origins = "http://localhost:4200")
    public Object getCharacterList() {
        characterService = new CharacterService();
        return characterService.getCharacterList();
    }

    @GetMapping("/characters/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Object getCharacter(@PathVariable("id") Integer id) {
        characterService = new CharacterService();
        return characterService.getHero(id);
    }
}
