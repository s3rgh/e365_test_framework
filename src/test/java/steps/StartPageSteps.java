package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import pages.StartPage;

public class StartPageSteps extends TestBase {

    StartPage startPage;

    @Before
    public void start() {
        initialize();
        startPage = PageFactory.initElements(webDriver, StartPage.class);
    }

    @After
    public void stop() {
        tearDown();
    }

    @Given("open start page {string}")
    public void openPage(String arg0) {
        startPage.openURL(arg0);
    }

    @Then("page is opened")
    public void pageIsOpened() {
        startPage.isInitialized();
    }

    @And("click button")
    public void clickButton() {
        startPage.clickButton();
    }

    @And("enter your name {string} to field {string}")
    public void enterYourNameToField(String arg0, String arg1) {
        startPage.setTextInLabel(arg0, arg1);
    }
}