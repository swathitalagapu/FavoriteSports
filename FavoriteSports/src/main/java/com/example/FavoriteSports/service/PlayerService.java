package com.example.FavoriteSports.service;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.FavoriteSports.dto.FavoriteSport;
import com.example.FavoriteSports.entity.PlayerDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional

public class PlayerService {
    private static List<PlayerDetails> players;
    private static List<FavoriteSport> favoriteSport;


    public PlayerService() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        players = Arrays.asList(mapper.readValue(new File("FavoriteSports/src/main/resources/json/player.json"), PlayerDetails[].class));

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

    public List<FavoriteSport> getSports() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        favoriteSport = Arrays.asList(mapper.readValue(new File("FavoriteSports/src/main/resources/json/sport.json"), FavoriteSport.class));
        return favoriteSport;

    }


    public List<PlayerDetails> getPlayersWithFavoriteSports() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<PlayerDetails> players = new ArrayList<>();
        PlayerDetails[] allPlayers = Arrays.asList(mapper.readValue(new File("FavoriteSports/src/main/resources/json/player.json"), PlayerDetails[].class)).toArray(new PlayerDetails[0]);
        List<String> favoriteSports = FavoriteSportsImpl.getFavorite_sports().getFavorite_sports();
        System.out.println(favoriteSports);
        for (PlayerDetails player : allPlayers) {
            if (favoriteSports .contains(player.getFavorite_sport())) {
                players.add(player);
            }
        }

        return players;
    }
}


