package Pages;

import Tests.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;

    @BeforeTest
    public void preconditions() {
        StaffBuilder staffBuilder = new StaffBuilder();
        staffBuilder.builderCVS();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://app.yaware.com.ua/");
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}
