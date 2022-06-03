package Pages;

import Estrutura.Basic;
import Estrutura.Util;

import java.io.IOException;
import java.util.Arrays;

import static Estrutura.Parametros.*;

public class MegaSenaPage extends Basic {
    String screenDeTela = "dimScreen";
    Util util = new Util();
   // public static String numSelecionados;

    public void btnAumentaQtdNumerosAposta(int qtdNum) {
        int numCliques = qtdNum - apostaSimplesMega;
        esperaExplicitaFimdoScreen(screenDeTela);
        for (int i =1;i<=numCliques;i++) {
            clicarPorId("aumentarnumero");
            System.out.println("O valor de i ="+i+ " A quantidade de cliques é "+numCliques);
        }
    }

    public void btnDiminuiQtdNumerosAposta() {
        clicarPorId("diminuirnumero");
    }

    public String txtQtdNumAposta() {
        return obterTextoPorXpath("//div[@class='numero-item']//span");
    }
    public int verificaQtdNumMarcados(){
        esperaExplicitaFimdoScreen(screenDeTela);
        return obterQtdPorXpath("//a[@class='ng-binding selected']");

    }
    public int qtdCarrinho(){
        int qtd = Integer.parseInt(obterTextoPorId("carrinho"));
       return qtd;
    }
    public void btnColocarNoCarrinho(){
        clicarPorId("colocarnocarrinho");
    }
    public void msgSucessoCarrinho(){
        obterTextoPorXpath("//*[contains(text(),Aposta inserida no carrinho com Sucesso");
    }
    public void msgFaltaNumeros(){
        obterQtdPorXpath("//*[contains(text(),'Sua aposta está incompleta.')]");
    }
    public String valorApostaIndividual(){
        return obterTextoPorId("valoraposta");
    }
    public String valorTotalaposta(){
        return obterTextoPorId("valortotalapostas").replace(" ","");

    }
    public String verificaNumerosSelecionados(){
        return obterTextoElementos("//div[@class='numeros-volante flexbox-row']/span");
       // return obterTextoElementos("//span[@class='margemVolante ng-binding ng-scope']");
    }
    public void btnIrParaPagamento() throws IOException {
        printarTela("apostasRealizadas.png");
        clicarPorId("irparapagamento");
    }

    public void btnNumeros(int numDezenas) { // vai clicar nas dezenas de acordo com a quantidade
       int[] dezenas = util.numeroAleatorio(numDezenas);
        System.out.println(Arrays.toString(dezenas));
        for (int i = 0; i < numDezenas; i++) {
            if (dezenas[i] < 10) {
                esperaExplicitaFimdoScreen(screenDeTela);
                clicarPorId("n0" + dezenas[i]);
            } else {
                esperaExplicitaFimdoScreen(screenDeTela);
                clicarPorId("n" + dezenas[i]);
            }
                 }
       // numSelecionados = dezenas.toString();
       // return dezenas.toString();
    }
    public void volanteFinal() throws IOException {
        printarElemento("//div[@class='volantes-box clearfix col-md-4']","volante.png");
    }
}
