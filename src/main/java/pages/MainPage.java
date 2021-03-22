package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPage extends BasePage {

    @FindBy(xpath = "//h1[@class='title' and contains(text(),'Добро пожаловать в ELMA365')]")
    WebElement titleWelcomeTo365;

    @FindBy(xpath = "//div[@class='banner']/descendant::span[text()='system_close']")
    WebElement closeBanner;

    @FindBy(xpath = "/html/body/app-root/div/main/app-main-header/nav/div/app-user-header/a")
    WebElement openUserProfileButton;

    @FindBy(css = ".popover_bottom > div")
    WebElement userProfilePopOver;

    @FindBy(xpath = "//button[@type='button' and contains(text(), 'Добавить Раздел')]")
    WebElement staticButtonAddUnit;

    @FindBy(xpath = "//button[@type='button' and contains(text(), 'settings')]")
    WebElement staticButtonSettings;

    @FindBy(xpath = "//*[@class='side-nav__button' and @title='Добавить Раздел']")
    WebElement leftMenuButtonAddUnit;

    @FindBy(xpath = "//*[@class='side-nav__button' and @title='Настройка Разделов и Решений']")
    WebElement leftMenuSettingsOfUnitsAndDecisions;

    @FindBy(css = "div > app-navigation-main-item")
    List<WebElement> leftMenuUnitButtons;

    @FindBy(xpath = "//div[@role='dialog']")
    WebElement systemDialog;

    @FindBy(xpath = "//*[@class='popover-content']")
    WebElement settingsPopOver;

    private static String newUnitName;
    private static String newText;

    private static Map<WebElement, String> leftMenuUnits;

    public Map<WebElement, String> getLeftMenuUnits() {
        return leftMenuUnits;
    }

    public static void setLeftMenuUnits(WebElement webElement, String unitName) {
        leftMenuUnits.put(webElement, unitName);
    }

    public Map<WebElement, String> fillMap() {
        Map<WebElement, String> map = new HashMap<>();
        for (WebElement w : leftMenuUnitButtons) {
            map.put(w, w.findElement(By.xpath("//span")).getText());
        }
        return map;
    }

    public MainPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(this.driver, 5);
        PageFactory.initElements(this.driver, this);
        leftMenuUnits = fillMap();
    }

    public void isElementDisplayed() {
        isElementDisplayed(By.xpath("//div[@role='dialog']"));
    }

    public void isInitialized() {

        try {
            WebElement popup = driver.findElement(By.cssSelector("p-dialog > div > div"));
            if (popup.isDisplayed()) {
                Actions actions = new Actions(driver);
                actions
                        .moveToElement(systemDialog.findElement(By.xpath("//div[@role='dialog']/descendant::*[contains(text(), 'Нет')]")))
                        .click()
                        .perform();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        JavascriptExecutor input = (JavascriptExecutor) driver;
        assertThat(input.executeScript("return document.readyState").equals("complete")).isEqualTo(true);
    }

    public void goToButtonUserProfile() {
        wait.until(ExpectedConditions.visibilityOf(openUserProfileButton));
        openUserProfileButton.click();
    }

    public void clickButtonOnUserProfilePopOver(String button) {
        WebElement buttonExit = driver.findElement(By.xpath("//span[text()='" + button + "']"));
        wait.until(ExpectedConditions.visibilityOf(buttonExit));
        buttonExit.click();
    }

    public void dialog(String buttonName) {
        WebElement systemDialog = driver.findElement(By.xpath("//div[@role='dialog']"));
        isElementDisplayed(systemDialog);

        Actions actions = new Actions(driver);
        actions
                .moveToElement(systemDialog.findElement(By.xpath("//div[@role='dialog']/descendant::*[contains(text(), '" + buttonName + "')]")))
                .click()
                .perform();
    }

    public void isProfilePopOverDisplayed() {
        isElementDisplayed(userProfilePopOver);
    }

    public void clickStaticButtonAddUnit() {
        staticButtonAddUnit.click();
    }

    public void fillDialogFieldWithText(String fieldName, String text) {
        newUnitName = text + "" + System.currentTimeMillis();
        WebElement input = driver.
                findElement(By.xpath("//div[@role='dialog']")).
                findElement(By.xpath("//span[text()='" + fieldName + "']/parent::elma-form-label[@class='elma-form-label ng-star-inserted']/following-sibling::elma-form-control/descendant::input"));
        input.click();
        input.sendKeys(newUnitName);


    }

    public void isUnitCreated() {
        WebElement newUnit = driver.findElement(By.xpath("//app-navigation-main-item/descendant::a[@title='" + newUnitName + "']"));
        isElementDisplayed(newUnit);

        for (int i = 0; i < leftMenuUnitButtons.size(); i++) {
            if (!leftMenuUnitButtons.get(i).findElement(By.xpath("//span")).getText().equals(newUnitName)) {
                leftMenuUnitButtons.add(newUnit);
                leftMenuUnits.put(newUnit, newUnitName);
            }
        }
    }

    public void clickLeftMenuButtonAddUnit() {
        wait.until(ExpectedConditions.visibilityOf(leftMenuButtonAddUnit));
        leftMenuButtonAddUnit.click();
    }

    public void clickStaticSettingsButton() {
        wait.until(ExpectedConditions.visibilityOf(staticButtonSettings));
        staticButtonSettings.click();
    }

    public void isSettingsPopoverOpened() {
        isElementDisplayed(settingsPopOver);
    }

    public void clickPopOverButtonByName(String buttonName) {
        WebElement button = settingsPopOver.findElement(By.xpath("//*[@class='popover-content']/descendant::*[text()='" + buttonName + "']"));
        wait.until(ExpectedConditions.visibilityOf(button));
        button.click();
    }

    public void isTwoColumnDisplayed() {
        driver.navigate().refresh();
        isElementDisplayed(driver.findElement(By.xpath("//div[@class='options-add-widget add-border']")));
    }

    public void isOneColumnDisplayed() {
        driver.navigate().refresh();
        isElementDisplayed(driver.findElement(By.xpath("//div[@class='app-page-content']")));
    }

    public void clickUnit(String unitName) {
        WebElement unit = driver.findElement(By.xpath("//a[@title='" + unitName + "']"));
        wait.until(ExpectedConditions.visibilityOf(unit));
        /*Actions actions = new Actions(driver);
        actions
                .moveToElement(unit)
                .click()
                .perform();*/
        unit.click();
    }

    public void clickApp(String appName) {
        WebElement app = driver.findElement(By.xpath("//a/child::span[contains(text(), '" + appName + "')]"));
        wait.until(ExpectedConditions.visibilityOf(app));
        /*Actions actions = new Actions(driver);
        actions
                .moveToElement(app)
                .click()
                .perform();*/
        app.click();
    }

    public void isAppOpened(String appName) {
        isElementDisplayed(driver.findElement(By.xpath("//div[@class='app-content router-wrapper']/descendant::*[contains(text(),'" + appName + "')]")));
    }

    public void isUnitOpened(String unitName) {
        isElementDisplayed(driver.findElement(By.xpath("//app-navigation-submenu-title[contains(text(),'" + unitName + "')]")));
    }

    public void clickButton(String buttonName) {
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'" + buttonName + "')]"));
        wait.until(ExpectedConditions.visibilityOf(button));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(button)
                .click()
                .perform();
    }

    public void isModalFormOpened(String nameForm) {
        isElementDisplayed(driver.findElement(By.xpath("//div[@class='complex-popup__main modal-lg']/descendant::span[contains(text(),'" + nameForm + "')]")));
    }

    public void fillModalFormFieldWithText(String field, String text) {
        newText = text.replace("@", System.currentTimeMillis() + "@");
        WebElement input = driver.
                //findElement(By.xpath("//*[contains(text(),'" + field + "')]/parent::elma-form-label[@class='elma-form-label ng-star-inserted']/following-sibling::elma-form-control/descendant::input"));
                        findElement(By.xpath("//*[contains(text(),'" + field + "')]/ancestor::elma-form-label/following-sibling::elma-form-control/descendant::input"));

        Actions actions = new Actions(driver);
        actions.moveToElement(input)
                .click()
                .perform();

        actions.sendKeys(newText)
                .perform();
    }

    public void IsUserCreated() {
        isElementDisplayed(driver.findElement(By.xpath("//div[@class='app-content router-wrapper']/descendant::*[contains(text(),'" + newText + "')]")));
    }

    public void isUserChoiceAvailable() {
        isElementDisplayed(driver.findElement(By.xpath("//app-user")));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(By.xpath("//app-user")))
                .click()
                .perform();
    }

    public void isMessageDisplayed(String message) {
        isElementDisplayed(driver.findElement(By.xpath("//div[contains(text(), '" + message + "')]")));
    }
}