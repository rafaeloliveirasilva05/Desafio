package com.example.rafael.desafiotokenlab;

import com.example.rafael.desafiotokenlab.domain.Game;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by rafael on 17/08/17.
 */

public class GameList {
    @SerializedName("games")
    private List<Game> games;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
