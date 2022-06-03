package Funcionalidades;

import Estrutura.Relatorio;
import Estrutura.Util;
import Pages.HomePage;
import Pages.MegaSenaPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

import static Estrutura.Parametros.*;
import static Estrutura.Relatorio.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(Relatorio.class)

public class ApostaMegaSena {
    HomePage home = new HomePage();
    MegaSenaPage mega = new MegaSenaPage();
    Util util = new Util();

    @Test
    @DisplayName("Realizar uma aposta simples")
    //Exemplo de log detalhado no relatório de teste
    public void realizarApostaSimples() throws IOException {
        home.acessarSite();
        test.info("Acessou o site");
        home.btnMaioridade();
        //Arrumar o caminho
        test.addScreenCaptureFromPath("printMaioridade.png");
        home.btnAposteJa();
        test.info("Clicou em Apostar");
        home.btnMegaSena();
        test.info("Escolheu MegaSena");
        mega.btnNumeros(apostaSimplesMega);//escolhe e marca os números
        test.info("Escolheu e marcou os numeros");
        assertEquals(apostaSimplesMega, mega.verificaQtdNumMarcados());
        test.info("O numero de itens marcados está correto");
        assertEquals(valorApostaSimplesMega, mega.valorApostaIndividual());
        test.info("O valor individual da aposta está correto");
        //  assertEquals(apostaSimplesMega, mega.txtQtdNumAposta());
        mega.btnColocarNoCarrinho();
        test.info("Inseriu no Carrinho");
        assertEquals(valorApostaSimplesMega.replace(" ", ""), mega.valorTotalaposta());
        test.info("O valor total da aposta está correto");
        test.addScreenCaptureFromPath("apostasRealizadas.png");
        mega.btnIrParaPagamento();
        // Não continua, pois é necessário uma conta real para prosseguir com o pagamento.
    }

    @Test
    @DisplayName("Realizar aposta com mais de 6 números")
    //Exemplo de log simples
    public void realizaApostaMaisNumeros() throws IOException {
        home.acessarSite();
        home.btnMaioridade();
        home.btnAposteJa();
        home.btnMegaSena();
        mega.btnAumentaQtdNumerosAposta(apostaMaisNumeros); //Numero definido por parametro
        mega.btnNumeros(apostaMaisNumeros);//escolhe e marca os números
        assertEquals(apostaMaisNumeros, mega.verificaQtdNumMarcados());
        //comparar valores
        switch (apostaMaisNumeros) {
            case 7:
                assertEquals(valorAposta7, mega.valorApostaIndividual());
                break;
            case 8:
                assertEquals(valorAposta8, mega.valorApostaIndividual());
                break;
            case 9:
                assertEquals(valorAposta9, mega.valorApostaIndividual());
                break;
            case 10:
                assertEquals(valorAposta10, mega.valorApostaIndividual());
                break;
            case 11:
                assertEquals(valorAposta11, mega.valorApostaIndividual());
                break;
            case 12:
                assertEquals(valorAposta12, mega.valorApostaIndividual());
                break;
            case 13:
                assertEquals(valorAposta13, mega.valorApostaIndividual());
                break;
            case 14:
                assertEquals(valorAposta14, mega.valorApostaIndividual());
                break;
            case 15:
                assertEquals(valorAposta15, mega.valorApostaIndividual());
                break;
        }
        mega.btnColocarNoCarrinho();
        mega.btnIrParaPagamento();
        // Não continua, pois é necessário uma conta real para prosseguir com o pagamento.
    }

    @Test
    @DisplayName("Realizar várias apostas simples")
    public void realizaVariosJogosSimples() throws IOException {
        home.acessarSite();
        home.btnMaioridade();
        home.btnAposteJa();
        home.btnMegaSena();
        for (int i = 1; i <= qtdJogos; i++) {
            mega.btnNumeros(apostaSimplesMega);//escolhe e marca os números
            assertEquals(valorApostaSimplesMega, mega.valorApostaIndividual());
            mega.btnColocarNoCarrinho();
        }
        assertEquals(qtdJogos, mega.qtdCarrinho());
        assertEquals(util.calculaTotalSimples(qtdJogos), mega.valorTotalaposta());
        test.info("Foram feitas " + qtdJogos + " apostas");
        mega.volanteFinal();
        mega.btnIrParaPagamento();
        test.addScreenCaptureFromPath("volante.png");

    }

}
