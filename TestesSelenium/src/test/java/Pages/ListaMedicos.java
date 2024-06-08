package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListaMedicos {
    private WebDriver driver;
    private By listaAllButton = By.xpath("//*[@id=\"cadastro-2\"]/div/button[1]");
    private By doctorRows = By.xpath("//*[@id=\"medicosTable\"]/tbody/tr");
    private By listDoctor = By.xpath("//*[@id=\"cadastro-2\"]/div/button[2]");
    private By editDoctor = By.xpath("//*[@id=\"cadastro-2\"]/div/button[3]");
    private By deleteDoctor = By.xpath("//*[@id=\"cadastro-2\"]/div/button[4]");
    private By search = By.id("icrm");
    public ListaMedicos(WebDriver driver) {
        this.driver = driver;
    }

    public void listAll() {
        driver.findElement(listaAllButton).click();
    }

    public List<WebElement> getDoctorRows() {
        return driver.findElements(doctorRows);
    }

    public void clickListDoctor() {
        driver.findElement(listDoctor).click();
    }

    public void searchCRM(String crm) {
        driver.findElement(search).sendKeys(crm);
    }


    public void clickEditDoctor() {
        driver.findElement(editDoctor).click();
    }

    public void clickDeleteDoctor() {
        driver.findElement(deleteDoctor).click();
    }
}
