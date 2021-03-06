package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import pageobjects.LoginPage;
import setup.SeleniumBaseTest;
import static setup.SeleniumDriver.getDriver;
import java.io.IOException;

/**
 * Created by vitaliybizilia on 3/7/17.
 */
public class LoginPageTests extends SeleniumBaseTest {

    @Test
    public void correctLogin() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(4);
        LoginPage loginPage = homePage.goToLoginPage();
        WebElement current_frame = getDriver().findElement(By.id("cue-app"));
        getDriver().switchTo().frame(current_frame);
        loginPage.loginWithValidCredentials();

    }

    @Test
    public void loginCheckEmptyFields() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        LoginPage loginPage = homePage.goToLoginPage();
        WebElement current_frame = getDriver().findElement(By.id("cue-app"));
        getDriver().switchTo().frame(current_frame);
        loginPage.login_check("", "");
        Assert.assertEquals(loginPage.getValidationMessage("email"), "Your email is required");
        Assert.assertEquals(loginPage.getValidationMessage("password"), "A password is required");


    }
    @Test
    public void loginFormCheckingWrongEmail() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        LoginPage loginPage = homePage.goToLoginPage();
        WebElement current_frame = getDriver().findElement(By.id("cue-app"));
        getDriver().switchTo().frame(current_frame);
        loginPage.login_check("test", "");
        Assert.assertEquals(loginPage.getValidationMessage("email"), "Invalid email address");

    }
    @Test
    public void forgotPasswordEmptyFields() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        LoginPage loginPage = homePage.goToLoginPage();
        WebElement current_frame = getDriver().findElement(By.id("cue-app"));
        getDriver().switchTo().frame(current_frame);
        loginPage.forgotPasswordOpening();
        loginPage.fillingInForgottPasswordForm("", "");
        Assert.assertEquals("Your email is required", loginPage.getForgotEmailValidationMessage(""));
        Assert.assertEquals("Please confirm your email", loginPage.getForgotEmailValidationMessage("confirm-"));
    }
    @Test
    public void forgotPasswordWrongEmail() throws IOException {
        HomePageObject homePage = new HomePageObject();
        LoginPage loginPage = homePage.goToLoginPage();
        WebElement current_frame = getDriver().findElement(By.id("cue-app"));
        getDriver().switchTo().frame(current_frame);
        loginPage.forgotPasswordOpening();
        loginPage.fillingInForgottPasswordForm("test", "");
        Assert.assertEquals("Invalid email address", loginPage.getForgotEmailValidationMessage(""));
    }
   /* @Test
    public void forgotPasswordDoesntMatchEmails() throws IOException {
        HomePageObject homePage = new HomePageObject();
        LoginPage loginPage = homePage.goToLoginPage();
        WebElement current_frame = getDriver().findElement(By.id("cue-app"));
        getDriver().switchTo().frame(current_frame);
        loginPage.forgotPasswordOpening();
        loginPage.fillingInForgottPasswordForm("test@test.com", "test@tetetet.xom");
        Assert.assertEquals("Emails don't match", loginPage.getForgotEmailValidationMessage("confirm-"));
    }*/
}
