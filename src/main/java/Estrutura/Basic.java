package Estrutura;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static Estrutura.DriverFactory.*;

public class Basic {
    public void acessar(String url){
        getDriver().get(url);
    }
    public void fecharNavegador(){
        killDriver();
    }
    //############# Manipulação de textos #############
    public void escreverPorId(String id, String texto){
        getDriver().findElement(By.id(id)).sendKeys(texto);

    }
    public String obterTextoPorXpath(String xpath){

        return getDriver().findElement(By.xpath(xpath)).getText();
    }
    public String obterTextoElementos(String xpath){

        return getDriver().findElements(By.xpath(xpath)).toString();
    }
    public String obterTextoPorId(String id){
        return getDriver().findElement(By.id(id)).getText();
    }

    public int obterQtdPorXpath(String xpath){
        return getDriver().findElements(By.xpath(xpath)).size();
    }
    //############# Manipulação botões #############
    public void clicarPorId(String id){
        getDriver().findElement(By.id(id)).click();
    }
    public void clicarPorLinkText(String texto){
        getDriver().findElement(By.linkText(texto)).click();
    }
    //############# Esperas #############
    public void esperaExplicitaFimdoScreen(String id){
        WebDriverWait espera = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));

    }
    //############# Print de tela #############
public void printarTela(String nomeArquivo) throws IOException {
    TakesScreenshot print =(TakesScreenshot) getDriver();
    File arquivo = print.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(arquivo, new File("src/"+nomeArquivo));

}
public void printarElemento(String xpath, String nomeArquivo) throws IOException {
    WebElement element = getDriver().findElement(By.xpath(xpath));
    File arquivo = element.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(arquivo, new File("src/"+nomeArquivo));

}
}
