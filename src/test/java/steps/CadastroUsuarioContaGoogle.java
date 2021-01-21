package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class CadastroUsuarioContaGoogle {

    protected WebDriver driver;

    private String textPrimeiroNome;
    private String textSobreNome;
    private String textEmail;
    private String textSenha;
    private String textTelefone;


    @Given("^que estou acessando a aplicação$")

    public void que_estou_acessando_a_aplicação() throws Throwable {

        try {
            System.setProperty("webdriver.chrome.driver",
                    "C:\\Users\\jerso\\Git\\FakerGeneratorContaGoogle\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("https://www.fakenamegenerator.com/");
        } catch (Exception error) {
            System.out.println("Não foi encontrado o caminho do ChromeDriver ou não foi possivel acessar a aplicação");
        }
    }

    @Quando("^armazeno os dados capturados$")
    public void armazeno_os_dados_capturados() throws Throwable {

        WebElement saveNomeCompleto = this.driver.findElement(By.ByLinkText.cssSelector("#details>div.content>div.info>div>div.address>h3"));
        String nomeCompleto = saveNomeCompleto.getText();
        String[] separarParteNome = nomeCompleto.split(" ");
        this.textPrimeiroNome = separarParteNome[0];
        this.textSobreNome = separarParteNome[2];

        File printGeradorDeDadosNomeCompleto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(printGeradorDeDadosNomeCompleto, new File("C:\\Users\\jerso\\Git\\FakerGeneratorContaGoogle\\target\\Evidencias\\1_TelaGeracaoDeDadosNomeCompleto.png"));

        JavascriptExecutor descerPagina = (JavascriptExecutor) this.driver;
        descerPagina.executeScript("window.scrollTo(0,500)", new Object[0]);

        WebElement userEmail = this.driver.findElement(By.xpath("//*[@id='details']/div[2]/div[2]/div/div[2]/dl[10]/dt/following-sibling::dd"));
        this.textEmail = userEmail.getText() + "7q819d";
        WebElement generatorSenha = this.driver.findElement(By.xpath("//*[@id='details']/div[2]/div[2]/div/div[2]/dl[11]/dt/following-sibling::dd"));
        this.textSenha = generatorSenha.getText();

        File printGeradorDeDadosEmailSenha = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(printGeradorDeDadosEmailSenha, new File("C:\\Users\\jerso\\Git\\FakerGeneratorContaGoogle\\target\\Evidencias\\2_TelaGeracaoDeDadosEmailSenha.png"));

    }

    @Quando("^clico no botão para acessar o google$")
    public void clico_no_botão_para_acessar_o_google() throws Throwable {

        driver.findElement(By.cssSelector("#details>div.content>div.bcs>div>div:nth-child(2)>a>img")).click();
        driver.findElement(By.cssSelector("#view_container>div>div>div.pwWryf.bxPAYd>div>div.zQJV3>div>div.daaWTb>div>div>div>button>div.VfPpkd-RLmnJb")).click();

    }

    @Quando("^preencho os campos de cadastro$")
    public void preencho_os_campos_de_cadastro() throws Throwable {

        driver.findElement(By.id("firstName")).sendKeys(textPrimeiroNome);
        driver.findElement(By.id("lastName")).sendKeys(textSobreNome);
        driver.findElement(By.id("username")).sendKeys(textEmail);
        driver.findElement(By.name("Passwd")).sendKeys(textSenha);
        driver.findElement(By.name("ConfirmPasswd")).sendKeys(textSenha);

        File printContaGmailPreenchido = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(printContaGmailPreenchido, new File("C:\\Users\\jerso\\Git\\FakerGeneratorContaGoogle\\target\\Evidencias\\3_TelaContaGooglePreenchido.png"));

        driver.findElement(By.cssSelector("#view_container>div>div>div.pwWryf.bxPAYd>div>div.zQJV3>div>div.qhFLie>div>div>button")).click();
    }

    @Quando("^informo \"([^\"]*)\"$")
    public void informo(String arg1) throws Throwable {

        driver.findElement(By.id("phoneNumberId")).sendKeys("11123456789");
        driver.findElement(By.cssSelector("#view_container>div>div>div.pwWryf.bxPAYd>div>div.zQJV3>div>div.qhFLie>div>div>button>div.VfPpkd-RLmnJb")).click();
        WebElement telefone = driver.findElement(By.cssSelector("#view_container>div>div>div.pwWryf.bxPAYd>div>div.WEQkZc>div>form>span>section>div>div>div.bAnubd.OcVpRe>div>div.rFrNMe.RSJo4e.N3Hzgf.jjwyfe.zKHdkd.sdJrJc.Tyc9J.CDELXb.k0tWj.IYewr>div.LXRPh>div.dEOOab.RxsGPe>div"));
        textTelefone = telefone.getText();

    }

    @Então("^faço a validação da \"([^\"]*)\" de erro apresentada$")
    public void faço_a_validação_da_de_erro_apresentada(String arg1) throws Throwable {

        File printContaTelefoneInvalido = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(printContaTelefoneInvalido, new File("C:\\Users\\jerso\\Git\\FakerGeneratorContaGoogle\\target\\Evidencias\\4_TelaContaGoogleTelefoneInvalido.png"));

        Assert.assertEquals("Este formato de número de telefone não é válido. Verifique o país e o número.", textTelefone);


        driver.quit();
    }

}