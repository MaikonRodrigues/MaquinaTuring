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

        final RecyclerView.LayoutParams layoutParams =
                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        vista.setLayoutParams(layoutParams);
        return new ItemFitaAdapter.ItemFitaHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemFitaHolder itemFitaHolder, final int position) {

       // id = listDesafio.get(position).getId();
      //  bebHolder.campoNome.setText(listDesafio.get(position).getNome());
      //  bebHolder.campoDuracao.setText(listDesafio.get(position).getDuracao());

        itemFitaHolder.simboloDoItem.setText(listElementos.get(position).getValorElemento());


    }

    @Override
    public int getItemCount() {
        return listElementos.size();
    }

    public class ItemFitaHolder extends RecyclerView.ViewHolder {

        TextView simboloDoItem;
        CardView meuCard;

        public ItemFitaHolder(@NonNull View itemView) {
            super(itemView);
            meuCard      = (CardView) itemView.findViewById(R.id.card_viewDesaf);
            simboloDoItem= (TextView) itemView.findViewById(R.id.txtItem);

        }
    }
}