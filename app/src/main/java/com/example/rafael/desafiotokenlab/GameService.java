package com.example.rafael.desafiotokenlab;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by rafael on 17/08/17.
 */

public interface GameService {

    @GET("games")
    Call<GameList> getObjGame();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://dl.dropboxusercontent.com/s/1b7jlwii7jfvuh/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
