package com.example.listadecoisas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText login, senha;
    static ArrayList<Usuario> listinha = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        login = findViewById(R.id.login);
        senha = findViewById(R.id.senha);
        Usuarios();
    }

    public void logar(View view) {
        try {
            String user = login.getText().toString();
            String pass = senha.getText().toString();
            for (Usuario u : listinha) {
                if (user.equals(u.getLogin()) && pass.equals(u.getSenha())) {
                    Intent i = new Intent(this, Lista.class);
                    startActivity(i);
                    Toast.makeText(this, "Bem vindo(a)!!", Toast.LENGTH_SHORT).show();
                }
            }
        }
        catch (Exception e) {
            Toast.makeText(this, "Por favor insira um valor válido", Toast.LENGTH_SHORT).show();
        }
    }

    public void cadastro(View view) {
        Intent i = new Intent(this, Cadastro.class);
        startActivity(i);
        Cadastro.listinha = listinha;
    }

    public void Usuarios(){
        Usuario teste = new Usuario ("1","1");
        listinha.add(teste);
    }
}