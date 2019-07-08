package com.example.maikon.maquinaturing;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maikon.maquinaturing.Adapters.ItemFitaAdapter;
import com.example.maikon.maquinaturing.Adapters.ItemKbcAdapter;
import com.example.maikon.maquinaturing.Classes.ElementoFita;
import com.example.maikon.maquinaturing.Classes.Mt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txt, labeltxt;                             ItemKbcAdapter adapter2, adapterKbc;
    Button btnRodar, btnPP, kkk;                             ItemFitaAdapter adapter, adapterFita;
    EditText entrada;                                   Mt maquina;
    int i, flag;                                        ScrollView scrollView;
    char[] entradasArray = null;                        RecyclerView recyclerListElement, recyclerListKbc;
    ElementoFita elementoFita;                          List<ElementoFita> listElementoFita, listElementoKbcFita;
    View mView;                                         Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flag = 0;   kkk = (Button)findViewById(R.id.kkk);
        recyclerListKbc  = (RecyclerView) findViewById(R.id.my_recycler_view_cab_fita);
        recyclerListElement = (RecyclerView) findViewById(R.id.my_recycler_view_listEnd);
        //recyclerDesafios.setHasFixedSize(true);
        recyclerListElement.setLayoutManager(new LinearLayoutManager(MainActivity.this ,LinearLayoutManager.HORIZONTAL, false));
        recyclerListKbc.setLayoutManager(new LinearLayoutManager(MainActivity.this ,LinearLayoutManager.HORIZONTAL, false));

        listElementoFita = new ArrayList<ElementoFita>();        maquina = new Mt();
        listElementoKbcFita = new ArrayList<ElementoFita>();

        txt = (TextView) findViewById(R.id.txtTela);             entrada = (EditText) findViewById(R.id.editEntrada);
        labeltxt = (TextView) findViewById(R.id.labeltxt);       btnPP = (Button) findViewById(R.id.btnPP);
        btnRodar = (Button) findViewById(R.id.btn);              btnPP.setVisibility(View.INVISIBLE);

        // configurando a fita vazia
        fitaConfInicial();
        kkk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, CriaMaquina2Activity.class);
                startActivity(it);
            }
        });

        btnRodar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnPP.setVisibility(View.VISIBLE);          labeltxt.setVisibility(View.INVISIBLE);
                btnRodar.setVisibility(View.INVISIBLE);     maquina.setFita(entrada.getText().toString());
                entrada.setVisibility(View.INVISIBLE);

                maquina.compilar("init: q0" + "\n accept: Aceita" + // Configurando estado aceitacao e rejeicao
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
                        "\n Aceita,1,>" );


                String strings = entrada.getText().toString();
                entradasArray = strings.toCharArray();

                // laco para add os itens da entrada na lista de itens da fita
                for (i = 0; i < (entrada.getText().toString().length()); i++){
                    elementoFita = new ElementoFita();
                    elementoFita.setValorElemento(entradasArray[i]);
                    elementoFita.setPosicao(i);
                    if (i > 0) elementoFita.setVisivel(false); else elementoFita.setVisivel(true);
                    listElementoFita.add(elementoFita);
                    listElementoKbcFita.add(elementoFita);
                    flag = i;
                }


                adapter2 = new ItemKbcAdapter(listElementoKbcFita, MainActivity.this);
                adapter = new ItemFitaAdapter(listElementoFita, MainActivity.this);
                recyclerListElement.setAdapter(adapter);
                recyclerListKbc.setAdapter(adapter2);



            }
        });

        btnPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                maquina.rodar();

                txt.setText("Estado Atual: "+(maquina.estadoAtual)+"\n Número de Passos: "+ maquina.getPassos());

                if (btnPP.getText().equals("reiniciar")){
                    intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }


                if (maquina.estadoAtual.equals("Aceita") && flag < entrada.length()){
                    btnPP.setText("reiniciar");
                   flag++;
                }
                else if(flag == entrada.length()){
                    //  configurando os intens da tela (botoes e labels)
                    btnPP.setVisibility(View.INVISIBLE);                    btnRodar.setVisibility(View.VISIBLE);
                    entrada.setVisibility(View.VISIBLE);                    labeltxt.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    public void moveScroll(int position){
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        // seta a posicao do scrow
        staggeredGridLayoutManager.scrollToPosition(position);
        recyclerListElement.setLayoutManager(staggeredGridLayoutManager);
    }

    public void fitaConfInicial(){
            // Crio dois objeto do tipo ElementoFita
        ElementoFita elementoFitaInic;
        ElementoFita elementoCabInic;
            // Crio duas listas de elementos de Fita
        List<ElementoFita> listElementoFitaInit = new ArrayList<ElementoFita>();
        List<ElementoFita> listElementoCab = new ArrayList<ElementoFita>();
            // Laço para povoar as listas
        int j;
        for (j = 0; j < 10 ; j++){
                // Crio o objeto
            elementoCabInic  = new ElementoFita();
            elementoFitaInic = new ElementoFita();
                // set os valores dos elementos
            elementoFitaInic.setValorElemento(' ');
            elementoFitaInic.setPosicao(j);

            elementoCabInic.setValorElemento('U');
            elementoCabInic.setPosicao(j);

            listElementoFitaInit.add(elementoCabInic);
            listElementoCab.add(elementoFitaInic);

        }
        adapterKbc = new ItemKbcAdapter(listElementoCab, MainActivity.this);
        adapterFita = new ItemFitaAdapter(listElementoFitaInit, MainActivity.this);
        recyclerListElement.setAdapter(adapterFita);
        recyclerListKbc.setAdapter(adapterKbc);

    }




}
