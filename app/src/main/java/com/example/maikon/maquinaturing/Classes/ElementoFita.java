package com.example.maikon.maquinaturing.Classes;

public class ElementoFita {

    char valorElemento;
    int posicao;

    public ElementoFita() {
    }

    public ElementoFita(char valorElemento, int posicao) {
        this.valorElemento = valorElemento;
        this.posicao = posicao;
    }

    public char getValorElemento() {
        return valorElemento;
    }

    public void setValorElemento(char valorElemento) {
        this.valorElemento = valorElemento;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}
