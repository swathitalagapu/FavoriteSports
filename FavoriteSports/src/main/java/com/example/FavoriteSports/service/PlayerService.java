package com.example.FavoriteSports.service;


import com.example.FavoriteSports.entity.PlayerDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional

public class PlayerService {
    private final List<PlayerDetails> players;


    public PlayerService() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        players = Arrays.asList(mapper.readValue(new File("FavoriteSports/src/main/resources/player.json"), PlayerDetails[].class));
//
    }


    public List<PlayerDetails> getAllPlayers() {
        return players;

    }

    public PlayerDetails getPlayerByFavouriteSport(String favorite_sport) {

        return players.stream()
                .filter(player -> player.getFavorite_sport().equals(favorite_sport))
                .findFirst()
                .orElse(null);
    }


}
