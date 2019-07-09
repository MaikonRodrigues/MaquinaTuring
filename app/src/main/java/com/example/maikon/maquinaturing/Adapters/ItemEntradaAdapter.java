package com.example.maikon.maquinaturing.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.maikon.maquinaturing.Classes.Configuracao;
import com.example.maikon.maquinaturing.R;

import java.util.List;

import static com.example.maikon.maquinaturing.R.layout.item_entrada_valores;
import static com.example.maikon.maquinaturing.R.layout.item_fita;


public class ItemEntradaAdapter extends RecyclerView.Adapter<ItemEntradaAdapter.ItemFitaHolder> {

    List<Configuracao> listConfiguracao;
    Context context;
    String id;

    public ItemEntradaAdapter(List<Configuracao> listConfiguracao, Context context){
        this.listConfiguracao = listConfiguracao;
        this.context = context;
    }


    @NonNull
    @Override
    public ItemFitaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista =  LayoutInflater.from(parent.getContext()).inflate(item_entrada_valores, parent, false);
        return new ItemEntradaAdapter.ItemFitaHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemFitaHolder itemFitaHolder, final int position) {

       // id = listDesafio.get(position).getId();
      //  bebHolder.campoNome.setText(listDesafio.get(position).getNome());
      //  bebHolder.campoDuracao.setText(listDesafio.get(position).getDuracao());

        //itemFitaHolder.simboloDoItem.setText(String.valueOf(listConfiguracao.get(position).getValorElemento()));


    }

    @Override
    public int getItemCount() {
        return listConfiguracao.size();
    }

    public class ItemFitaHolder extends RecyclerView.ViewHolder {





        public ItemFitaHolder(@NonNull View itemView) {
            super(itemView);



        }
    }
}