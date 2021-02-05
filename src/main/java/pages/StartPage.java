package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.*;

public class StartPage extends BasePage {

    public StartPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }


    @FindBy(xpath = "/html/head/title")
    WebElement pageTitle;

    @FindBy(xpath = "//a[text()='Попробовать' and @class = 'btn']")
    WebElement buttonTry;

    @FindBy(xpath = "//div[@id='trialRegister']")
    WebElement inputForm;

    @FindBy(css = ".--icon-login")
    WebElement buttonEnter;

    @FindBy(css = ".--popover")
    WebElement popOver;

    @FindBy(xpath = "//*[@id='name-l']")
    WebElement enterLogin;

    @FindBy(xpath = "//*[@id='password-l']")
    WebElement enterPassword;

    @FindBy(xpath = "//div[contains(text(), 'E-mail или пароль указан не верно.')]")
    WebElement wrongPasswordMessage;

    public void isElementDisplayed() {
        isElementDisplayed(wrongPasswordMessage);
    }

    public void goToButtonEnter() {
        moveToElement(buttonEnter);
        isElementDisplayed(popOver);
    }

    public void setEnterLoginAndPassword(String login, String password) {
        assertThat(enterLogin.isDisplayed()).isEqualTo(true);
        enterLogin.sendKeys(login);
        assertThat(enterPassword.isDisplayed()).isEqualTo(true);
        enterPassword.sendKeys(password);
    }

    public void pushEnterButton() {
        WebElement enterButtonOnPopOver = popOver.findElement(By.xpath("//button[@class='btn js-submit ladda-button']/child::span[text()='Войти']"));
        isElementDisplayed(enterButtonOnPopOver);
        enterButtonOnPopOver.click();
    }

    public void selectRememberMeCheckBox() {
        moveToElement(buttonEnter);
        isElementDisplayed(popOver);
        WebElement checkBox = popOver.findElement(By.xpath("//*[@class='agree-check registration__input--checkbox visually-hidden']/following-sibling::span[text()='Запомнить меня']"));
        isElementDisplayed(checkBox);
        checkBox.click();
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
        labelFio.sendKeys(text);
        // we can use javascript executor instead
        // JavascriptExecutor executor = (JavascriptExecutor) driver;
        // executor.executeScript("arguments[0].setAttribute('value','" + text + "')", labelFio);
    }
}