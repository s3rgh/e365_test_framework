package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"},
                glue = {"steps"},
                plugin = { "json:target/cucumber.json", "pretty", "html:target/html-report/cucumber-html-report.html"})

public class RunTest {

    // TODO: проверить и переписать веб-элементы и локаторы
    // TODO: исправить степы в user_authorization.feature, которые некорректно отрабатывают
    // TODO: прикрутить selenoid
    // TODO: разобраться с firefox
}
