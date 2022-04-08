package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Tests.BaseFunc.waitMs;

public class DeleteStaff {
    private WebDriver driver;
    private WebDriverWait wait;
    String messageToast;

    @FindBy(xpath = "//a[@href='/user-management']")
    private WebElement employee;
    @FindBy(xpath = "//a[@href=\"#active-users\"]")
    private WebElement actEmployees;
    @FindBy(xpath = "(//span[@class=\"x-column-header-text\"])[1]")
    private WebElement checkDelete;
    @FindBy(id = "button-1046-btnIconEl")
    private WebElement deleteActiveStaffIcon;
    @FindBy(id = "yaware-modal-button-0")
    private WebElement deleteActiveStaffButtonn;
    @FindBy(className = "toast-message")
    private WebElement toast;

    public DeleteStaff(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void deleteStaff() {
        employee.click();
        wait.until(ExpectedConditions.visibilityOf(checkDelete));
        waitMs(2000);
        checkDelete.click();
        deleteActiveStaffIcon.click();
        deleteActiveStaffButtonn.click();
    }

    public String getMessageToast() {
        messageToast = toast.getText();
        return messageToast;
    }
}
