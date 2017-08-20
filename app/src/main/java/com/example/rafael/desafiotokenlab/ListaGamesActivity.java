package com.example.rafael.desafiotokenlab;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.rafael.desafiotokenlab.adapters.GameAdapter;
import com.example.rafael.desafiotokenlab.domain.Game;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaGamesActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private List<Game> gameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_games);

        final Context c = this;
        mToolbar = (Toolbar) findViewById(R.id.tb_main);
        mToolbar.setTitle("Lista de Games");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GameService gameService = GameService.retrofit.create(GameService.class);

        final ProgressBar mProgressBar = (ProgressBar)findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.VISIBLE);

        Call<GameList> serviceGame = gameService.getObjGame();
        serviceGame.enqueue(new Callback<GameList>() {
            @Override
            public void onResponse(Call<GameList> call, Response<GameList> response) {

                if(response.isSuccessful()){
                    GameList t = response.body();
                    gameList = t.getGames();

                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
                    recyclerView.setAdapter(new GameAdapter(gameList,c));
                    LinearLayoutManager layout = new LinearLayoutManager(c,
                            LinearLayoutManager.VERTICAL, false);

                    recyclerView.setLayoutManager(layout);

                    mProgressBar.setVisibility(View.GONE);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Erro: "+response.code(),
                            Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<GameList> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Erro: "+t.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return true;
    }
}
