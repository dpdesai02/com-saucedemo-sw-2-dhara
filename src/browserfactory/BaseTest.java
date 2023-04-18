package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static String baseUrl = "https://www.saucedemo.com/ ";
    public static WebDriver driver;

    //creating method with parameter

    public static void openBrowser(String baseUrl) {
        driver = new ChromeDriver();
        //launch the url

        driver.get(baseUrl);//pass the baseUrl
        driver.manage().window().maximize();
        //implicit Timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    public void closeBrowser() {
        //clos all selenium instance browser
        driver.quit();
    }
}
