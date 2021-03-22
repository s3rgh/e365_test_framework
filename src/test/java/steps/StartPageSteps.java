package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.StartPage;

public class StartPageSteps extends TestBase {

    StartPage startPage;

    @Before
    public void start() {
        initialize();
        startPage = new StartPage(webDriver);
    }

    @After
    public void stop() {
        tearDown();
    }

    @Given("Open start page {string}")
    public void openPage(String arg0) {
        startPage.openURL(arg0);
    }

    @Then("Start page is opened")
    public void pageIsOpened() {
        startPage.isInitialized();
    }

    @And("Click submit button {string}")
    public void clickButton(String buttonName) {
        startPage.clickSubmitButton(buttonName);
    }

    @And("Enter your data {string} to field {string}")
    public void enterYourNameToField(String name, String field) {
        startPage.setTextInLabel(name, field);
    }

    @And("Hover mouseCursor to button enter")
    public void hoverMouseCursorToButtonEnter() {
        startPage.goToButtonEnter();
    }

    @And("Enter your login {string} and password {string}")
    public void enterYourLoginAndPassword(String login, String password) {
        startPage.setEnterLoginAndPassword(login, password);
    }

    @And("Click button Enter")
    public void clickButtonEnter() {
        startPage.pushEnterButton();
    }

    @And("Select remember me checkBox")
    public void selectCheckBox() {
        startPage.selectRememberMeCheckBox();
    }

    @Then("Email or password is incorrect")
    public void isEmailOrPasswordCorrect() {
        startPage.isElementDisplayed();
    }

    @And("Choose item {string} in list on label {string}")
    public void chooseElementInList(String text, String label) {
        startPage.chooseItemInListOnLabel(text, label);
    }

    @And("Accept the terms of the user agreement")
    public void acceptTheTermsOfTheUserAgreement() {
        startPage.acceptTermsOfUserAgreement();
    }

    @And("Click try button")
    public void clickTryButton() {
        startPage.clickTryButton();
    }

    @Then("Element is displayed")
    public void elementIsDisplayed() {
        startPage.isElementDisplayed();
    }

    @Then("Success reg message is displayed")
    public void isSuccessRegMessageDisplayed() {
        startPage.isSuccessRegMessageDisplayed();
    }
}