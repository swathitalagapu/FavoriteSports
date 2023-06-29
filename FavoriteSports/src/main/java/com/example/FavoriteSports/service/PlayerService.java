package com.example.FavoriteSports.service;


import com.example.FavoriteSports.dto.FavoriteSport;
import com.example.FavoriteSports.entity.PlayerDetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        favoriteSport =  Arrays.asList(mapper.readValue(new File("FavoriteSports/src/main/resources/json/sport.json"), FavoriteSport.class));
        return  favoriteSport;

    }

//    public List<PlayerDetails> getPlayerPresentInSports() throws IOException {
////        ObjectMapper mapper =new ObjectMapper();
////        List<FavoriteSport> favorite
////        favorite = Arrays.asList(mapper.readValue(new File("FavoriteSports/src/main/resources/json/sport.json"), FavoriteSport.class));
//        List<PlayerDetails> play = new ArrayList<>();
//        for (PlayerDetails pd : players) {
//            if (favoriteSport.contains(pd.getFavorite_sport())) {
//                play.add(pd);
//            }
//        }
//        return play;
//
//
//    }

//    public List<PlayerDetails> getPlayersWithFavoriteSports() throws IOException{
//        ObjectMapper mapper= new ObjectMapper();
//         favoriteSport = Arrays.asList(mapper.readValue(new File("FavoriteSports/src/main/resources/json/sport.json"), FavoriteSport.class));
//
//
//        List<PlayerDetails> playersWithFavoriteSports = new ArrayList<>();
//
//        for (PlayerDetails player : players) {
//            if (favoriteSport.contains(player.getFavorite_sport())) {
//                playersWithFavoriteSports.add(player);
//            }
//        }
//
//        return playersWithFavoriteSports;
//    }

    public List<PlayerDetails> getPlayersWithFavoriteSports() throws IOException {
        List<String> favoriteSportsList =new ArrayList<>();

        return players.stream()
                .filter(player -> favoriteSportsList.contains(player.getFavorite_sport()))
                .collect(Collectors.toList());
    }
}

//favoriteSport.getFavorite_sports();