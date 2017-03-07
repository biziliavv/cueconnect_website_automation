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
    public void correctLogin() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        LoginPage loginPage = homePage.goToLoginPage();
        WebElement current_frame = getDriver().findElement(By.id("cue-app"));
        getDriver().switchTo().frame(current_frame);
        loginPage.loginWithValidCredentials();

    }

    @Test
    public void loginCheckEmptyFields() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        LoginPage loginPage = homePage.goToLoginPage();
        WebElement current_frame = getDriver().findElement(By.id("cue-app"));
        getDriver().switchTo().frame(current_frame);
        loginPage.login_check("", "");
        Assert.assertEquals(loginPage.getValidationMessage("email"), "Your email is required");
        Assert.assertEquals(loginPage.getValidationMessage("password"), "A password is required");


    }
    @Test
    public void loginFormCheckingWrongEmail() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        LoginPage loginPage = homePage.goToLoginPage();
        WebElement current_frame = getDriver().findElement(By.id("cue-app"));
        getDriver().switchTo().frame(current_frame);
        loginPage.login_check("test", "");
        Assert.assertEquals(loginPage.getValidationMessage("email"), "Invalid email address");

    }
    @Test
    public void forgotPasswordEmptyFields() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        LoginPage loginPage = homePage.goToLoginPage();
        WebElement current_frame = getDriver().findElement(By.id("cue-app"));
        getDriver().switchTo().frame(current_frame);
        loginPage.forgotPasswordOpening();
        loginPage.fillingInForgottPasswordForm("", "");
        Assert.assertEquals("Your email is required", loginPage.getForgotEmailValidationMessage(""));
        Assert.assertEquals("Please confirm your email", loginPage.getForgotEmailValidationMessage("confirm-"));
    }
    @Test
    public void forgotPasswordWrongEmail() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        LoginPage loginPage = homePage.goToLoginPage();
        WebElement current_frame = getDriver().findElement(By.id("cue-app"));
        getDriver().switchTo().frame(current_frame);
        loginPage.forgotPasswordOpening();
        loginPage.fillingInForgottPasswordForm("test", "");
        Assert.assertEquals("Invalid email address", loginPage.getForgotEmailValidationMessage(""));
    }
    @Test
    public void forgotPasswordDoenMatchEmails() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        LoginPage loginPage = homePage.goToLoginPage();
        WebElement current_frame = getDriver().findElement(By.id("cue-app"));
        getDriver().switchTo().frame(current_frame);
        loginPage.forgotPasswordOpening();
        loginPage.fillingInForgottPasswordForm("test@test.com", "test1@test.com");
        Assert.assertEquals("Emails don't match", loginPage.getForgotEmailValidationMessage("confirm-"));
    }
}
