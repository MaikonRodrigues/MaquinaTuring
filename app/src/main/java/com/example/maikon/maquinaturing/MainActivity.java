package com.example.maikon.maquinaturing;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maikon.maquinaturing.Adapters.ItemFitaAdapter;
import com.example.maikon.maquinaturing.Classes.ElementoFita;
import com.example.maikon.maquinaturing.Classes.Mt;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txt, labeltxt;
    Button btnRodar, btnPP;
    EditText entrada;
    int i, flag;
    char[] entradasArray = null;
    Mt maquina;
    CardView cabecote; RelativeLayout cabecoteLayout;
    RecyclerView recyclerListElement;
    ElementoFita elementoFita;
    List<ElementoFita> listElementoFita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flag = 0;
        cabecote = (CardView) findViewById(R.id.card_viewCabFita);
        cabecoteLayout = (RelativeLayout)findViewById(R.id.layout_cabecote);
        recyclerListElement = (RecyclerView) findViewById(R.id.my_recycler_view_listEnd);
        //recyclerDesafios.setHasFixedSize(true);
        recyclerListElement.setLayoutManager(new LinearLayoutManager(MainActivity.this ,LinearLayoutManager.HORIZONTAL, false));

        listElementoFita = new ArrayList<ElementoFita>();

        maquina = new Mt();

        txt = (TextView) findViewById(R.id.txtTela);
        labeltxt = (TextView) findViewById(R.id.labeltxt);
        btnRodar = (Button) findViewById(R.id.btn);
        entrada = (EditText) findViewById(R.id.editEntrada);
        btnPP = (Button) findViewById(R.id.btnPP);
        btnPP.setVisibility(View.INVISIBLE);
        btnRodar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnPP.setVisibility(View.VISIBLE);
                btnRodar.setVisibility(View.INVISIBLE);
                entrada.setVisibility(View.INVISIBLE);
                labeltxt.setVisibility(View.INVISIBLE);
                maquina.setFita(entrada.getText().toString());

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

                // laco para add os itens da entrada
                //
                for (i = 0; i < (entrada.getText().toString().length()); i++){
                    elementoFita = new ElementoFita();
                    elementoFita.setValorElemento(entradasArray[i]);
                    elementoFita.setPosicao(1);
                    listElementoFita.add(elementoFita);
                    flag = i;
                }

                ItemFitaAdapter adapter = new ItemFitaAdapter(listElementoFita, MainActivity.this);
                recyclerListElement.setAdapter(adapter);

            }
        });

        btnPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "flag = "+flag+" entrada n = "+entrada.length(), Toast.LENGTH_SHORT).show();
                cabecoteLayout.setHorizontalGravity(Gravity.getAbsoluteGravity(1, Gravity.RIGHT));
                maquina.rodar();
                txt.setText("Estado Atual: "+(maquina.estadoAtual)+"\n Número de Passos: "+ maquina.getPassos());

                if (maquina.estadoAtual.equals("Aceita") && flag < entrada.length()){
                   flag++;
                }
                else if(flag == entrada.length()){
                    btnPP.setVisibility(View.INVISIBLE);
                    btnRodar.setVisibility(View.VISIBLE);
                    entrada.setVisibility(View.VISIBLE);
                    labeltxt.setVisibility(View.VISIBLE);
                }
            }
        });


    }




}
