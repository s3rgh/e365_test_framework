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

    @Then("Открыта главная страница")
    public void isMainPageOpened() {
        mainPage.isInitialized();
    }

    @And("Нажать кнопку профиля")
    public void clickProfileButton() {
        mainPage.goToButtonUserProfile();
    }

    @And("Профиль диалог открыт")
    public void isProfilePopOverOpen() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.isProfilePopOverDisplayed();

    }

    @And("Нажать кнопку {string}")
    public void clickButton(String button) {
        mainPage.clickButtonOnUserProfilePopOver(button);
    }

    @When("открыт Exit Dialog")
    public void isExitDialogOpen() {
        mainPage.isElementDisplayed();
    }

    @And("Нажать отмена")
    public void clickDecline() {
        mainPage.declineExitDialog();
    }

    @And("Нажать ОК")
    public void clickOk() {
        mainPage.submitExitDialog();
    }
}