package br.iesb.cco.apidemo.service;

import br.iesb.cco.apidemo.model.CertiEntity;
import br.iesb.cco.apidemo.model.ExtensoEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CertiService {

    private CertiEntity extenso;
    public CertiEntity calcula(int number){

        List<CertiEntity> numbers = new ArrayList<>();

        int numero = extenso.getNumero();
        boolean negativo = false;
        if (numero < 0){
            negativo = true;
            numero = numero * -1;
        }else if(numero > 0){
            negativo = false;
        }else{
            //numero é 0
        }

        int dezenaMilhar;
        dezenaMilhar = numero / 10000;
        numero = numero - (dezenaMilhar * 10000);

        int unidadeMilhar;
        unidadeMilhar = numero / 1000;
        numero = numero - (unidadeMilhar * 1000);

        int centenas;
        centenas = numero / 100;
        numero = numero - (centenas * 100);

        int dezenas;
        dezenas = numero / 10;
        numero = numero - (dezenas * 10);

        int unidades;
        unidades = numero;

        CertiEntity entity = new CertiEntity();
        entity.setNegativo(negativo);
        entity.setDezenaMilhar(dezenaMilhar);
        entity.setUnidadeMilhar(unidadeMilhar);
        entity.setCentena(centenas);
        entity.setDezena(dezenas);
        entity.setUnidade(unidades);

        numbers.add(entity);


        return (CertiEntity) numbers;
    }


    public String escreve(CertiEntity resultadoCalculo){

        ExtensoEntity palavra = new ExtensoEntity();
        //21000  15000 10000 09000 99999 11100 11011 11001
        String texto="";
        int dezenaMilhar = resultadoCalculo.getDezenaMilhar();
        int unidadeMilhar = resultadoCalculo.getUnidadeMilhar();
        int centena = resultadoCalculo.getCentena();
        int dezena = resultadoCalculo.getDezena();
        int unidade = resultadoCalculo.getUnidade();
        boolean negativo = resultadoCalculo.isNegativo();

        if(negativo){
            texto = palavra.getEspecial()[0];//menos;
        }

        //Checando dezenas de milhar
        if(dezenaMilhar != 0){
            if(dezenaMilhar==1){
                switch (unidadeMilhar){
                    case 0:
                        texto+= palavra.getDezenas()[0]; //dez
                        break;
                    case 1:
                        texto+= palavra.getEspecial()[2]; //onze
                        break;
                    case 2:
                        texto+= palavra.getEspecial()[3]; //doze
                        break;
                    case 3:
                        texto+= palavra.getEspecial()[4]; //treze
                        break;
                    case 4:
                        texto+= palavra.getEspecial()[5]; //quatorze
                        break;
                    case 5:
                        texto+= palavra.getEspecial()[6]; //quinze
                        break;
                    case 6:
                        texto+= palavra.getEspecial()[7]; //dezesseis
                        break;
                    case 7:
                        texto+= palavra.getEspecial()[8]; //dezessete
                        break;
                    case 8:
                        texto+= palavra.getEspecial()[9]; //dezoito
                        break;
                    case 9:
                        texto+= palavra.getEspecial()[10]; //dezenove
                        break;
                }
            }
            else if(dezenaMilhar>1){

                switch (dezenaMilhar){
                    case 2:
                        texto+= palavra.getDezenas()[1]; //vinte
                        break;
                    case 3:
                        texto+= palavra.getDezenas()[2]; //trinta
                        break;
                    case 4:
                        texto+= palavra.getDezenas()[3]; //quarenta
                        break;
                    case 5:
                        texto+= palavra.getDezenas()[4]; //cinquenta
                        break;
                    case 6:
                        texto+= palavra.getDezenas()[5]; //sessenta
                        break;
                    case 7:
                        texto+= palavra.getDezenas()[6]; //setenta
                        break;
                    case 8:
                        texto+= palavra.getDezenas()[7]; //oitenta
                        break;
                    case 9:
                        texto+= palavra.getDezenas()[8]; //noventa
                        break;
                }
            }
            if(unidadeMilhar==0 || dezenaMilhar==1){
                texto+=palavra.getEspecial()[1]; //colocar mil no texto
            }
            if(unidadeMilhar!=0){
                texto+=" e "; //colocar "e"
            }
        }

        if(unidadeMilhar!=0 && dezenaMilhar!=1) {
            switch(unidadeMilhar){
                case 1:
                    texto+= palavra.getUnidades()[1]; //um
                    break;
                case 2:
                    texto+= palavra.getUnidades()[2]; //dois
                    break;
                case 3:
                    texto+= palavra.getUnidades()[3]; //três
                    break;
                case 4:
                    texto+= palavra.getUnidades()[4]; //quatro
                    break;
                case 5:
                    texto+= palavra.getUnidades()[5]; //cinco
                    break;
                case 6:
                    texto+= palavra.getUnidades()[6]; //seis
                    break;
                case 7:
                    texto+= palavra.getUnidades()[7]; //sete
                    break;
                case 8:
                    texto+= palavra.getUnidades()[8]; //oito
                    break;
                case 9:
                    texto+= palavra.getUnidades()[9]; //nove
                    break;
            }
            texto+= " mil ";//escrever mil

            if (centena!=0){
                texto+=" e ";//escrever "e"
            }

        }

        if(centena!=0){
            if(centena==1 && dezena==0 && unidade==0){
                texto+=palavra.getCentenas()[0];//cem
            }
            else{
                switch (centena){
                    case 1:
                        texto+=palavra.getCentenas()[1];//cento
                        break;
                    case 2:
                        texto+=palavra.getCentenas()[2];//duzentos
                        break;
                    case 3:
                        texto+=palavra.getCentenas()[3];//trezentos
                        break;
                    case 4:
                        texto+=palavra.getCentenas()[4];//quatrocentos
                        break;
                    case 5:
                        texto+=palavra.getCentenas()[5];//quinhentos
                        break;
                    case 6:
                        texto+=palavra.getCentenas()[6];//seiscentos
                        break;
                    case 7:
                        texto+=palavra.getCentenas()[7];//setecentos
                        break;
                    case 8:
                        texto+=palavra.getCentenas()[8];//oitocentos
                        break;
                    case 9:
                        texto+=palavra.getCentenas()[0];//novecentos
                        break;
                }
                if(dezena!=0){
                    texto+=" e ";
                }
            }
        }

        if(dezena != 0){
            if(dezena==1){
                switch (unidade){
                    case 0:
                        texto+=palavra.getDezenas()[0];//dez
                        break;
                    case 1:
                        texto+=palavra.getEspecial()[2];//onze
                        break;
                    case 2:
                        texto+=palavra.getEspecial()[3];//doze
                        break;
                    case 3:
                        texto+=palavra.getEspecial()[4];//treze
                        break;
                    case 4:
                        texto+=palavra.getEspecial()[5];//quatorze
                        break;
                    case 5:
                        texto+=palavra.getEspecial()[6];//quinze
                        break;
                    case 6:
                        texto+=palavra.getEspecial()[7];//dezesseis
                        break;
                    case 7:
                        texto+=palavra.getEspecial()[8];//dezessete
                        break;
                    case 8:
                        texto+=palavra.getEspecial()[9];//dezoito
                        break;
                    case 9:
                        texto+=palavra.getEspecial()[10];//dezenove
                        break;
                }
            }
            else{

                switch (dezena){
                    case 2:
                        texto+=palavra.getDezenas()[1];//vinte
                        break;
                    case 3:
                        texto+=palavra.getDezenas()[2];//trinta
                        break;
                    case 4:
                        texto+=palavra.getDezenas()[3];//quarenta
                        break;
                    case 5:
                        texto+=palavra.getDezenas()[4];//cinquenta
                        break;
                    case 6:
                        texto+=palavra.getDezenas()[5];//sessenta
                        break;
                    case 7:
                        texto+=palavra.getDezenas()[6];//setenta
                        break;
                    case 8:
                        texto+=palavra.getDezenas()[7];//oitenta
                        break;
                    case 9:
                        texto+=palavra.getDezenas()[8];//noventa
                        break;
                }
                if (unidade!=0){
                    texto+=" e ";//escreve "e"
                }
            }
        }

        if(unidade!=0 && dezena!=1){
            switch (unidade){
                case 1:
                    texto+=palavra.getUnidades()[1];//um
                    break;
                case 2:
                    texto+=palavra.getUnidades()[2];//dois
                    break;
                case 3:
                    texto+=palavra.getUnidades()[3];//três
                    break;
                case 4:
                    texto+=palavra.getUnidades()[4];//quatro
                    break;
                case 5:
                    texto+=palavra.getUnidades()[5];//cinco
                    break;
                case 6:
                    texto+=palavra.getUnidades()[6];//seis
                    break;
                case 7:
                    texto+=palavra.getUnidades()[7];//sete
                    break;
                case 8:
                    texto+=palavra.getUnidades()[8];//oito
                    break;
                case 9:
                    texto+=palavra.getUnidades()[9];//nove
                    break;
            }
        }

        return texto;
    }
}
