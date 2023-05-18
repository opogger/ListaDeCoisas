package com.example.listadecoisas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Cadastro extends AppCompatActivity {
    static ArrayList<Usuario> listinha;
    EditText novoLogin, novaSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        getSupportActionBar().hide();
        novoLogin = findViewById(R.id.loginC);
        novaSenha = findViewById(R.id.senhaC);
    }
    public void cadastrar (View view) {
        try {
            String login = novoLogin.getText().toString();
            String senha = novaSenha.getText().toString();
            if (verificaSeExiste(login)) {
                Toast.makeText(this, "O login já existe!", Toast.LENGTH_SHORT).show();
            } else {
                Usuario u = new Usuario(login, senha);
                listinha.add(u);
                super.onBackPressed();
            }
        }
        catch (Exception e){
            Toast.makeText(this, "Insira um valor válido!", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean verificaSeExiste(String login){
        for (Usuario u : listinha){
            if (login.equals(u.getLogin())){
                return true;
            }
        }
        return false;
    }
    public void login(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}