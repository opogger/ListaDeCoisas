package com.example.listadecoisas;

public class ListaEItens {
    String nomeLista;
    String item;

    public ListaEItens(String nomeLista, String item) {
        this.nomeLista = nomeLista;
        this.item = item;
    }

    public String getNomeLista() {
        return nomeLista;
    }

    public void setNomeLista(String nomeLista) {
        this.nomeLista = nomeLista;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
