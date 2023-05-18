package com.example.listadecoisas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Lista extends AppCompatActivity {
    static ArrayList <ListaEItens> lista = new ArrayList<>();
    RecyclerView recycler;
    Adaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        getSupportActionBar().hide();
        recycler = findViewById(R.id.rv);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        adaptador = new Adaptador(this, lista, new Adaptador.OnItemClickListener() {
            @Override
            public void onItemClick(ListaEItens n) {
                Intent i = new Intent (Lista.this, ListaX.class);
                startActivity(i);
                ListaX.listaX = n;
            }
        });
        recycler.setAdapter(adaptador);
        adaptador.notifyDataSetChanged();
    }
    public void telaCriaLista (View view){
        Intent i = new Intent(this, CriaLista.class);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adaptador.notifyDataSetChanged();
    }
}