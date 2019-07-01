package com.example.maikon.maquinaturing.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maikon.maquinaturing.Classes.ElementoFita;
import com.example.maikon.maquinaturing.R;

import java.util.List;

import static com.example.maikon.maquinaturing.R.layout.item_fita;
import static com.example.maikon.maquinaturing.R.layout.item_kbc_fita;


public class ItemKbcAdapter extends RecyclerView.Adapter<ItemKbcAdapter.ItemFitaHolder> {

    List<ElementoFita> listElementos;
    Context context;
    String id;

    public ItemKbcAdapter(List<ElementoFita> listElementos, Context context){
        this.listElementos = listElementos;
        this.context = context;
    }


    @NonNull
    @Override
    public ItemFitaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista =  LayoutInflater.from(parent.getContext()).inflate(item_kbc_fita, parent, false);
        return new ItemKbcAdapter.ItemFitaHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemFitaHolder itemFitaHolder, final int position) {

      // itemFitaHolder.simboloDoItem.setText(String.valueOf(listElementos.get(position).getValorElemento()));

            // seta como invisivel os itens > que 0
        if (position > 0) itemFitaHolder.card_viewCabFita.setVisibility(View.INVISIBLE);

            //pegando posicao do item na lista
        itemFitaHolder.position = position;

    }

    @Override
    public int getItemCount() {
        return listElementos.size();
    }

    // função para setar a visibilidade dos itens
    public void configCabecote(){

    }

    public class ItemFitaHolder extends RecyclerView.ViewHolder {

        TextView simboloDoItem;
        CardView card_viewCabFita;
        int position;

        public ItemFitaHolder(@NonNull View itemView) {
            super(itemView);

            simboloDoItem= (TextView) itemView.findViewById(R.id.txtItemKbc);
            card_viewCabFita = (CardView) itemView.findViewById(R.id.card_viewCabFita);

        }
    }
}