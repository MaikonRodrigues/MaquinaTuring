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

public class TelaInicial extends AppCompatActivity {

    EditText entradaSigma, entradaAlfabFita, entradaConjEsta;
    Button btnProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        entradaAlfabFita = (EditText)findViewById(R.id.entAlfFita);     btnProximo = (Button)findViewById(R.id.btnProximo);
        entradaSigma = (EditText)findViewById(R.id.entradaSigma);       entradaConjEsta = (EditText)findViewById(R.id.entradaQ);


    }

}
