package com.example.maikon.maquinaturing.Classes;

public class TipoResultado {

    private int resultado; // 0 = processando, 1 = aceito, 2 = rejeitado
    private int passos;
    private String estado;

    public TipoResultado() {
        resultado = 0;
        passos = 0;
        estado = "";
    }

    public TipoResultado (int result, int passos, String estado) {
        resultado = result;
        this.passos = passos;
        this.estado = estado;
    }

    public void setResultado(int r) {
        resultado = r;
    }

    public void setPassos(int p) {
        passos = p;
    }

    public void setEstado(String e) {
        estado = e;
    }

    public int getResultado() {
        return resultado;
    }

    public int getPassos() {
        return passos;
    }

    public String getEstado() {
        return estado;
    }

}
