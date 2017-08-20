package com.example.rafael.desafiotokenlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.tb_main);
        mToolbar.setTitle("Lista de Games");
        setSupportActionBar(mToolbar);
    }

    public void carregarLista (View view){
        Intent  intent = new Intent(this, ListaGamesActivity.class);
        startActivity(intent);
    }
}
