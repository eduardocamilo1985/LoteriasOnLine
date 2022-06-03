package Estrutura;


import java.text.NumberFormat;

import static Estrutura.Parametros.valorApostaSimplesMega;

public class Util {

    public int[] numeroAleatorio(int numDezenas) {
        int[] numRand = new int[numDezenas];

        for (int i = 0; i < numRand.length; i++) {
            int sorteado;
            boolean repetido = false;
            do {
                sorteado = (int) (Math.random()*60)+1; //nro aleatorio de 1 a 60
                repetido = existeNumero(numRand, sorteado);
            } while(repetido); // evita repetição de número

            numRand[i] = sorteado;
        }
        return numRand;
    }
    public static boolean existeNumero(int[] numeros, int n) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == n) {
                return true;
            }
        }
        return false;
    }
    public void converterEmDouble(String valor){
        String valApoSim=valorApostaSimplesMega.substring(3,7);
        double valorSimples = Double.parseDouble(valor.replace(",","."));

    }
    public String calculaTotalSimples(int qtd){
        String valApoSimp=valorApostaSimplesMega.substring(3,7);
        double valor = Double.parseDouble(valApoSimp.replace(",","."));
        double totalsimples= valor*qtd;
        NumberFormat formatar = NumberFormat.getCurrencyInstance();
        return formatar.format(totalsimples).replace("\u00a0","");
   }

}


