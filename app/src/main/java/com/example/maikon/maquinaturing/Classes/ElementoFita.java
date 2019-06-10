package com.example.maikon.maquinaturing.Classes;

public class ElementoFita {

    String valorElemento;
    int posicao;

    public ElementoFita(String valorElemento, int posicao) {
        this.valorElemento = valorElemento;
        this.posicao = posicao;
    }

    public String getValorElemento() {
        return valorElemento;
    }

    public void setValorElemento(String valorElemento) {
        this.valorElemento = valorElemento;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }
}
