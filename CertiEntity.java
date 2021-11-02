package br.iesb.cco.apidemo.model;

public class CertiEntity {
    private int numero;
    private boolean negativo;
    private int dezenaMilhar;
    private int unidadeMilhar;
    private int centena;
    private int dezena;
    private int unidade;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isNegativo() {
        return negativo;
    }

    public void setNegativo(boolean negativo) {
        this.negativo = negativo;
    }

    public int getDezenaMilhar() {
        return dezenaMilhar;
    }

    public void setDezenaMilhar(int dezenaMilhar) {
        this.dezenaMilhar = dezenaMilhar;
    }

    public int getUnidadeMilhar() {
        return unidadeMilhar;
    }

    public void setUnidadeMilhar(int unidadeMilhar) {
        this.unidadeMilhar = unidadeMilhar;
    }

    public int getCentena() {
        return centena;
    }

    public void setCentena(int centena) {
        this.centena = centena;
    }

    public int getDezena() {
        return dezena;
    }

    public void setDezena(int dezena) {
        this.dezena = dezena;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }
}
