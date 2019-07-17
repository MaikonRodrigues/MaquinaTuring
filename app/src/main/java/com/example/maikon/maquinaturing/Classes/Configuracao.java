package com.example.maikon.maquinaturing.Classes;

/*
 *      Classe para instanciar objetos que conterá as configurações da entrada
 */

import java.io.Serializable;

public class Configuracao implements Serializable {
    String estado_atual, ler, escreve, vaiPara, dirOuEsq;

    public Configuracao(String estado_atual, String ler, String escreve, String vaiPara, String dirOuEsq) {
        this.estado_atual = estado_atual;
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

    public String getestado_atual() {
        return estado_atual;
    }

    public void setestado_atual(String estado_atual) {
        this.estado_atual = estado_atual;
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
