package com.example.listadecoisas;

import static com.example.listadecoisas.Lista.lista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CriaLista extends AppCompatActivity {
    EditText novaLista, novosItensLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_lista);
        getSupportActionBar().hide();
        novaLista = findViewById(R.id.pegaNomeLista);
        novosItensLista = findViewById(R.id.pegaItensLista);
    }
    public void cadastrar (View view) {
        try {
            String nomeLista = novaLista.getText().toString();
            String item = novosItensLista.getText().toString();
            ListaEItens n = new ListaEItens(nomeLista, item);
                lista.add(n);
                super.onBackPressed();

        }
        catch (Exception e){
            Toast.makeText(this, "Insira um valor válido!", Toast.LENGTH_SHORT).show();
        }
    }

}