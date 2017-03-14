package pageobjects;

import org.openqa.selenium.*;
import org.testng.Assert;
import pageobjects.About.Careers;
import pageobjects.About.Contact;
import pageobjects.Blog.BlogPage;
import pageobjects.Blog.CueAcademyPage;
import pageobjects.Blog.ResourcesPage;

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
        String env=prop.getProperty("prod_env");

        getDriver().get(env);
        String resolution=prop.getProperty("desktop_res");
        String[] parts = resolution.split("x");

        // Screen resolution
        Dimension screenRes = new Dimension(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));

        // Set browser resolution
        getDriver().manage().window().setSize(screenRes);
    }


    public RequestDemoPage goToRequestDemoPage()  {
        WebElement requestDemoButton = getDriver().findElement(By.xpath("//span[text()='Request a Demo']"));
        if (requestDemoButton.isDisplayed()){
            requestDemoButton.click();

        }
        else {
            waitFor(2);
            hamburgerMenuClicking();
            WebElement requestDemoTab = getDriver().findElement(By.xpath("//li[@class='is-btn menu-item menu-item-type-post_type menu-item-object-page']/a[text()='REQUEST A DEMO']"));
            fluentWaitforElement(requestDemoTab, 10, 10);
            requestDemoTab.click();
            waitFor(8);
        }

        return new RequestDemoPage();
    }
    public BlogPage goToBlogPage()  {
        waitFor(3);
        movingToMenuElement("Blog", "Blog");
        waitFor(3);


        return new BlogPage();
    }

    public SupportPage goToSupportPage()  {

        getDriver().findElement(By.xpath("//span[text()='Support']")).click();
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        return new SupportPage();
    }
    public FeaturesPage goToFeaturesPage()  {


        WebElement featuresButton = getDriver().findElement(By.xpath("//span[text()='Features']"));
        if (featuresButton.isDisplayed()){
        featuresButton.click();}
        else {
            hamburgerMenuClicking();
            waitFor(4);
            WebElement featuresTab = getDriver().findElement(By.xpath("//li[@class='menu-item menu-item-type-post_type menu-item-object-page']/a[text()='FEATURES']"));
            fluentWaitforElement(featuresTab, 10, 5);
            featuresTab.click();
            waitFor(2);
        }
        return new FeaturesPage();
    }
    public BenefitsPage goToBenefitsPage()  {


        WebElement benefitsButton = getDriver().findElement(By.xpath("//span[text()='Benefits']"));
        if (benefitsButton.isDisplayed()){
            benefitsButton.click();}
        else {
            hamburgerMenuClicking();
            waitFor(4);
            WebElement benefitsTab = getDriver().findElement(By.xpath("//li[@class='menu-item menu-item-type-post_type menu-item-object-page']/a[text()='BENEFITS']"));
            fluentWaitforElement(benefitsTab, 10, 5);
            benefitsTab.click();
            waitFor(2);
        }


        return new BenefitsPage();
    }

    public Careers goToCareers()  {
        waitFor(3);

        movingToMenuElement("About", "Careers");
        return new Careers();
    }

    public Contact goToContact()  {
        waitFor(3);
        movingToMenuElement("About", "Contact");
        return new Contact();
    }
    public ResourcesPage goToResources()  {
        waitFor(6);
        movingToMenuElement("Blog", "Resources");
        return new ResourcesPage();
    }

    public CueAcademyPage goToCueAcademy()  {
        waitFor(4);
        movingToMenuElement("Blog", "Cue Academy");
        return new CueAcademyPage();
    }
    public LoginPage goToLoginPage()  {


            WebElement loginButton = getDriver().findElement(By.xpath("//span[text()='Log In']"));
        if (loginButton.isDisplayed()){
            loginButton.click();}
        else if (getDriver().findElement(By.xpath("//div[@class='mobile-navigation-toggle']")).isDisplayed()){

            getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            hamburgerMenuClicking();
            waitFor(4);
            WebElement benefitsTab = getDriver().findElement(By.xpath("//ul[@class='mobile-header-menu']//li/a[text()='LOG IN']"));
            fluentWaitforElement(benefitsTab, 10, 5);
            benefitsTab.click();
            waitFor(2);
        }
        return new LoginPage();
    }







    public void typingEmailAndclickOnRequestDemoButton(String emailValue)  {

        WebElement emailField = getDriver().findElement(By.id("merchant_email"));
        emailField.sendKeys(emailValue);
        WebElement requestDemoButton = getDriver().findElement(By.xpath("//input[@type='submit']"));
        requestDemoButton.click();
        waitFor(2);
    }


    public void sendMeUpdatesVerifying(String emailValue)  {

        WebElement emailForSendUpdateField = getDriver().findElement(By.xpath("//input[@name='email']"));
        waitAndClick(emailForSendUpdateField);
        waitFor(5);
        emailForSendUpdateField.sendKeys(emailValue);

        scrollDown();
        WebElement sendButton = getDriver().findElement(By.xpath("//input[@value='Send me Updates'][@type='submit']"));
        sendButton.click();
        waitFor(5);
    }



    public String getEmptyEmailMessage() {

        return getDriver().findElement(By.xpath("//label[@class='visible']")).getText();
    }

    public void clickOnBottomMenuElement(String el, String title)  {

        WebElement bottomElement = getDriver().findElement(By.xpath("//a[@class='cue-main-footer-link white'][text()='"+el+"']"));
        bottomElement.click();
        Assert.assertEquals(this.getTitle(), title);
        waitFor(2);
        getDriver().navigate().back();
        waitFor(2);

    }

    public void getStartedFree()  {

        WebElement getStartedFree = getDriver().findElement(By.xpath("//a[@class='cue-main-footer-link white'][text()='Get Started Free']"));
        waitAndClick(getStartedFree);
        waitFor(3);
    }

    public String storeInformationPageTitle(){
        return getDriver().findElement(By.xpath("//div[@class='cue-ro-title']")).getText();
    }

    public void singleClickOnTopMenuItem(String buttonName)  {

        WebElement topMenuButton = getDriver().findElement(By.xpath("//span[@class='item-title'][text()='"+buttonName+"']"));
        if (topMenuButton.isDisplayed()) {
            topMenuButton.click();
            waitFor(3);
        } else {
            hamburgerMenuClicking();
            WebElement sideMenuButton = getDriver().findElement(By.xpath("//li/a[text()='"+buttonName.toUpperCase()+"']"));
            fluentWaitforElement(sideMenuButton, 10,10);
            sideMenuButton.click();
        }

    }

    public void singleClickOnLoginButton()  {
        waitFor(3);
        String link = "#cue-merchant-login";
        WebElement loginButton = getDriver().findElement(By.xpath("//a[@href='"+link+"']"));
        loginButton.click();
        waitFor(5);

        getDriver().switchTo().frame("cue-app");

    }

    public String getLoginTitle() {
        return getDriver().findElement(By.xpath("//a[@class='blue-link']")).getText();
    }

    public String getSupportPageTitle() {

        return getDriver().findElement(By.xpath("//h1[@class='search-title']")).getText();
    }
    public void openingVideo(){
        WebElement video_icon = getDriver().findElement(By.xpath("//a[@href='#video-popup']"));
        video_icon.click();
    }


}








