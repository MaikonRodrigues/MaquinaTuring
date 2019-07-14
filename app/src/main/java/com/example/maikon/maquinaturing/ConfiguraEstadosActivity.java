package com.example.maikon.maquinaturing;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maikon.maquinaturing.Adapters.ItemEntradaAdapter;
import com.example.maikon.maquinaturing.Classes.Configuracao;
import com.example.maikon.maquinaturing.Classes.Estado;
import com.example.maikon.maquinaturing.Classes.Mt;

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

        recyclerListConf = (RecyclerView) findViewById(R.id.recycler_conf_entra);            listElementoCriads = new ArrayList<Configuracao>();
        btnNovoEstado    = (Button) findViewById(R.id.btnNovoEstado);                         ler                = (TextView) findViewById(R.id.txtLer);
        escreve          = (TextView) findViewById(R.id.txtEscreve);                          checkEsq           = (CheckBox) findViewById(R.id.checkBoxEsq);
        vaiPara          = (TextView) findViewById(R.id.txtVaiPara);                          checkdir           = (CheckBox) findViewById(R.id.checkBoxDireita);
        flagDir          = 0;                                                                 flagEsq            = 0;

        recyclerListConf.setLayoutManager(new LinearLayoutManager(ConfiguraEstadosActivity.this ,LinearLayoutManager.VERTICAL, false));
        // Pegando informações da activity que iniciou as configurações
        //Pega a intent de outra activity
        Intent it = getIntent();
        //Recuperei a string da outra activity
        String maquina = it.getStringExtra("Maquina");
        // Se for uma maquina pre configurada
        if (maquina.equals("1")){
            configurarMaquina("1");
        }else{
            String sigma = it.getStringExtra("Sigma");
            String alfabeto = it.getStringExtra("Alfabeto");
        }


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

    /*
     *  Metodo configura altomaticamente a maquina do tipo 1 (reconhece uma sequencia de 0s seguido de 1
     */
    private void configurarMaquina(String s) {


        if (s == "1"){

            char[] alfabeto = {'0','1'};
            List<Configuracao> configuracoes;
            Estado estado = new Estado(2, alfabeto);
            configuracoes = estado.getConfiguracoes();


            Configuracao conf_q0_0 = configuracoes.get(0);      Configuracao conf_q1_0 = configuracoes.get(2);
            Configuracao conf_q0_1 = configuracoes.get(1);      Configuracao conf_q1_1 = configuracoes.get(3);

            conf_q0_0.setestado_atual("q0");        conf_q0_1.setestado_atual("q0");
            conf_q0_0.setVaiPara("q1");             conf_q0_1.setVaiPara("rejeita");
            conf_q0_0.setDirOuEsq(">");             conf_q0_1.setDirOuEsq(">");
            conf_q0_0.setEscreve("0");              conf_q0_1.setEscreve("1");

            conf_q1_0.setestado_atual("q1");        conf_q1_1.setestado_atual("q1");
            conf_q1_0.setVaiPara("q1");             conf_q1_1.setVaiPara("aceita");
            conf_q1_0.setDirOuEsq(">");             conf_q1_1.setDirOuEsq(">");
            conf_q1_0.setEscreve("0");              conf_q1_1.setEscreve("1");

            configuracoes.set(0, conf_q0_0);        configuracoes.set(2, conf_q1_0);
            configuracoes.set(1, conf_q0_1);        configuracoes.set(3, conf_q1_1);

            Toast.makeText(ConfiguraEstadosActivity.this, "tamanho da lista: "+configuracoes.size(), Toast.LENGTH_SHORT).show();

            adapter = new ItemEntradaAdapter(configuracoes, ConfiguraEstadosActivity.this);
            recyclerListConf.setAdapter(adapter);

        }

        //-------------------------------------------------------------------------------------------------------
        String stringDeConfiguracao;
        stringDeConfiguracao = "init: q0" + "\n accept: Aceita" + // Configurando estado aceitacao e rejeicao
                "\n" +

                "\n q0,0"        +         //  estado atual, valor lido
                "\n q1,0,>"      +        //  novo estado,  valor escrito, direcao
                "\n"             +

                "\n q0,1"        +
                "\n Rejeita,1,>" +
                "\n"             +

                "\n q1,0"        +
                "\n q1,0,>"      +
                "\n"             +

                "\n q1,1"   +
                "\n Aceita,1,>";
    }
}
