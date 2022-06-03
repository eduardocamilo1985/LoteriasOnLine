package Pages;

import Estrutura.Basic;

import java.io.IOException;


public class HomePage extends Basic {
    String screenDeTela = "dimScreen";
    public void acessarSite(){
        acessar("https://www.loteriasonline.caixa.gov.br");
    }
    public void finalizar(){
        fecharNavegador();
    }

    public void btnMaioridade() throws IOException {
        esperaExplicitaFimdoScreen(screenDeTela);
        printarTela("printMaioridade.png");
        clicarPorId("botaosim");

    }
    public void btnAposteJa()  {

        esperaExplicitaFimdoScreen(screenDeTela);
        clicarPorLinkText("Aposte já");
    }
    public void btnMegaSena(){
        clicarPorLinkText("mega-sena");
    }

}
