package com.example.maikon.maquinaturing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.maikon.maquinaturing.Adapters.ItemEntradaAdapter;
import com.example.maikon.maquinaturing.Classes.Configuracao;
import com.example.maikon.maquinaturing.Classes.ElementoFita;

import java.util.ArrayList;
import java.util.List;

public class CriaMaquina2Activity extends AppCompatActivity {

    RecyclerView recyclerListConf;      List<Configuracao> listElementoCriads;   ItemEntradaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_maquina2);

        recyclerListConf = (RecyclerView) findViewById(R.id.my_recycler_view_conf_entra);     listElementoCriads = new ArrayList<Configuracao>();


        adapter = new ItemEntradaAdapter(listElementoCriads, CriaMaquina2Activity.this);
        recyclerListConf.setAdapter(adapter);

    }
}
