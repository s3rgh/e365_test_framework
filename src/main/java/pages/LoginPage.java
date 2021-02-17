package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }

    public void isButtonAvailable(String string) {
        isElementDisplayed(driver.findElement(By.xpath("//button[contains(text(),'" + string + "')]")));
    }
}
