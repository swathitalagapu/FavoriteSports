package com.example.FavoriteSports.service;

import com.example.FavoriteSports.dto.FavoriteSport;
import com.example.FavoriteSports.entity.PlayerDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
@Service
public class FavoriteSportsImpl {
    @Bean
    public List<PlayerDetails> players() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<PlayerDetails> players = Arrays.asList(mapper.readValue(new File("FavoriteSports/src/main/resources/json/player.json"), PlayerDetails[].class));

        return players;
    }

    @Bean
    public List<FavoriteSport> favoriteSports() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<FavoriteSport> favoriteSports = Arrays.asList(mapper.readValue(new File("FavoriteSports/src/main/resources/json/sport.json"), FavoriteSport.class));

        return favoriteSports;
    }
}

