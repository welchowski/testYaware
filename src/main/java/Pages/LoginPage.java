package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {


    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-submit")
    private WebElement login;
    @FindBy(className = "yaware-cookie-notice-link")
    private WebElement cookie;
    @FindBy(className = "username")
    private WebElement userName;

    private WebDriver driver;
    private WebDriverWait wait;
    public String userNameStr;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void enterEmailPassword(String emailS, String passwordS) {
        cookie.click();
        email.sendKeys(emailS);
        password.sendKeys(passwordS);
    }

    public void login() {
        login.click();
        userNameStr = userName.getText();
    }
}





