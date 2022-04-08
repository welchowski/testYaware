package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class MainTest extends BaseTest {
    static String passwordStr = "Kc5a6kdxy8URGTr";
    static String emailStr = "rrrezera@gmail.com";

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.enterEmailPassword(emailStr, passwordStr);
        loginPage.login();
        Assert.assertEquals(loginPage.userNameStr, "Svarch Yan");
    }

    @Test(priority = 2)
    public void loafStaffTest() throws InterruptedException {
        usersPage.uploadStaff();
        Assert.assertEquals(usersPage.getMessageToast(), "Готово");
    }

    @Test(priority = 3)
    public void inviteTest() throws InterruptedException, IOException, UnsupportedFlavorException {
        invitePage.sendEmail();
        Assert.assertEquals(invitePage.getMessageToast(), "Пользователь был успешно приглашен.", "Error after sending invite");

        invitePage.checkDateInvitation();
        Assert.assertEquals(invitePage.dateSendingEmail.substring(0, 9), invitePage.curentDate, "Date doesn't same");

        invitePage.checkLinkWithEmployeeEmail();
        Assert.assertEquals(invitePage.checkEmail, true, "Email is absent in download link");


        invitePage.unSendEmail();
        Assert.assertNotEquals(invitePage.email, invitePage.emailAfterDeleting, "Employee is not deleted");
    }

    @Test(priority = 4)
    public void deleteStaffTest() throws InterruptedException, IOException, UnsupportedFlavorException {
        deleteStaff.deleteStaff();
        Assert.assertEquals(deleteStaff.getMessageToast(), "Готово", "Error of deleting");
    }
}
