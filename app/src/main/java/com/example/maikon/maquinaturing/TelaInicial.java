package com.example.maikon.maquinaturing;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TelaInicial extends AppCompatActivity {

    EditText entradaSigma, entradaAlfabFita, entradaConjEsta;
    Button btnProximo;  char[] letras ;   int i;
    String palavra = "J,ava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        entradaAlfabFita = (EditText)findViewById(R.id.entAlfFita);     btnProximo = (Button)findViewById(R.id.btnProximo);
        entradaSigma = (EditText)findViewById(R.id.entradaSigma);       entradaConjEsta = (EditText)findViewById(R.id.entradaQ);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               letras = retirarVirgula(palavra);
                Toast.makeText(TelaInicial.this,"retorno tamanho :  "+letras.length , Toast.LENGTH_SHORT).show();

                for (i = 0; i == letras.length; i++){
                    Toast.makeText(TelaInicial.this,"voltou "+i+" :" , Toast.LENGTH_SHORT).show();
                        Toast.makeText(TelaInicial.this,"letra na posicao "+i+" :" + letras[i], Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    
    public char[] retirarVirgula(String entrada){
        char[] entradaSemVirgula = new char[entrada.length()], entradaComVirgula;
        int j ;

        entradaComVirgula = entrada.toCharArray();
        Toast.makeText(TelaInicial.this,"entrou "+entradaComVirgula.length+" :" , Toast.LENGTH_SHORT).show();
        for (j = 0; j > 5; j++){
            Toast.makeText(TelaInicial.this,"entrou "+entradaComVirgula.length+" :" , Toast.LENGTH_SHORT).show();
            if (entradaComVirgula[j] == ','){
                // nao faz nada
            }else {
                entradaSemVirgula[j] = entradaComVirgula[j];
            }
        }
        Toast.makeText(TelaInicial.this,"Segundo toast "+entradaSemVirgula.length+" :" , Toast.LENGTH_SHORT).show();
        return entradaSemVirgula;
    }

}
