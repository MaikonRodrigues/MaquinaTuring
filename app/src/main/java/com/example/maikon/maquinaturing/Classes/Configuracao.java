package com.example.maikon.maquinaturing.Classes;

public class Configuracao {
    String aoLer, escreve, vaiPara;

    public Configuracao(String aoLer, String escreve, String vaiPara) {
        this.aoLer = aoLer;
        this.escreve = escreve;
        this.vaiPara = vaiPara;
    }

    public Configuracao() {
    }

    public String getAoLer() {
        return aoLer;
    }

    public void setAoLer(String aoLer) {
        this.aoLer = aoLer;
    }

    public String getEscreve() {
        return escreve;
    }

    public void setEscreve(String escreve) {
        this.escreve = escreve;
    }

    public String getVaiPara() {
        return vaiPara;
    }

    public void setVaiPara(String vaiPara) {
        this.vaiPara = vaiPara;
    }
}
