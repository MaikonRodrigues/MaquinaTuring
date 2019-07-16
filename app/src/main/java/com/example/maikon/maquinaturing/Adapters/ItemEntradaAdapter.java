package com.example.maikon.maquinaturing.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.maikon.maquinaturing.Classes.Configuracao;
import com.example.maikon.maquinaturing.R;

import java.util.List;

import static com.example.maikon.maquinaturing.R.layout.item_entrada_lista;
import static com.example.maikon.maquinaturing.R.layout.item_entrada_valores;
import static com.example.maikon.maquinaturing.R.layout.item_fita;


public class ItemEntradaAdapter extends RecyclerView.Adapter<ItemEntradaAdapter.ItemFitaHolder> {

    List<Configuracao> listConfiguracao;
    Context context;
    boolean listar;

    public ItemEntradaAdapter(List<Configuracao> listConfiguracao, Context context, boolean listar){
        this.listConfiguracao = listConfiguracao;
        this.context = context;
        this.listar = listar;
    }


    @NonNull
    @Override
    public ItemFitaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (listar == true){
            View vista = LayoutInflater.from(parent.getContext()).inflate(item_entrada_lista, parent, false);
            return new ItemEntradaAdapter.ItemFitaHolder(vista);
        }else {
            View vista = LayoutInflater.from(parent.getContext()).inflate(item_entrada_valores, parent, false);
            return new ItemEntradaAdapter.ItemFitaHolder(vista);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull final ItemFitaHolder itemFitaHolder, final int position) {


        if (listar == true){
            itemFitaHolder.aoLer.setText(String.valueOf(listConfiguracao.get(position).getler()));
            itemFitaHolder.escreve.setText(String.valueOf(listConfiguracao.get(position).getEscreve()));
            itemFitaHolder.proxEstado.setText(String.valueOf(listConfiguracao.get(position).getVaiPara()));
            itemFitaHolder.labelTopo.setText(" Configurações do estado "+listConfiguracao.get(position).getestado_atual()
                    +" ao ler "+listConfiguracao.get(position).getler());

            if (listConfiguracao.get(position).getDirOuEsq() == ">"){
                itemFitaHolder.checkDir.setChecked(true);
            }else{
                itemFitaHolder.checkEsq.setChecked(true);
            }
        }



    }

    @Override
    public int getItemCount() {
        return listConfiguracao.size();
    }

    public class ItemFitaHolder extends RecyclerView.ViewHolder {
        TextView aoLer, escreve, proxEstado, labelTopo;
        CheckBox checkDir, checkEsq;
        public ItemFitaHolder(@NonNull View itemView) {
            super(itemView);

            aoLer       =   (TextView) itemView.findViewById(R.id.txtLer);      checkEsq = (CheckBox)itemView.findViewById(R.id.checkBoxEsqList);
            escreve     =   (TextView) itemView.findViewById(R.id.txtEscreve);  checkDir = (CheckBox)itemView.findViewById(R.id.checkBoxDireitaList);
            proxEstado  =   (TextView) itemView.findViewById(R.id.txtVaiPara);  labelTopo = (TextView) itemView.findViewById(R.id.labelTopo);

        }
    }
}