package com.example.rafael.desafiotokenlab;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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
    private Context context;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_games);

        context = this;
        mToolbar = (Toolbar) findViewById(R.id.tb_main);
        mToolbar.setTitle("Lista de Games");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mProgressBar = (ProgressBar)findViewById(R.id.progressBar);
        mProgressBar.setVisibility(View.VISIBLE);

        GameService gameService = GameService.retrofit.create(GameService.class);

        final Call<GameList> serviceGame = gameService.getObjGame();
        serviceGame.enqueue(new Callback<GameList>() {
            @Override
            public void onResponse(Call<GameList> call, Response<GameList> response) {

                if(response.isSuccessful()){
                    GameList gameListBody = response.body();

                    gameList = gameListBody.getGames();

                    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
                    recyclerView.setAdapter(new GameAdapter(gameList,context));
                    LinearLayoutManager layout = new LinearLayoutManager(context,
                               LinearLayoutManager.VERTICAL, false);

                    recyclerView.setLayoutManager(layout);
                    mProgressBar.setVisibility(View.GONE);
                }
                else{
                    //Caso o endpoint nao seja encontrado, o usuario receberá uma mensagem
                    if(response.code() == 404){
                        mProgressBar.setVisibility(View.GONE);
                        AlertDialog.Builder msgBox = new AlertDialog.Builder(context);
                        msgBox.setTitle("Não foi possivel carregar a lista de Games no momento.");

                        msgBox.setPositiveButton("Voltar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        });
                        msgBox.show();
                    }
                }
            }
            @Override
            public void onFailure(Call<GameList> call, Throwable t) {

                //Caso não tenha conexão com a internet o usuario recebera uma mensage de erro de conexão
                mProgressBar.setVisibility(View.GONE);
                AlertDialog.Builder msgBox = new AlertDialog.Builder(context);
                msgBox.setTitle("Falha na conexão com a Iternet");

                msgBox.setPositiveButton("Voltar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                msgBox.show();
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
