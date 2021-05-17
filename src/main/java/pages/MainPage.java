package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainPage extends BasePage {

    protected static Logger logger = LoggerFactory.getLogger(MainPage.class);

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

    @FindBy(xpath = "//*[@class='popover-content']")
    WebElement settingsPopOver;

    private static String newUnitName;
    private static Map<WebElement, String> leftMenuUnits;
    //private static List<WebElement> leftMenuUnitButtons;

/*    public Map<WebElement, String> fillMap() {
        leftMenuUnitButtons = driver.findElements(By.cssSelector("div > app-navigation-main-item"));
        Map<WebElement, String> map = new HashMap<>();
        for (WebElement w : leftMenuUnitButtons) {
            map.put(w, w.findElement(By.xpath("//span")).getText());
        }
        return map;
    }*/

    public MainPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(this.driver, 10);
        PageFactory.initElements(this.driver, this);
        //leftMenuUnits = fillMap();
    }

    public void isElementDisplayed() {
        isElementDisplayed(By.xpath("//div[@role='dialog']"));
    }

    public void isInitialized() {
        try {
            WebElement popup = driver.findElement(By.cssSelector("p-dialog > div > div"));
            if (popup.isDisplayed()) {
                popup.findElement(By.xpath("//div[@role='dialog']/descendant::*[contains(text(), 'Нет')]")).click();
            }
        } catch (NoSuchElementException e) {
            logger.info("!!!Timezone Popup doesn't shown!!!");
        }
        isElementDisplayed(By.xpath("//*[@class='title']"));
    }

    public void goToButtonUserProfile() {
        wait.until(ExpectedConditions.visibilityOf(openUserProfileButton));
        openUserProfileButton.click();
    }

    public void clickButtonOnUserProfilePopOver(String button) {
        WebElement buttonExit = driver.findElement(By.xpath("//span[text()='" + button + "']"));
        wait.until(ExpectedConditions.visibilityOf(buttonExit));
        driver.findElement(By.xpath("//span[text()='" + button + "']")).click();
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
        //leftMenuUnits = fillMap();
        //WebElement newUnit = driver.findElement(By.xpath("//app-navigation-main-item/descendant::a[@title='" + newUnitName + "']"));
        isElementDisplayed(driver.findElement(By.xpath("//app-navigation-main-item/descendant::a[@title='" + newUnitName + "']")));
/*        for (int i = 0; i < leftMenuUnitButtons.size(); i++) {
            if (!leftMenuUnitButtons.get(i).findElement(By.xpath("//span")).getText().equals(newUnitName)) {
                leftMenuUnitButtons.add(driver.findElement(By.xpath("//app-navigation-main-item/descendant::a[@title='" + newUnitName + "']")));
                leftMenuUnits.put(driver.findElement(By.xpath("//app-navigation-main-item/descendant::a[@title='" + newUnitName + "']")), newUnitName);
            }
        }*/
    }

    public void clickLeftMenuButtonAddUnit() {
        isElementDisplayed(leftMenuButtonAddUnit);
        leftMenuButtonAddUnit.click();
    }

    public void clickStaticSettingsButton() {
        isElementDisplayed(staticButtonSettings);
        staticButtonSettings.click();
    }

    public void isSettingsPopoverOpened() {
        isElementDisplayed(settingsPopOver);
    }

    public void clickPopOverButtonByName(String buttonName) {
        WebElement button = settingsPopOver.findElement(By.xpath("//*[@class='popover-content']/descendant::*[text()='" + buttonName + "']"));
        isElementDisplayed(button);
        settingsPopOver.findElement(By.xpath("//*[@class='popover-content']/descendant::*[text()='" + buttonName + "']")).click();
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
        isElementDisplayed(unit);
        unit.click();
    }

    public void clickApp(String appName) {
        WebElement app = driver.findElement(By.xpath("//a/child::span[contains(text(), '" + appName + "')]"));
        isElementDisplayed(app);
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
        wait.until(ExpectedConditions.elementToBeClickable(button));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(driver.findElement(By.xpath("//button[contains(text(),'" + buttonName + "')]")))
                .click()
                .perform();
    }

    public void isModalFormOpened(String nameForm) {
        isElementDisplayed(driver.findElement(By.xpath("//div[@class='complex-popup__main modal-lg']/descendant::span[contains(text(),'" + nameForm + "')]")));
    }

    public void fillModalFormFieldWithText(String field, String text) {
        String newText = text.replace("@", System.currentTimeMillis() + "@");
        WebElement input = driver.findElement(By.xpath("//*[contains(text(),'" + field + "')]/ancestor::elma-form-label/following-sibling::elma-form-control/descendant::input"));
        wait.until(ExpectedConditions.visibilityOf(input));
        input.click();
        input.sendKeys(newText);
    }

    public void IsUserCreated() {
        isElementDisplayed(driver.findElement(By.xpath("//div[contains(text(), 'Приглашение успешно создано')]")));
    }

    public void isUserChoiceAvailable(String name) {
        isElementDisplayed(driver.findElement(By.xpath("//*[contains(text(), '" + name + "')]/ancestor::app-user")));
        driver.findElement(By.xpath("//*[contains(text(), '" + name + "')]/ancestor::app-user")).click();
    }

    public void isMessageDisplayed(String message) {
        isElementDisplayed(driver.findElement(By.xpath("//div[contains(text(), '" + message + "')]")));
    }

    public void clickUserChoice(String arg0) {
        WebElement webElement = driver.findElement(By.xpath("//*[contains(text(), '" + arg0 + "')]/ancestor::app-user"));
        isElementDisplayed(webElement);
        webElement.click();
    }
}