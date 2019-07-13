package com.example.maikon.maquinaturing;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maikon.maquinaturing.Adapters.ItemEntradaAdapter;
import com.example.maikon.maquinaturing.Classes.Configuracao;

import java.util.ArrayList;
import java.util.List;

public class ConfiguraEstadosActivity extends AppCompatActivity {

    RecyclerView recyclerListConf;                                   List<Configuracao> listElementoCriads;
    Button btnNovoEstado, btnConfigurarEstado, cancelarConf;         TextView ler, escreve, vaiPara;
    CheckBox checkEsq, checkdir;                                     ItemEntradaAdapter adapter;
    int flagEsq, flagDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configura_estados);

        recyclerListConf = (RecyclerView) findViewById(R.id.my_recycler_view_conf_entra);     listElementoCriads = new ArrayList<Configuracao>();
        btnNovoEstado    = (Button) findViewById(R.id.btnNovoEstado);                         ler                = (TextView) findViewById(R.id.txtLer);
        escreve          = (TextView) findViewById(R.id.txtEscreve);                          checkEsq           = (CheckBox) findViewById(R.id.checkBoxEsq);
        vaiPara          = (TextView) findViewById(R.id.txtVaiPara);                          checkdir           = (CheckBox) findViewById(R.id.checkBoxDireita);
        flagDir          = 0;                                                                 flagEsq            = 0;

        // Pegando informações da activity que iniciou as configurações
        //Pega a intent de outra activity
        Intent it = getIntent();
        //Recuperei a string da outra activity
        String maquina = it.getStringExtra("Maquina");
        // Se for uma maquina pre configurada
        if (maquina.equals("1")){
            Toast.makeText(ConfiguraEstadosActivity.this, "configurada maquina: "+maquina, Toast.LENGTH_SHORT).show();
        }else{
            String sigma = it.getStringExtra("Sigma");
            String alfabeto = it.getStringExtra("Alfabeto");
        }


        adapter = new ItemEntradaAdapter(listElementoCriads, ConfiguraEstadosActivity.this);
        recyclerListConf.setAdapter(adapter);

        btnNovoEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create custom dialog object
                final Dialog dialog = new Dialog(ConfiguraEstadosActivity.this);
                // Include dialog.xml file
                dialog.setContentView(R.layout.item_entrada_valores);
                dialog.findViewById(R.id.btnConfigurar).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                dialog.findViewById(R.id.btnCancelar).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();

                dialog.findViewById(R.id.checkBoxEsq).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (flagEsq == 1){
                            dialog.findViewById(R.id.checkBoxDireita).setEnabled(true);
                            flagEsq = 0;
                        }else if (flagEsq == 0){
                            dialog.findViewById(R.id.checkBoxDireita).setEnabled(false);
                            flagEsq = 1;
                        }

                    }
                });

                dialog.findViewById(R.id.checkBoxDireita).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (flagDir == 1){
                            dialog.findViewById(R.id.checkBoxEsq).setEnabled(true);
                            flagDir = 0;
                        }else if (flagDir == 0){
                            dialog.findViewById(R.id.checkBoxEsq).setEnabled(false);
                            flagDir = 1;
                        }
                    }
                });

            }

        });

    }
}
