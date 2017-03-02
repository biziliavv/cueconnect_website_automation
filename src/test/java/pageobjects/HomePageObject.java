package pageobjects;

import org.openqa.selenium.*;
import org.testng.Assert;
import pageobjects.About.Careers;
import pageobjects.About.Contact;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/23/17.
 */
public class HomePageObject extends BaseObjectPage {



    public HomePageObject() throws IOException {
        super(getDriver());
        FileInputStream inStream;
        inStream = new FileInputStream(new File("properties/BaseProperties.properties"));
        Properties prop = new Properties();
        prop.load(inStream);
        String qa_env=prop.getProperty("qa_env");

        getDriver().get(qa_env);
    }


    public RequestDemoPage goToRequestDemoPage() throws InterruptedException {
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//span[text()='Request a Demo']")).click();
        return new RequestDemoPage();
    }

    public SupportPage goToSupportPage() throws InterruptedException {

        getDriver().findElement(By.xpath("//span[text()='Support']")).click();
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new SupportPage();
    }
    public FeaturesPage goToFeaturesPage() throws InterruptedException {


        WebElement featuresButton = getDriver().findElement(By.xpath("//span[text()='Features']"));
        featuresButton.click();
        return new FeaturesPage();
    }

    public Careers goToCareers() throws InterruptedException {
        Thread.sleep(3000);

        movingToMenuElement("About", "Careers");
        return new Careers();
    }

    public Contact goToContact() throws InterruptedException {
        Thread.sleep(3000);

        movingToMenuElement("About", "Contact");
        return new Contact();
    }








    public void typingEmailAndclickOnRequestDemoButton(String emailValue) throws InterruptedException {

        WebElement emailField = getDriver().findElement(By.id("merchant_email"));
        emailField.sendKeys(emailValue);
        WebElement requestDemoButton = getDriver().findElement(By.xpath("//input[@type='submit']"));
        requestDemoButton.click();
        Thread.sleep(2000);
    }


    public void sendMeUpdatesVerifying(String emailValue) throws InterruptedException {

        WebElement emailForSendUpdateField = getDriver().findElement(By.xpath("//input[@name='email']"));
        waitAndClick(emailForSendUpdateField);
        Thread.sleep(5000);
        emailForSendUpdateField.sendKeys(emailValue);

        scrollDown();
        WebElement sendButton = getDriver().findElement(By.xpath("//input[@value='Send me Updates'][@type='submit']"));
        sendButton.click();
        Thread.sleep(5000);
    }

    public String getValidEmailMessage() {

        return getDriver().findElement(By.xpath("//div[@class='submitted-message']")).getText();
    }

    public String getEmptyEmailMessage() {

        return getDriver().findElement(By.xpath("//label[@class='visible']")).getText();
    }

    public void clickOnBottomMenuElement(String el, String title) throws InterruptedException {

        WebElement bottomElement = getDriver().findElement(By.xpath("//a[@class='cue-main-footer-link white'][text()='"+el+"']"));
        bottomElement.click();
        Assert.assertEquals(this.getTitle(), title);
        Thread.sleep(2000);
        getDriver().navigate().back();
        Thread.sleep(2000);

    }

    public void getStartedFree() throws InterruptedException {

        WebElement getStartedFree = getDriver().findElement(By.xpath("//a[text()='Get Started Free']"));
        getStartedFree.click();
        Thread.sleep(3000);
    }

    public String storeInformationPageTitle(){
        return getDriver().findElement(By.xpath("//div[@class='cue-ro-title']")).getText();
    }

    public void singleClickOnTopMenuItem(String buttonName) throws InterruptedException {

        WebElement topMenuButton = getDriver().findElement(By.xpath("//span[@class='item-title'][text()='"+buttonName+"']"));
        topMenuButton.click();
        Thread.sleep(3000);

    }

    public void singleClickOnLoginButton() throws InterruptedException {
        Thread.sleep(3000);
        String link = "#cue-merchant-login";
        WebElement loginButton = getDriver().findElement(By.xpath("//a[@href='"+link+"']/span[@class='item-title']"));
        loginButton.click();
        Thread.sleep(5000);

        getDriver().switchTo().frame("cue-app");

    }

    public String getLoginTitle() {
        return getDriver().findElement(By.xpath("//a[@class='blue-link']")).getText();
    }

    public String getSupportPageTitle() {

        return getDriver().findElement(By.xpath("//h1[@class='search-title']")).getText();
    }

}








