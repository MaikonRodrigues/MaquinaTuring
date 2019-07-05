package com.example.maikon.maquinaturing.Classes;

/*
 *      Classe para instanciar objetos que conterá as configurações da entrada
 */

public class Configuracao {
    String simbolo, ler, escreve, vaiPara, dirOuEsq;

    public Configuracao(String simbolo, String ler, String escreve, String vaiPara, String dirOuEsq) {
        this.simbolo = simbolo;
        this.ler = ler;
        this.escreve = escreve;
        this.vaiPara = vaiPara;
        this.dirOuEsq = dirOuEsq;
    }

    public Configuracao() {
    }

    public String getDirOuEsq() {
        return dirOuEsq;
    }

    public void setDirOuEsq(String dirOuEsq) {
        this.dirOuEsq = dirOuEsq;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getler() {
        return ler;
    }

    public void setler(String aoLer) {
        this.ler = aoLer;
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
