package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;

public class MainPageSteps extends TestBase {

    MainPage mainPage;

    @Before
    public void start() {
        initialize();
        mainPage = new MainPage(webDriver);
    }

    @After
    public void stop() {
        tearDown();
    }

    @Then("Main page is opened")
    public void isMainPageOpened() {
        mainPage.isInitialized();
    }

    @And("Click profile button")
    public void clickProfileButton() {
        mainPage.goToButtonUserProfile();
    }

    @And("Profile popover is opened")
    public void isProfilePopOverOpen() {
        mainPage.isProfilePopOverDisplayed();
    }

   """ @And("Нажать кнопку {string}")
    public void clickButton(String button) {
        mainPage.clickButtonOnUserProfilePopOver(button);
    }"""

    @And("Click user profile button {string}")
    public void clickButtonOnUserProfilePopOver(String buttonName) {
        mainPage.clickButtonOnUserProfilePopOver(buttonName);
    }

    @And("Нажать кнопку для выхода {string}")
    public void clickExitButton(String button) {
        mainPage.clickButtonExitOnUserProfilePopOver(button);
    }

    @And("Нажать кнопку левого меню {string}")
    public void clickMenuButton(String button) {
        mainPage.clickButtonOnMenuPopOver(button);
    }

 """   @When("открыт Exit Dialog")
    public void isExitDialogOpen() {
        mainPage.isElementDisplayed();
    }"""

    @When("Dialog is opened")
    public void isDialogOpened() {
        mainPage.isElementDisplayed();
    }

    @And("Click dialog button {string}")
    public void clickDialogButton(String buttonName) {
        mainPage.dialog(buttonName);
    }

    @And("Click button Create Unit")
    public void clickButtonCreateUnit() {
        mainPage.clickStaticButtonAddUnit();
    }

    @And("Fill dialog field {string} with text {string}")
    public void fillDialogFieldWithText(String fieldName, String text) {
        mainPage.fillDialogFieldWithText(fieldName, text);
    }

    @Then("Unit created")
    public void unitCreated() {
        mainPage.isUnitCreated();
    }

    @And("Click left menu button Create Unit")
    public void clickLeftMenuButtonCreateUnit() {
        mainPage.clickLeftMenuButtonAddUnit();
    }

    @And("Open unit {string}")
    public void openUnit(String unitName) {
        mainPage.clickUnit(unitName);
    }

    @Then("Unit {string} is opened")
    public void unitIsOpened(String unitName) {
        mainPage.isUnitOpened(unitName);
    }

    @And("Click button settings")
    public void clickButtonSettings() {
        mainPage.clickStaticSettingsButton();
    }

    @And("Settings popover is opened")
    public void isSettingsPopoverOpened() {
        mainPage.isSettingsPopoverOpened();
    }

    @And("Click popover button {string}")
    public void clickPopOverButton(String buttonName) {
        mainPage.clickPopOverButtonByName(buttonName);
    }

    @Then("Two column is displayed")
    public void isTwoColumnDisplayed() {
        mainPage.isTwoColumnDisplayed();
    }

    @Then("One column is displayed")
    public void oneColumnIsDisplayed() {
        mainPage.isOneColumnDisplayed();
    }

    @And("Open {string} application")
    public void openApplication(String appName) {
        mainPage.clickApp(appName);
    }

    @When("App {string} is opened")
    public void appIsOpened(String appName) {
        mainPage.isAppOpened(appName);
    }

    @And("Click button {string}")
    public void clickButton(String buttonName) {
        mainPage.clickButton(buttonName);
    }

    @And("Modal form {string} is opened")
    public void modalFormIsOpened(String nameForm) {
        mainPage.isModalFormOpened(nameForm);
    }

    @And("Fill modal form field {string} with text {string}")
    public void fillModalFormFieldWithText(String field, String text) {
        mainPage.fillModalFormFieldWithText(field, text);
    }

    @Then("User is created")
    public void IsUserCreated() {
        mainPage.IsUserCreated();
    }

    @And("User choice is available")
    public void isUserChoiceAvailable() {
        mainPage.isUserChoiceAvailable();
    }

    @Then("Message {string} is shown")
    public void isMessageDisplayed(String message) {
        mainPage.isMessageDisplayed(message);
    }
}