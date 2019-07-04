package com.example.maikon.maquinaturing.Classes;

public class Estado {
    String nome, entrada;

    public Estado(String nome, String entrada) {
        this.nome = nome;
        this.entrada = entrada;

        int i;
        for (i = 0; i < entrada.length(); i++){
            Configuracao configuracao = new Configuracao();
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
}
