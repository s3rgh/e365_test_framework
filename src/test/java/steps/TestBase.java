package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestBase {

    //protected static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();
    protected static WebDriver webDriver;

    public void initialize() {

        /*if (threadLocalWebDriver.get() != null) {
            webDriver = threadLocalWebDriver.get();
            return;
        }*/

        if (webDriver != null) {
            return;
        }

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        //threadLocalWebDriver.set(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //options for headless start
        /*
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        webDriver = new ChromeDriver(options);
        */

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> webDriver.quit())
        );
    }

    public void tearDown() {
       // webDriver.quit();
    }
}