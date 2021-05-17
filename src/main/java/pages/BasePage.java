package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }

    public void isElementDisplayed(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        assertThat(driver.findElement(elementBy).isDisplayed()).isEqualTo(true);
    }

    public void isElementDisplayed(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        assertThat(webElement.isDisplayed()).isEqualTo(true);
    }

    public void setTextInLabel(String textLabel, String text) {
        WebElement el = driver.findElement(By.xpath("//label[text()='" + textLabel + "']/preceding-sibling::input"));
        el.sendKeys(text);
    }

    public void moveToElement(WebElement webElement) {
        Actions builder = new Actions(driver);
        builder.moveToElement(webElement).build().perform();
    }
}