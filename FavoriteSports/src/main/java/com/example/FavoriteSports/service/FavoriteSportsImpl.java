package com.example.FavoriteSports.service;

import com.example.FavoriteSports.dto.FavoriteSport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@Service
public class FavoriteSportsImpl {

    public List<String> getFavorite_sports() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
         List<String> favorite_sports = Arrays.asList(String.valueOf(mapper.readValue(new File("FavoriteSports/src/main/resources/json/sport.json"), FavoriteSport.class)));
        return favorite_sports;
    }
}

