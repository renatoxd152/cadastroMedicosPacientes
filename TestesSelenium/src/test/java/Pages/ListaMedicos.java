package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListaMedicos {
    private WebDriver driver;
    private By listaAllButton = By.xpath("//*[@id=\"cadastro-2\"]/div/button[1]");

    public ListaMedicos(WebDriver driver) {
        this.driver = driver;
    }

    public void listAll() {
        driver.findElement(listaAllButton).click();
    }
}
