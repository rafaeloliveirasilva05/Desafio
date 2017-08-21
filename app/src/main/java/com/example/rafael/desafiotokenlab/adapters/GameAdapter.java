package com.example.rafael.desafiotokenlab.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.rafael.desafiotokenlab.MyViewHolder;
import com.example.rafael.desafiotokenlab.R;
import com.example.rafael.desafiotokenlab.domain.Game;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rafael on 17/08/17.
 */

public class GameAdapter extends RecyclerView.Adapter {
    private List<Game> gameList;
    private Context context;

    public GameAdapter(List<Game> gameList, Context context){
        this.gameList = gameList;
        this.context  = context;
    }

    //Esse método deverá retornar layout criado pelo ViewHolder já inflado em uma view.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //Seta o layout que cada item da lista ira possuir
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_game, parent, false);

        return new MyViewHolder(view);
    }

    // Aqui é recuperado o objeto da lista de objetos pela posição e associado à ViewHolder.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder holder = (MyViewHolder) viewHolder;

        Game game = gameList.get(position);

        holder.name.setText(game.getName());
        holder.release_date.setText(game.getRelease_date());
        holder.teste.setText(Arrays.toString(game.getPlatforms()).replaceAll("\\[|\\]", ""));

        Picasso.with(context).load(game.getImage()).into(((MyViewHolder) viewHolder).img);
    }

    //Método que deverá retornar quantos itens há na lista.
    @Override
    public int getItemCount() {
        return gameList.size();
    }
}
