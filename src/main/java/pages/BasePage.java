package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.*;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }

    //Wait Wrapper Method  by element located By
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    //Is Element located By  Displayed
    public void isElementDisplayed(By elementBy) {
        waitVisibility(elementBy);
        assertThat(driver.findElement(elementBy).isDisplayed()).isEqualTo(true);
    }

    public void isElementDisplayed(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        assertThat(webElement.isDisplayed()).isEqualTo(true);
    }

    public void setTextInLabel(String textLabel, String text) {
        WebElement el = driver.findElement(By.xpath("//label[text()='" + textLabel + "']/preceding-sibling::input"));
        System.out.println(el.getTagName());
        System.out.println(el.isSelected());
        el.sendKeys(text);
    }

    public void isElementNotDisplayed(By elementBy) {
        assertThat(driver.findElements(elementBy).isEmpty()).isEqualTo(true);
    }

    public void isAlertText(String message) {
        assertThat(driver.switchTo().alert().getText()).isEqualTo(message);
    }

    public void moveToElement(WebElement webElement) {
        Actions builder = new Actions(driver);
        builder.moveToElement(webElement).build().perform();
    }
}