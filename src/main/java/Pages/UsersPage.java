package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Tests.BaseFunc.waitMs;

public class UsersPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//a[@href='/user-management']")
    private WebElement employees;
    @FindBy(xpath = "//a[@href='#inactive-users']")
    private WebElement noActEmployees;
    @FindBy(id = "button-1096-btnIconEl")
    private WebElement importStaff;
    @FindBy(id = "file")
    private WebElement file;
    @FindBy(id = "yaware-modal-button-0")
    private WebElement importButton;
    @FindBy(className = "toast-message")
    private WebElement toast;
    @FindBy(className = "username")
    private WebElement userName;

    String messageToast;

    public UsersPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void uploadStaff() {
        employees.click();
        noActEmployees.click();
        importStaff.click();
        file.sendKeys("C:\\Users\\Public\\data\\staffData.csv");
        importButton.click();
        waitMs(2000);
        importButton.click();
        wait.until(ExpectedConditions.visibilityOf(toast));
    }

    public String getMessageToast() {
        messageToast = toast.getText();
        return messageToast;
    }
}
