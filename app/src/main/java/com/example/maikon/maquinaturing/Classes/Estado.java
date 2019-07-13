package com.example.maikon.maquinaturing.Classes;

import java.util.ArrayList;
import java.util.List;

public class Estado {
    int numeroEstados;
    char[] alfabeto;
    List<Configuracao> configuracoes;

    public Estado(int numeroEstados, char[] alfabeto) {
        this.numeroEstados = numeroEstados;
        this.alfabeto = alfabeto;
        this.configuracoes = new ArrayList<>();
        // Recebe a quantidade de estados e cria as configuracoes de acordo com os elementos do alfabeto
        for (int i = 0; i < alfabeto.length; i++){
            Configuracao configuracao = new Configuracao();
            configuracao.setestado_atual("q"+i);
            configuracoes.add(configuracao);
        }
    }

    public List<Configuracao> getConfiguracoes() {
        return configuracoes;
    }

    public void setConfiguracoes(List<Configuracao> configuracoes) {
        this.configuracoes = configuracoes;
    }
}
