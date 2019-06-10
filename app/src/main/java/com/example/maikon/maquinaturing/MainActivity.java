package com.example.maikon.maquinaturing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.maikon.maquinaturing.Adapters.ItemFitaAdapter;
import com.example.maikon.maquinaturing.Classes.ElementoFita;
import com.example.maikon.maquinaturing.Classes.Mt;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btnRodar, btnPP;
    EditText entrada;

    Mt maquina;

    RecyclerView recyclerDesafios;
    ElementoFita elementoFita;
    List<ElementoFita> listElementoFita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerDesafios = (RecyclerView) findViewById(R.id.my_recycler_view_listEnd);
        recyclerDesafios.setHasFixedSize(true);


        maquina = new Mt();

        txt = (TextView) findViewById(R.id.txtTela);
        btnRodar = (Button) findViewById(R.id.btn);
        entrada = (EditText) findViewById(R.id.editEntrada);
        btnPP = (Button) findViewById(R.id.btnPP);
        btnPP.setVisibility(View.INVISIBLE);
        btnRodar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPP.setVisibility(View.VISIBLE);
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

                elementoFita.setValorElemento("0");
                elementoFita.setPosicao(1);
                listElementoFita.add(elementoFita);

                ItemFitaAdapter adapter = new ItemFitaAdapter(listElementoFita, MainActivity.this);
                recyclerDesafios.setAdapter(adapter);


            }
        });

        btnPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                maquina.rodar();
                txt.setText("Estado Atual: "+(maquina.estadoAtual)+
                     "\n Número de Passos: "+ maquina.getPassos());

                if (maquina.estadoAtual.equals("Aceita")){
                    btnPP.setVisibility(View.INVISIBLE);
                }
            }
        });


    }


}
