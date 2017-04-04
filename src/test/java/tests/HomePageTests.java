package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;


import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.driver;
import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/23/17.
 */
public class HomePageTests extends SeleniumBaseTest {











    @Test(groups = "mobile")
    public void bscrollingToTransformTraffic() throws IOException {
        String link = "/benefits/#transform-traffic";
        HomePageObject homePage = new HomePageObject();
        waitFor(2);
        homePage.scrollUp(0, -1800);
        waitFor(2);
        WebElement el = getDriver().findElement(By.xpath("//a[@href='" + link + "']"));
        waitFor(2);
        el.click();
        Assert.assertEquals("https://cueconnect.com/benefits/#transform-traffic", getDriver().getCurrentUrl());

    }

    @Test(groups = "mobile")
    public void scrollingToRetargetShoppers() throws IOException {
        String link = "/benefits/#retarget-shoppers";
        HomePageObject homePage = new HomePageObject();
        waitFor(2);
        homePage.scrollUp(0, -2);
        waitFor(2);
        WebElement el = getDriver().findElement(By.xpath("//a[@class='cta-bottom'][@href='"+link +"']"));
        waitFor(2);
        el.click();
        Assert.assertEquals("https://cueconnect.com/benefits/#retarget-shoppers", getDriver().getCurrentUrl());

    }

    @Test(groups = "mobile")
    public void scrollingToDriveEcommerce() throws IOException {
        String link = "/benefits/#drive-ecommerce";
        HomePageObject homePage = new HomePageObject();
        waitFor(2);
        homePage.scrollUp(0, -1900);
        waitFor(2);
        WebElement el = getDriver().findElement(By.xpath("//p/a[@class='cta-bottom'][@href='" + link + "']"));
        waitFor(2);
        el.click();
        Assert.assertEquals("https://cueconnect.com/benefits/#drive-ecommerce", getDriver().getCurrentUrl());

    }

    @Test(groups = "mobile")
    public void scrollingToCueConnectBlog() throws IOException {
        String link = "/blog";
        HomePageObject homePage = new HomePageObject();
        waitFor(2);
        homePage.scrollUp(0, -800);
        waitFor(2);
       /* WebElement currentFrame = getDriver().findElement(By.xpath("//iframe[@src='about:blank']"));
        getDriver().switchTo().frame(currentFrame);
        waitFor(2);*/
        WebElement el = getDriver().findElement(By.xpath("//div[@id='wrap']//p[@class='call-to-action']/a[@href='"+link+"']"));
        waitFor(2);
        el.click();
        Assert.assertEquals("https://cueconnect.com/blog/", getDriver().getCurrentUrl());
        Assert.assertEquals("Cue Connect Blog", homePage.getTitle());

    }

    @Test(groups = "mobile")
    public void bscrollingToResources() throws IOException {
        String link = "https://cueconnect.com/resources/";
        HomePageObject homePage = new HomePageObject();
        waitFor(2);
        homePage.scrollUp(0, -500);
        waitFor(2);
        WebElement el = getDriver().findElement(By.xpath("//p[@class='call-to-action']/a[@href='"+link+"']"));
        waitFor(2);
        el.click();
        Assert.assertEquals("https://cueconnect.com/resources/", getDriver().getCurrentUrl());
        Assert.assertEquals("Marketing Guides", homePage.getTitle());

    }


    @Test(groups = "mobile")
    public void typingValidEmailAndClickRequestDemo() throws IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.typingEmailAndclickOnRequestDemoButton("test@test.com");
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", homePage.getTitle());
        Assert.assertEquals("https://cueconnect.com/request-a-demo/?merchant_email=test%40test.com", getDriver().getCurrentUrl());

    }

    @Test(groups = "mobile")
    public void emptyEmailAndClickRequestDemo() throws IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.typingEmailAndclickOnRequestDemoButton("");
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", homePage.getTitle());
        Assert.assertEquals("https://cueconnect.com/request-a-demo/?merchant_email=", getDriver().getCurrentUrl());

    }

    @Test(groups = "mobile")
    public void notEmailFormatAndClickRequestDemo() throws IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.typingEmailAndclickOnRequestDemoButton("test");
        Assert.assertEquals("https://cueconnect.com/", getDriver().getCurrentUrl());
    }

    @Test(groups = "positive")
    public void sendingUpdatesToValidEmail() throws IOException {

        HomePageObject homePage = new HomePageObject();
        waitFor(4);
        homePage.sendMeUpdatesVerifying("jsmith@gmail.com");
        waitFor(4);
        Assert.assertEquals("Thank you for subscribing!", homePage.getValidEmailMessage());


    }

    @Test(groups = "mobile")
    public void sendingUpdatesEmptyEmail() throws IOException {

        HomePageObject homePage = new HomePageObject();
        homePage.sendMeUpdatesVerifying("");
        //Assert.assertEquals("Email is required", homePage.getEmptyEmailMessage());

    }

    @Test(groups = "mobile")
    public void sendingUpdatesIncorrectEmail() throws IOException {

        HomePageObject homePage = new HomePageObject();
        homePage.sendMeUpdatesVerifying("test");
       // Assert.assertEquals("Email must be formatted correctly.", homePage.getEmptyEmailMessage());

    }
    @Test(groups = "negative")
    public void sendingUpdatesIncorrectEmailWithAt() throws IOException {

        HomePageObject homePage = new HomePageObject();
        homePage.sendMeUpdatesVerifying("test@test");
       // Assert.assertEquals("Please enter a valid email address.", homePage.getEmptyEmailMessage());

    }

    @Test(groups = "mobile")
    public void bottomMenuVerifying() throws IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.clickOnBottomMenuElement("Cueconnect Features", "Build Customer Relationships That Last Forever");
        homePage.clickOnBottomMenuElement("Resources", "Marketing Guides");
        homePage.clickOnBottomMenuElement("Cueconnect Benefits", "Grow Conversions Increase Sales");
        homePage.clickOnBottomMenuElement("Blog", "Cue Connect Blog");
        homePage.clickOnBottomMenuElement("Privacy", "Privacy Policy");
        homePage.clickOnBottomMenuElement("Terms", "Terms and Conditions");

    }

    @Test(groups = "mobile")
    public void getStartedFreeChecking() throws IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.getStartedFree();
        Assert.assertEquals("Store Information", homePage.storeInformationPageTitle());

    }
    @Test(groups = "mobile")
    public void videoOpening() throws IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.openingVideo();
        waitFor(5);
        WebElement frame = getDriver().findElement(By.xpath("//body/div[1]/iframe"));
        getDriver().switchTo().frame(frame);

    }
}
