package pageobjects;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/7/17.
 */
public class LoginPage extends BaseObjectPage {
    public LoginPage(){
        super(getDriver());
    }
    public void loginWithValidCredentials() throws IOException {
        String currentLink = getDriver().getCurrentUrl();
        WebElement emailField = getDriver().findElement(By.id("signin-email"));
        WebElement passwordField = getDriver().findElement(By.id("signin-password"));
        FileInputStream inStream;
        inStream = new FileInputStream(new File("properties/BaseProperties.properties"));
        Properties prop = new Properties();
        prop.load(inStream);
        if (currentLink.contains("cueconnect.com")){
            String prod_env_email=prop.getProperty("prod_env_email");
            String prod_env_password=prop.getProperty("prod_env_password");
            emailField.sendKeys(prod_env_email);
            passwordField.sendKeys(prod_env_password);
        } else {
            String qa_env_email=prop.getProperty("qa_env_email");
            String qa_env_password=prop.getProperty("qa_env_password");
            emailField.sendKeys(qa_env_email);
            passwordField.sendKeys(qa_env_password);

        }
        String username = "cueconnect";
        String password = "d5ertf5";

        WebElement signinButton = getDriver().findElement(By.id("signin-submit"));
        signinButton.click();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement log_out_button = getDriver().findElement(By.xpath("//button[text()='LOG OUT']"));
        fluentWaitforElement(log_out_button, 10, 10);
        isElementDisplayed(log_out_button);

    }
    public void login_check(String user_email, String user_password){
        WebElement emailField = getDriver().findElement(By.id("signin-email"));
        WebElement passwordField = getDriver().findElement(By.id("signin-password"));
        emailField.sendKeys(user_email);
        passwordField.sendKeys(user_password);
        WebElement signinButton = getDriver().findElement(By.id("signin-submit"));
        signinButton.click();

    }
    public String getValidationMessage(String fieldName){
        return getDriver().findElement(By.id("signin-"+fieldName+"-message")).getText();

    }
    public void forgotPasswordOpening(){
        WebElement forgottPasswordLink = getDriver().findElement(By.id("forgot"));
        forgottPasswordLink.click();
    }
    public void fillingInForgottPasswordForm(String forgotEmail, String confirmForgotEmail)  {
        WebElement firstEmail = getDriver().findElement(By.id("forgot-email"));
        firstEmail.sendKeys(forgotEmail);
        WebElement confirmEmail = getDriver().findElement(By.id("forgot-email-confirm"));
        confirmEmail.sendKeys(confirmForgotEmail);
        WebElement sendResetCode = getDriver().findElement(By.id("forgot-pwd-submit"));
        sendResetCode.click();
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    public String getForgotEmailValidationMessage(String fieldName){
        return getDriver().findElement(By.id("forgot-email-"+fieldName+"message")).getText();
    }

}
