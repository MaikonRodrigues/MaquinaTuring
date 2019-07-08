package com.example.maikon.maquinaturing;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.maikon.maquinaturing.Adapters.ItemEntradaAdapter;
import com.example.maikon.maquinaturing.Classes.Configuracao;

import java.util.ArrayList;
import java.util.List;

public class CriaMaquina2Activity extends AppCompatActivity {

    RecyclerView recyclerListConf;      List<Configuracao> listElementoCriads;   ItemEntradaAdapter adapter;
    Button btnNovoEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_maquina2);

        recyclerListConf = (RecyclerView) findViewById(R.id.my_recycler_view_conf_entra);     listElementoCriads = new ArrayList<Configuracao>();
        btnNovoEstado = (Button) findViewById(R.id.btnNovoEstado);



        adapter = new ItemEntradaAdapter(listElementoCriads, CriaMaquina2Activity.this);
        recyclerListConf.setAdapter(adapter);

        btnNovoEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // caixaDialog();

                // Create custom dialog object
                final Dialog dialog = new Dialog(CriaMaquina2Activity.this);
                // Include dialog.xml file
                dialog.setContentView(R.layout.item_entrada_valores);
                // Set dialog title
                dialog.setTitle("Custom Dialog");

                dialog.show();
            }

        });

    }

    public AlertDialog caixaDialog(){
        Toast.makeText(CriaMaquina2Activity.this, "Estou na funçao", Toast.LENGTH_SHORT).show();

        AlertDialog.Builder builder = new AlertDialog.Builder(CriaMaquina2Activity.this);
        LayoutInflater inflater = CriaMaquina2Activity.this.getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.item_entrada_valores, null))
                .setPositiveButton("Qualquer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                .setNegativeButton("Cansela", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //CriaMaquina2Activity.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
/*
    -----------------------------------------------------------------------------------------------------
            AlertDialog alertDialog = new AlertDialog.Builder(CriaMaquina2Activity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Alert message to be shown");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
            alertDialog.show();
    -----------------------------------------------------------------------------------------------------

        AlertDialog alertDialog = new AlertDialog.Builder(AlertDialogActivity.this).create();
        alertDialog.setTitle("Alert Dialog");
        alertDialog.setMessage("Welcome to dear user.");
        alertDialog.setIcon(R.drawable.welcome);

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();
    ------------------------------------------------------------------------------------------------------
        */
}
