package com.example.maikon.maquinaturing.Adapters;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maikon.maquinaturing.Classes.ElementoFita;
import com.example.maikon.maquinaturing.R;

import java.util.List;

import static com.example.maikon.maquinaturing.R.layout.com_facebook_login_fragment;
import static com.example.maikon.maquinaturing.R.layout.item_fita;
import static com.example.maikon.maquinaturing.R.layout.item_kbc_fita;


public class ItemKbcAdapter extends RecyclerView.Adapter<ItemKbcAdapter.ItemFitaHolder> {

    List<ElementoFita> listElementos;
    Context context;


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

        if (listElementos.get(position).isVisivel() == false){
            limpaItem(itemFitaHolder);
        }else  if (listElementos.get(position).isVisivel() == true) {
            itemFitaHolder.simboloDoItem.setText(listElementos.get(position).getValorCabeca());
        }

        itemFitaHolder.card_viewCabFita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "CardView N: "+ position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listElementos.size();
    }


    @SuppressLint("ResourceAsColor")
    public void limpaItem(@NonNull final ItemFitaHolder itemFitaHolder){
        itemFitaHolder.simboloDoItem.setText("");
        itemFitaHolder.simboloDoItem.setTextColor(R.color.azul2);
        itemFitaHolder.seta.setVisibility(View.INVISIBLE);
        itemFitaHolder.simboloDoItem.setPadding(30,0,30,0);
    }

    public void InserirItem(@NonNull final ItemFitaHolder itemFitaHolder, String valor){
        itemFitaHolder.simboloDoItem.setText(valor);
        itemFitaHolder.seta.setVisibility(View.VISIBLE);
    }

    public class ItemFitaHolder extends RecyclerView.ViewHolder {

        TextView simboloDoItem;         ImageView seta;
        CardView card_viewCabFita;

        public ItemFitaHolder(@NonNull View itemView) {
            super(itemView);

            simboloDoItem= (TextView) itemView.findViewById(R.id.txtItemKbc);
            card_viewCabFita = (CardView) itemView.findViewById(R.id.card_viewCabFita);
            seta = (ImageView) itemView.findViewById(R.id.seta);

        }

    }


}