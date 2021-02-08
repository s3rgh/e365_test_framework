package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//h1[@class='title' and contains(text(),'Добро пожаловать в ELMA365')]")
    WebElement titleWelcomeTo365;

    @FindBy(xpath = "/html/body/app-root/div/main/app-main-header/nav/div/app-user-header/a")

    WebElement openUserProfileButton;

    @FindBy(css = ".popover_bottom > div")
    WebElement userProfilePopOver;

    @FindBy(css = ".ng-trigger")
    WebElement systemExitDialog;

    public void isElementDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(systemExitDialog));
        isElementDisplayed(systemExitDialog);
    }

    public void isInitialized() {
        wait.until(ExpectedConditions.visibilityOf(titleWelcomeTo365));
        assertThat(titleWelcomeTo365.isDisplayed()).isEqualTo(true);
    }

    public void goToButtonUserProfile() {
        wait.until(ExpectedConditions.visibilityOf(openUserProfileButton));
        openUserProfileButton.click();
    }

    public void clickButtonOnUserProfilePopOver(String button) {
        WebElement buttonExit = driver.findElement(By.xpath("//span[text()='" + button +"']/ancestor::*[@class='ctx-menu__item ng-star-inserted']"));
        wait.until(ExpectedConditions.visibilityOf(buttonExit));
        buttonExit.click();
    }

    public void submitExitDialog() {
        assertThat(systemExitDialog.isDisplayed()).isEqualTo(true);
        WebElement buttonOk = systemExitDialog.findElement(By.xpath("//button[text()='ОК']"));
        buttonOk.click();
    }

    public void declineExitDialog() {
        assertThat(systemExitDialog.isDisplayed()).isEqualTo(true);
        WebElement buttonDecline = systemExitDialog.findElement(By.xpath("//button[text()='Отмена']"));
        buttonDecline.click();
    }

    public void isProfilePopOverDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(userProfilePopOver));
        isElementDisplayed(userProfilePopOver);
    }
}