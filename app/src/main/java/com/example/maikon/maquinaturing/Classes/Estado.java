package com.example.maikon.maquinaturing.Classes;

import java.util.ArrayList;
import java.util.List;

public class Estado {
    int numeroEstados;
    char[] alfabeto;
    char elemento;
    List<Configuracao> configuracoes;

    public Estado(int numeroEstados, char[] alfabeto) {
        this.numeroEstados = numeroEstados;
        this.alfabeto = alfabeto;
        this.configuracoes = new ArrayList<>();
            // Primeiro for garante que sera criada uma configuracao para cada elemento
            // do alfabeto em cada um dos estados
        for (int j = 0; j < numeroEstados; j++) {
            // Recebe a quantidade de estados e cria as configuracoes de acordo com os elementos do alfabeto
            for (int i = 0; i < alfabeto.length; i++) {
                elemento = alfabeto[i];
                //  Cria uma configuracao para cada simbolo do alfabeto
                Configuracao configuracao = new Configuracao();
                configuracao.setestado_atual("q"+j);
                configuracao.setler(String.valueOf(elemento));
                configuracoes.add(configuracao);
            }
        }
    }

    public List<Configuracao> getConfiguracoes() {
        return configuracoes;
    }

    public void setConfiguracoes(List<Configuracao> configuracoes) {
        this.configuracoes = configuracoes;
    }

    public int getNumeroEstados() {
        return numeroEstados;
    }

    public void setNumeroEstados(int numeroEstados) {
        this.numeroEstados = numeroEstados;
    }

    public char[] getAlfabeto() {
        return alfabeto;
    }

    public void setAlfabeto(char[] alfabeto) {
        this.alfabeto = alfabeto;
    }

    public char getElemento() {
        return elemento;
    }

    public void setElemento(char elemento) {
        this.elemento = elemento;
    }
}
