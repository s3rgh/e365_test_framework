package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.*;

public class BasePage {

    protected WebDriver driver;
    public WebDriverWait wait;

    //Wait Wrapper Method  by element located By
    public void waitVisibility(By elementBy) {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitVisibility(WebElement element) {
       // wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
    }

    //Click Method by element located By
    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Is Element located By  Displayed
    public void isElementDisplayed(By elementBy) {
        waitVisibility(elementBy);
        assertThat(driver.findElement(elementBy).isDisplayed()).isEqualTo(true);
    }

    public void waitForFilling(By elementBy) {
       // wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    //Write Text in field located By
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);
    }

    public void setTextInLabel(String textLabel, String text) {
        WebElement el = driver.findElement(By.xpath("//label[text()='" + textLabel + "']/preceding-sibling::input"));
        System.out.println(el.getTagName());
        System.out.println(el.isSelected());
        el.sendKeys(text);
    }

    /*public void setTextInLabelOnElement(String textLabel, String text) {
        WebElement el = webElement.findElement(By.xpath("//label[text()='" + textLabel + "']/preceding-sibling::input"));
        System.out.println(el.getTagName());
        System.out.println(el.isSelected());
        el.sendKeys(text);
    }*/

    public void isElementNotDisplayed(By elementBy) {
        assertThat(driver.findElements(elementBy).isEmpty()).isEqualTo(true);
    }

    public void isAlertText(String message) {
        assertThat(driver.switchTo().alert().getText()).isEqualTo(message);
    }
}