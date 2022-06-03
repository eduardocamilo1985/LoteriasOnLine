package Estrutura;

import Pages.HomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.junit.jupiter.api.extension.*;

import java.awt.*;
import java.io.File;

public class Relatorio implements BeforeTestExecutionCallback, AfterTestExecutionCallback, BeforeAllCallback, AfterAllCallback {
    public static ExtentReports extent;
    public static ExtentTest test;
    ExtentSparkReporter spark;
    HomePage home = new HomePage();

    @Override
    public void beforeAll(ExtensionContext context) {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("src/relatorio.html");
        ExtentSparkReporter sparkSoFalha = new ExtentSparkReporter("src/RelatorioSoFalha.html").filter().statusFilter().as(new Status[]{Status.FAIL}).apply();
        //  final File CONF = new File("spark-config.xml");
        //  spark.loadXMLConfig(CONF); //Pode ser configurado via arquivo XML ou via codigo conforme abaixo

        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Relatório de testes");
        spark.config().setReportName("Relatório de testes automatizados");
        spark.config().setTimeStampFormat("dd/MM/yyyy, HH:mm:ss");
        extent.attachReporter(spark);// se tiver mais de um, separar por virgula
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) throws Exception {
        test = extent.createTest(context.getDisplayName());
        test.log(Status.INFO, context.getDisplayName() + " - Iniciando teste");
    }

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        if (!context.getExecutionException().isPresent()) {
            test.pass(context.getDisplayName() + "- Executado com sucesso");
        } else {
            test.fail(context.getExecutionException().get().getLocalizedMessage());
            //  test.addScreenCaptureFromPath(((ElementShould) context.getExecutionException().get()).getScreenshot());
        }
        home.finalizar();
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        extent.flush();// isso monta o relatório
        Desktop.getDesktop().browse(new File("src/relatorio.html").toURI());//Abre o relatório automaticamente
    }
}

