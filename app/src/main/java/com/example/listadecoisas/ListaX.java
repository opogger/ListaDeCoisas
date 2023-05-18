package com.example.listadecoisas;

import static com.example.listadecoisas.Lista.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListaX extends AppCompatActivity {
    static ListaEItens listaX;
    //static ArrayList <ListaEItens> lista;
    EditText nomeLista1, itensLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_x);
        getSupportActionBar().hide();
        nomeLista1 = findViewById(R.id.nomeListaX);
        itensLista = findViewById(R.id.itensX);

        nomeLista1.setText(listaX.nomeLista);
        itensLista.setText(listaX.item);
    }
    public void Excluir(View view){
         lista.remove(listaX);
         super.onBackPressed();
    }
    public void editar(View view){
        String novoNomeLista = nomeLista1.getText().toString();
        String novosItensLista = itensLista.getText().toString();
        listaX.setNomeLista(novoNomeLista);
        listaX.setItem(novosItensLista);
        super.onBackPressed();
    }

}