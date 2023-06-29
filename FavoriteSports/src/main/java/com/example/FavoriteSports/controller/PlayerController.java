package com.example.FavoriteSports.controller;
import com.example.FavoriteSports.dto.FavoriteSport;
import com.example.FavoriteSports.entity.PlayerDetails;
import com.example.FavoriteSports.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;
    @GetMapping("/player")
    public List<PlayerDetails> getPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/players/{favorite_sport}")
    public PlayerDetails getPlayer(@PathVariable String favorite_sport) {
        return playerService.getPlayerByFavouriteSport(favorite_sport);
    }
    @GetMapping("/sports")
    public List<FavoriteSport> getsportssss() throws IOException {

        return playerService.getSports();
    }

    @GetMapping("/hii")
    public List<PlayerDetails> hello() throws IOException {
        return playerService.getPlayersWithFavoriteSports();
    }


}

