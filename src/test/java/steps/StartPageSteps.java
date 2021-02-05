package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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

    @Given("open start page {string}")
    public void openPage(String arg0) {
        startPage.openURL(arg0);
    }

    @Then("Start page is opened")
    public void pageIsOpened() {
        startPage.isInitialized();
    }

    @And("click button")
    public void clickButton() {
        startPage.clickButton();
    }

    @And("enter your name {string} to field {string}")
    public void enterYourNameToField(String name, String field) {
        startPage.setTextInLabel(name, field);
    }

    @And("hover mouseCursor to button enter")
    public void hoverMouseCursorToButtonEnter() {
        startPage.goToButtonEnter();
    }

    @And("enter your login {string} and password {string}")
    public void enterYourLoginAndPassword(String login, String password) {
        startPage.setEnterLoginAndPassword(login, password);
    }

    @And("click button Enter")
    public void clickButtonEnter() {
        startPage.pushEnterButton();
    }

    @And("select remember me checkBox")
    public void selectCheckBox() {
        startPage.selectRememberMeCheckBox();
    }

    @Then("E-mail или пароль указан не верно")
    public void isEmailOrPasswordCorrect() {
        startPage.isElementDisplayed();
    }
}