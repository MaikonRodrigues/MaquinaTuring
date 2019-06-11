package com.example.maikon.maquinaturing.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.maikon.maquinaturing.Classes.ElementoFita;
import com.example.maikon.maquinaturing.R;
import static com.example.maikon.maquinaturing.R.layout.item_fita;


import java.util.List;


public class ItemFitaAdapter extends RecyclerView.Adapter<ItemFitaAdapter.ItemFitaHolder> {

    List<ElementoFita> listElementos;
    Context context;
    String id;

    public ItemFitaAdapter(List<ElementoFita> listElementos, Context context){
        this.listElementos = listElementos;
        this.context = context;
    }


    @NonNull
    @Override
    public ItemFitaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista =  LayoutInflater.from(parent.getContext()).inflate(item_fita, parent, false);
        return new ItemFitaAdapter.ItemFitaHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemFitaHolder itemFitaHolder, final int position) {

       // id = listDesafio.get(position).getId();
      //  bebHolder.campoNome.setText(listDesafio.get(position).getNome());
      //  bebHolder.campoDuracao.setText(listDesafio.get(position).getDuracao());

        itemFitaHolder.simboloDoItem.setText(String.valueOf(listElementos.get(position).getValorElemento()));


    }

    @Override
    public int getItemCount() {
        return listElementos.size();
    }

    public class ItemFitaHolder extends RecyclerView.ViewHolder {

        TextView simboloDoItem;


        public ItemFitaHolder(@NonNull View itemView) {
            super(itemView);

            simboloDoItem= (TextView) itemView.findViewById(R.id.txtItem);

        }
    }
}