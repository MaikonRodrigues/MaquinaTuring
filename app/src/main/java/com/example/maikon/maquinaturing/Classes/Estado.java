package com.example.maikon.maquinaturing.Classes;

import java.util.List;

public class Estado {
    String nome, alfabeto;

                    // lista contem simbolo, ao ler, escreve, vai para, dir ou esq
    public Estado(List<String> vetorEntrada, String alfabeto) {

        this.nome = vetorEntrada.get(1);
        this.alfabeto = alfabeto;

        int i;
        for (i = 0; i < alfabeto.length(); i++){
            Configuracao configuracao = new Configuracao();
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlfabeto() {
        return alfabeto;
    }

    public void setEntrada(String entrada) {
        this.alfabeto = entrada;
    }
}
