package com.example.maikon.maquinaturing.Classes;

public class TipoIntString {

    private int x;
    private char dado;

    public TipoIntString(int x, char dado) {
        this.x = x;
        this.dado = dado;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setDado(char dado) {
        this.dado = dado;
    }

    public char getDado() {
        return dado;
    }
}
