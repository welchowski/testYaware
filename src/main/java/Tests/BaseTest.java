package Tests;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static Tests.StaffBuilder.pathFile;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    UsersPage usersPage;
    InvitePage invitePage;
    DeleteStaff deleteStaff;
    testpage testpage;

    @BeforeTest
    public void preConditions() {
        StaffBuilder staffBuilder = new StaffBuilder();
        staffBuilder.builderCVS();

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        usersPage = PageFactory.initElements(driver, UsersPage.class);
        invitePage = PageFactory.initElements(driver, InvitePage.class);
        deleteStaff = PageFactory.initElements(driver, DeleteStaff.class);
        testpage = PageFactory.initElements(driver, testpage.class);

        driver.get("https://app.yaware.com.ua/");
    }

    @AfterTest
    public void after() {
        driver.quit();
    }

    @AfterClass
    public void afterClas() {

        try {
            Files.delete(Paths.get(pathFile));
            System.out.println("staffData.csv is deleted");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
