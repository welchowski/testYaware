package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Tests.BaseFunc.waitMs;

public class InvitePage {
    private WebDriver driver;
    private WebDriverWait wait;
    public String email;
    public String curentDate;
    public Boolean checkEmail;
    public String dateSendingEmail;
    public String emailAfterDeleting;
    String messageToast;
    String clipBoardlink;

    SimpleDateFormat dateFormat = new SimpleDateFormat("dyyyykkmm");

    @FindBy(xpath = "//a[@title='Добавить сотрудника']")
    private WebElement addStaff;
    @FindBy(xpath = "(//div[@class='x-grid-cell-inner '])[3]")
    private WebElement dataEmailsend;
    @FindBy(xpath = "(//div[@class='x-grid-cell-inner '])[2]")
    private WebElement emailInvitation;
    @FindBy(xpath = "(//a[@class='grid-icon fa fa-link'])[1]")
    private WebElement emailLink;
    @FindBy(id = "windows-download-link")
    private WebElement linkWindows;
    @FindBy(className = "toast-message")
    private WebElement toast;
    @FindBy(xpath = "(//a[@class='grid-icon grid-icon-send-invite'])[1]")
    private WebElement sendEmailButton;
    @FindBy(xpath = "//a[@class=\"grid-icon grid-icon-hidden-invite\"]")
    private WebElement deleteInvite;
    @FindBy(id = "yaware-modal-button-0")
    private WebElement deleteButton;

    Boolean checkingEmailCorrect(String clipBoardlink, String email) {
        clipBoardlink = clipBoardlink.replace("%40", "@");
        return clipBoardlink.contains(email);
    }

    public String getClipBoard() throws IOException, UnsupportedFlavorException {
        Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
        DataFlavor dataFlavor = DataFlavor.stringFlavor;
        String str;
        str = clipBoard.getData(dataFlavor).toString();
        return str;
    }

    public String getMessageToast() {
        messageToast = toast.getText();
        return messageToast;
    }

    public InvitePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void sendEmail() {
        addStaff.click();
        sendEmailButton.click();
        curentDate = dateFormat.format(new Date());
        wait.until(ExpectedConditions.visibilityOf(toast));
    }

    public void checkDateInvitation() {
        waitMs(3000);
        dateSendingEmail = dataEmailsend.getText();
        dateSendingEmail = dateSendingEmail.replaceAll("[^0-9]", "");
        dateSendingEmail = dateSendingEmail.substring(0,dateSendingEmail.length()-2);

    }

    public void checkLinkWithEmployeeEmail() throws IOException, UnsupportedFlavorException {
        emailLink.click();
        linkWindows.click();
        clipBoardlink = getClipBoard();
        checkEmail = checkingEmailCorrect(clipBoardlink, emailInvitation.getText());
    }

    public void unSendEmail() {
        email = emailInvitation.getText();
        deleteInvite.click();
        deleteButton.click();
        waitMs(3000);
        emailAfterDeleting = emailInvitation.getText();
    }
}
