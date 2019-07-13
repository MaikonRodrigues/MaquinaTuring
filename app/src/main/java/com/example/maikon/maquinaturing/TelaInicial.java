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

import java.util.ArrayList;
import java.util.List;

public class TelaInicial extends AppCompatActivity {

    EditText entradaSigma, entradaAlfabFita, entradaConjEsta;
    Button btnProximo;
    String getEntradaSigma,getEstados, getAlfabFita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        entradaAlfabFita = (EditText)findViewById(R.id.entAlfFita);     btnProximo = (Button)findViewById(R.id.btnProximo);
        entradaSigma = (EditText)findViewById(R.id.entradaSigma);       entradaConjEsta = (EditText)findViewById(R.id.entradaQ);

    }
    public void tratamentoDeErros(View view){

            // tratamento de entradas vazias
        if (entradaAlfabFita.getText().toString().equals("") || entradaConjEsta.getText().toString().equals("")
                || entradaSigma.getText().toString().equals("")){
            Toast.makeText(TelaInicial.this,"Todos os campos são obrigatorios", Toast.LENGTH_SHORT).show();
            return;
        }else {
                // Pegando valores de entrada
            getEntradaSigma = entradaSigma.getText().toString();    getEstados = entradaConjEsta.getText().toString();
            getAlfabFita = entradaAlfabFita.getText().toString();
                // Verifica se a entrada e valida
            if (verificarEntradaCorreta() == false) return;
                // quebrando entrada em um vetor
            char[] sigma, alfabeto ;
            sigma = retiraVirgulas(entradaSigma.getText().toString().toCharArray());
            alfabeto = retiraVirgulas(entradaAlfabFita.getText().toString().toCharArray());



        }

    }

    /*
     *      A ideia dessa funcao e verificar se o usuario nao digitou uma entrada invalida
     *      por exemplo dois caracteres seguidos sem virgula ou caracteres que nao pertecem
     *      ao alfabeto
     */
    public boolean verificarEntradaCorreta(){
        boolean flag = false;
        // Salva as entradas em vetor de caracteres
        char[] sigma = new char[entradaSigma.length()], alfFita = new char[entradaSigma.length()];
        // Quebrando a String em caracteres
        sigma = retiraVirgulas(entradaSigma.getText().toString().toCharArray());
        alfFita = retiraVirgulas(entradaAlfabFita.getText().toString().toCharArray());
        // Verificando se os simbolos da entrada fazem parte do alfabeto inserido
        for (int i = 0; i < sigma.length; i++){
            if (sigma[i] == alfFita[i]){
                flag = true;
            }else{
                flag = false;
            }
        }
        if (flag == false){
            Toast.makeText(TelaInicial.this, "Sua entrada não faz parte do alfabeto", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /*
     *      Funcao recebe um vetor de caracteres e retira as virgulas
     */
    public char[] retiraVirgulas(char[] entrada){
        char[] letrasSemVirgula = new char[entrada.length];
        for (int i = 0; i <  entradaSigma.length(); i++){
            if (entrada[i] == ','){
                // nao faz nada
            }else{
                // salva vetor sem as virgulas
                letrasSemVirgula[i] = entrada[i];
                Toast.makeText(TelaInicial.this,"For posição "+entrada[i], Toast.LENGTH_SHORT).show();
            }

        }
        return letrasSemVirgula;
    }


}
