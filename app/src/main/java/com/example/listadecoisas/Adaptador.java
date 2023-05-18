package com.example.listadecoisas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> {
    public Adaptador(Context context, ArrayList<ListaEItens> lista, OnItemClickListener listener) {
        this.context = context;
        this.lista = lista;
        this.listener = listener;
    }

    Context context;
    ArrayList<ListaEItens> lista;
    Adaptador.OnItemClickListener listener;


    @NonNull
    @Override
    public Adaptador.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        return new Adaptador.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.MyViewHolder holder, int position) {
        ListaEItens n = lista.get(position);
        holder.nomeLista.setText(n.getNomeLista());
        holder.item.setText(n.getItem());
        holder.itemView.setOnClickListener(view ->{
            listener.onItemClick(n);
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
    public interface OnItemClickListener {
        void onItemClick(ListaEItens n);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item, nomeLista;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            nomeLista = itemView.findViewById(R.id.nomeLista);
        }
    }
}
