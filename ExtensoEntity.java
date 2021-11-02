package br.iesb.cco.apidemo.model;

public class ExtensoEntity {
    private String unidades[] = {"zero", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove"};
    private String especial[] = {"menos " ,"mil", "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};
    private String dezenas[] = {"dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};
    private String centenas[] = {"cem", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};

    public String[] getUnidades() {
        return unidades;
    }

    public String[] getEspecial() {
        return especial;
    }

    public String[] getDezenas() {
        return dezenas;
    }

    public String[] getCentenas() {
        return centenas;
    }

}
