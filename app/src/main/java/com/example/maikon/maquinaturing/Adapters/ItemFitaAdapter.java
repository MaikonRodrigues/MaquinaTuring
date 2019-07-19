package com.example.maikon.maquinaturing.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.maikon.maquinaturing.Classes.ElementoFita;
import com.example.maikon.maquinaturing.R;
import static com.example.maikon.maquinaturing.R.layout.item_fita;


import java.util.List;


public class ItemFitaAdapter extends RecyclerView.Adapter<ItemFitaAdapter.ItemFitaHolder> {
        // A copia da lista sera usada para comparar as listas e ativar o efeito no item alterado quando necessario
    List<ElementoFita> listElementos, copiaLista;
    Context context;
        // Essa flag verificara qual posicao foi feita a leitura e escrita
    String flag;

    public ItemFitaAdapter(List<ElementoFita> listElementos, Context context, String flag){
        this.listElementos = listElementos;
        this.context = context;
        this.flag = flag;
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
        if (flag.equals("0")){
            itemFitaHolder.simboloDoItem.setText(String.valueOf(listElementos.get(position).getValorElemento()));
        }else {
            if (listElementos.get(position).equals("0")) {
                itemFitaHolder.simboloDoItem.setText(" ");
                itemFitaHolder.simboloDoItem.setText(String.valueOf(listElementos.get(position).getValorElemento()));
                itemFitaHolder.simboloDoItem.startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_in));
            }else
                itemFitaHolder.simboloDoItem.setText(String.valueOf(listElementos.get(position).getValorElemento()));
        }



    }

    @Override
    public int getItemCount() {
        return listElementos.size();
    }

    public void setAnimationTrue( @NonNull final ItemFitaAdapter.ItemFitaHolder itemFitaHolder ) {
        itemFitaHolder.simboloDoItem.startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_in));
    }


    public class ItemFitaHolder extends RecyclerView.ViewHolder {

        TextView simboloDoItem;

        public ItemFitaHolder(@NonNull View itemView) {
            super(itemView);

            simboloDoItem= (TextView) itemView.findViewById(R.id.txtItem);

        }


    }


    public List<ElementoFita> getListElementos() {
        return listElementos;
    }

    public void setListElementos(List<ElementoFita> listElementos) {
        this.listElementos = listElementos;
    }


    private void setAnimationFalse(@NonNull final ItemFitaAdapter.ItemFitaHolder itemFitaHolder ){
        itemFitaHolder.simboloDoItem.clearAnimation();
    }
}