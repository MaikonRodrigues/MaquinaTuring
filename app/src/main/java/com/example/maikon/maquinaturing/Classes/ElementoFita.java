package com.example.maikon.maquinaturing.Classes;

public class ElementoFita {

    char valorElemento;
    int posicao;
    boolean visivel;

    public ElementoFita() {
    }

    public ElementoFita(char valorElemento, int posicao, boolean visivel) {
        this.valorElemento = valorElemento;
        this.posicao = posicao;
        this.visivel = visivel;
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

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }
}
