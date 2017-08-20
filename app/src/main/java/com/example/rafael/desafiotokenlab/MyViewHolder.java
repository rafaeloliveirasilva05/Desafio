package com.example.rafael.desafiotokenlab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by rafael on 17/08/17.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView release_date;
    public TextView teste;
    public ImageView img;

    public MyViewHolder(View itemView) {
        super(itemView);

        name         = itemView.findViewById(R.id.txt_name);
        release_date = itemView.findViewById(R.id.txt_release_date);
        teste        = itemView.findViewById(R.id.txtTeste);
        img          = itemView.findViewById(R.id.img_game);
    }
}
