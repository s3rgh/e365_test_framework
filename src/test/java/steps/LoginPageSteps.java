package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import pages.LoginPage;

public class LoginPageSteps extends TestBase {

    LoginPage loginPage;

    @Before
    public void start() {
        initialize();
        loginPage = new LoginPage(webDriver);
    }

    @After
    public void stop() {
        tearDown();
    }

    @Then("Button {string} is displayed")
    public void isButtonAvailable(String string) {
        loginPage.isButtonAvailable(string);
    }

    @Then("Login title text is displayed")
    public void loginTitleTextIsDisplayed() {
        loginPage.isTitleAvailable();
    }
}