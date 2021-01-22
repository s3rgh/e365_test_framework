package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.*;

public class StartPage extends BasePage {

    @FindBy(xpath = "/html/head/title")
    WebElement pageTitle;

    @FindBy(xpath = "//a[text()='Попробовать' and @class = 'btn']")
    WebElement buttonTry;

    @FindBy(xpath = "//div[@id='trialRegister']")
    WebElement inputForm;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void isInitialized() {
        assertThat(pageTitle.isEnabled()).isEqualTo(true);
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public void clickButton() {
        buttonTry.click();
    }

    public void setTextInLabel(String label, String text) {

        WebElement labelFio = inputForm.findElement(By.xpath("./*//label[text()='" + label + "']/preceding-sibling::input"));
        //JavascriptExecutor executor = (JavascriptExecutor) driver;
        //executor.executeScript("arguments[0].setAttribute('value','" + text + "')", labelFio);
        labelFio.sendKeys(text);
    }
}
