package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CadastroMedicos {
    private WebDriver driver;
    private By buttonRegisterDoctor = By.id("cadastrar");
    private By crmField = By.id("crm");
    private By nomeField = By.id("nome");
    private By dataNascimentoField = By.id("data");
    private By sexoField = By.id("sexo");
    private By especialidadeField = By.id("especialidade");
    private By universidadeField = By.id("universidade");
    private By emailField = By.id("email");
    private By telefoneField = By.id("telefone");
    private WebElement especialidadeDropdown;
    private Select select;
    private By listMedics = By.xpath("//*[@id=\"cadastro-2\"]/div/a");
    private By saveEditions = By.xpath("//*[@id=\"AlterarMedico\"]");
    private WebElement cadastrarButton;
    private WebDriverWait wait;

    public CadastroMedicos(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickRegisterDoctor() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonRegisterDoctor)).click();
    }

    public void clickDoctorsList() {
        wait.until(ExpectedConditions.elementToBeClickable(listMedics)).click();
    }

    public void clickSaveEditDoctor() {
        wait.until(ExpectedConditions.elementToBeClickable(saveEditions)).click();
    }

    public void fillCrmField(String crm) {
        driver.findElement(crmField).sendKeys(crm);
    }

    public void fillNomeField(String nome) {
        driver.findElement(nomeField).sendKeys(nome);
    }

    public void fillDataNascimentoField(String dataNascimento) {
        driver.findElement(dataNascimentoField).sendKeys(dataNascimento);
    }

    public void fillSexoField(String sexo) {
        driver.findElement(sexoField).sendKeys(sexo);
    }

    public void selectEspecialidade(String especialidade) {
        especialidadeDropdown = driver.findElement(especialidadeField);
        select = new Select(especialidadeDropdown);
        select.selectByVisibleText(especialidade);
    }

    public void fillUniversidadeField(String universidade) {
        driver.findElement(universidadeField).sendKeys(universidade);
    }

    public void fillEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillTelefoneField(String telefone) {
        driver.findElement(telefoneField).sendKeys(telefone);
    }

    public void fillAllFields(String crm, String nome, String dataNascimento, String sexo,
                              String especialidade, String universidade, String email, String telefone) {
        fillCrmField(crm);
        fillNomeField(nome);
        fillDataNascimentoField(dataNascimento);
        fillSexoField(sexo);
        selectEspecialidade(especialidade);
        fillUniversidadeField(universidade);
        fillEmailField(email);
        fillTelefoneField(telefone);
    }

    public void clearAllFields() {
        driver.findElement(crmField).clear();
        driver.findElement(nomeField).clear();
        driver.findElement(dataNascimentoField).clear();
        driver.findElement(sexoField).clear();
        selectEspecialidade("Cardiologista");
        driver.findElement(universidadeField).clear();
        driver.findElement(emailField).clear();
        driver.findElement(telefoneField).clear();
    }

    public boolean isRegisterButtonDisplayed() {
        cadastrarButton = driver.findElement(buttonRegisterDoctor);
        return cadastrarButton.isDisplayed();
    }
}
