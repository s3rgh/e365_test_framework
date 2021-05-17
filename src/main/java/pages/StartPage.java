package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StartPage extends BasePage {

    public StartPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@class='h1-title hero__title']")
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

    @FindBy(css = "input[name='emailOrLogin']")
    WebElement enterEmailOrLogin;

    @FindBy(tagName = "button")
    List<WebElement> buttons;

    @FindBy(xpath = "//span[@class='registration__label--icon']")
    List<WebElement> acceptCheckBoxes;

    public void isElementDisplayed() {
        isElementDisplayed(wrongPasswordMessage);
    }

    public void goToEmailEnter() {
        moveToElement(enterEmailOrLogin);
        isElementDisplayed(popOver);
    }

    public void isSuccessRegMessageDisplayed() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"trialRegister\"]"));
        isElementDisplayed(element);
    }

    public void goToButtonEnter() {
        moveToElement(buttonEnter);
        isElementDisplayed(popOver);
    }

    public void setEnterLoginAndPassword(String login, String password) {
        enterLogin.sendKeys(login);
        enterPassword.sendKeys(password);
    }

    public void pushEnterButton() {
        WebElement enterButtonOnPopOver = popOver.findElement(By.xpath("//button[@class='btn js-submit ladda-button']/child::span[text()='Войти']"));
        enterButtonOnPopOver.click();
    }

    public void selectRememberMeCheckBox() {
        moveToElement(buttonEnter);
        WebElement checkBox = popOver.findElement(By.xpath("//*[@class='agree-check registration__input--checkbox visually-hidden']/following-sibling::span[text()='Запомнить меня']"));
        checkBox.click();
    }

    public void isInitialized() {
        assertThat(pageTitle.isEnabled()).isEqualTo(true);
    }

    public void openURL(String url) {
        driver.get(url);
    }

    public void clickSubmitButton(String buttonName) {
        for (WebElement b : buttons) {
            if (b.findElement(By.xpath("//span[text()='" + buttonName + "']")).isEnabled() && b.findElement(By.xpath("//span[text()='" + buttonName + "']")).isDisplayed()) {
                b.findElement(By.xpath("//span[text()='" + buttonName + "']")).click();
                break;
            }
        }
    }

    @Override
    public void setTextInLabel(String text, String label) {
        WebElement labelFio = inputForm.findElement(By.xpath("./*//label[text()='" + label + "']/preceding-sibling::input"));
        isElementDisplayed(labelFio);
        labelFio.sendKeys(text);
    }

    public void chooseItemInListOnLabel(String text, String label) {
        WebElement dropdown = driver.findElement(By.xpath("//label[text()='" + label + "']/preceding-sibling::select[@id='companySize'] "));
        isElementDisplayed(dropdown);
        dropdown.click();
        dropdown.findElement(By.cssSelector("#companySize > option[value='" + text + "']")).click();
        assertThat(dropdown.isDisplayed()).isEqualTo(true);
    }

    public void acceptTermsOfUserAgreement() {
        for (WebElement checkBox : acceptCheckBoxes) {
            if (checkBox.isEnabled() && checkBox.isDisplayed()) {
                checkBox.click();
                break;
            }
        }
    }

    public void clickTryButton() {
        isElementDisplayed(buttonTry);
        buttonTry.click();
    }
}