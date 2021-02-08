package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static WebDriver webDriver;

    public void initialize() {

        if (webDriver != null) {
            return;
        }

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> webDriver.quit())
        );
    }

    public void tearDown() {
       // webDriver.quit();
    }
}