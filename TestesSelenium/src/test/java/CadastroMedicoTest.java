import Pages.PaginaInicial;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastroMedicoTest {
    private WebDriver driver;
    final String url = "https://cadastro-medicos-pacientes-a4n9.vercel.app/";
    private PaginaInicial paginaInicial;
    private  WebDriverWait webDriverWait;
    private Alert alert;
    private String alertMessage;
    @BeforeEach
    void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        paginaInicial = new PaginaInicial(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterEach
    void tearDown()
    {
        driver.quit();
    }
    @Test
    @DisplayName("Should open and close the website")
    void shouldOpenAndCloseTheWebsite() throws InterruptedException {
        driver.get(url);
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    @DisplayName("Should click on the doctor's button and go to another page")
    void shouldClickOnTheDoctorsButtonAndGoToAnotherPage() throws InterruptedException
    {
        driver.get(url);
        Thread.sleep(1000);
        paginaInicial.clickButtonMedic();
        Thread.sleep(1000);
    }

    @Test
    @DisplayName("Should click on the patient page button and redirect to the other page")
    void shouldClickOnThePatientePageButtonAndRedirectToTheOtherPage()throws InterruptedException
    {
        driver.get(url);
        Thread.sleep(1000);
        paginaInicial.clickPatientPage();
        Thread.sleep(1000);
    }

    @Test
    @DisplayName("Should navigate to the doctor registration page, click on register and an alert should appear with a message")
    void shouldNavigateToTheDoctorRegistrationPageClickOnRegisterAndAnAlertShouldAppearWithAMessage() throws InterruptedException
    {
        driver.get(url);
        Thread.sleep(1000);
        paginaInicial.clickButtonMedic();
        Thread.sleep(1000);
        paginaInicial.clickRegisterDoctor();
        Thread.sleep(1000);

        webDriverWait.until(ExpectedConditions.alertIsPresent());

        alert = driver.switchTo().alert();

        alertMessage = alert.getText();

        assertEquals("Todos os campos são obrigatórios.", alertMessage);
        alert.accept();
    }


}
