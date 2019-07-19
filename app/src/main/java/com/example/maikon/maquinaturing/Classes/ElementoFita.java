package com.example.maikon.maquinaturing.Classes;

public class ElementoFita {

    String valorCabeca;
    char valorElemento;
    int posicao;
    boolean visivel;

    public ElementoFita() {
    }

    public ElementoFita(char valorElemento, int posicao, boolean visivel, String valorCabeca) {
        this.valorElemento = valorElemento;
        this.posicao = posicao;
        this.visivel = visivel;
        this.valorCabeca = valorCabeca;
    }

    public String getValorCabeca() {
        return valorCabeca;
    }

    public void setValorCabeca(String valorCabeca) {
        this.valorCabeca = valorCabeca;
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
