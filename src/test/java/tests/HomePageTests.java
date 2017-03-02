package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
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

    @Test(groups = "positive")
    public void movingToFeaturesFirstHalfMenu() throws InterruptedException, FindFailed, IOException {

        HomePageObject homePage = new HomePageObject();

        homePage.movingToMenuElement("Features", "Reporting Suite");
        Assert.assertEquals("https://cueconnect.net/features/#reporting-suite", getDriver().getCurrentUrl());
        homePage.movingToMenuElement("Features", "Share Tools");
        Assert.assertEquals("https://cueconnect.net/features/#share-tools", getDriver().getCurrentUrl());
    }
    @Test(groups = "positive")
    public void movingToFeaturesSecondHalfMenu() throws InterruptedException, FindFailed, IOException {

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("Features", "My List");
        Assert.assertEquals("https://cueconnect.net/features/#my-list", getDriver().getCurrentUrl());
        homePage.movingToMenuElement("Features", "Cue Proximity");
        Assert.assertEquals("https://cueconnect.net/features/#cue-proximity", getDriver().getCurrentUrl());


    }
    @Test(groups = "positive")
    public void movingToAboutMenu() throws InterruptedException, FindFailed, IOException {

        HomePageObject homePage = new HomePageObject();

        homePage.movingToMenuElement("About", "Our Story");
        Assert.assertEquals("https://cueconnect.net/about/", getDriver().getCurrentUrl());
        Assert.assertEquals("Our Story", homePage.getTitle());
        homePage.movingToMenuElement("About", "Press");
        Assert.assertEquals("https://cueconnect.net/press/", getDriver().getCurrentUrl());
        homePage.movingToMenuElement("About", "Team");
        Assert.assertEquals("https://cueconnect.net/team/", getDriver().getCurrentUrl());
        homePage.movingToMenuElement("About", "Careers");
        Assert.assertEquals("https://cueconnect.net/careers/", getDriver().getCurrentUrl());
        homePage.movingToMenuElement("About", "Contact");
        Assert.assertEquals("https://cueconnect.net/contactus/", getDriver().getCurrentUrl());


    }
    @Test(groups = "positive")
    public void movingToBlogMenu() throws InterruptedException, FindFailed, IOException {

        HomePageObject homePage = new HomePageObject();

        homePage.movingToMenuElement("Blog", "Blog");
        Assert.assertEquals("https://cueconnect.net/blog/", getDriver().getCurrentUrl());
        Assert.assertEquals("Cue Connect Blog", homePage.getTitle());
        homePage.movingToMenuElement("Blog", "Resources");
        Assert.assertEquals("https://cueconnect.net/resources/", getDriver().getCurrentUrl());
        homePage.movingToMenuElement("Blog", "Cue Academy");
        Assert.assertEquals("https://cueconnect.net/cue-academy/", getDriver().getCurrentUrl());
    }

    @Test(groups = "positive")
    public void singleClickOnLoginTopMenuItems() throws InterruptedException, FindFailed, IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.singleClickOnLoginButton();
        Assert.assertEquals("Get Started for Free »", homePage.getLoginTitle());
    }
    @Test(groups = "positive")
    public void singleClickOnTopMenuItems() throws InterruptedException, FindFailed, IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.singleClickOnTopMenuItem("Features");
        Assert.assertEquals("Build Customer Relationships That Last Forever", homePage.getTitle());
        homePage.singleClickOnTopMenuItem("About");
        Assert.assertEquals("Our Story", homePage.getTitle());
        homePage.singleClickOnTopMenuItem("Benefits");
        Assert.assertEquals("Grow Conversions Increase Sales", homePage.getTitle());
        homePage.singleClickOnTopMenuItem("Blog");
        Assert.assertEquals("Cue Connect Blog", homePage.getTitle());
        homePage.singleClickOnTopMenuItem("Support");
        Assert.assertEquals("What can we help you with?", homePage.getSupportPageTitle());
        getDriver().navigate().back();
        homePage.singleClickOnTopMenuItem("Request a Demo");
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", homePage.getTitle());
    }








    @Test
    public void scrollingToTransformTraffic() throws FindFailed, IOException {
        String link = "/benefits/#transform-traffic";
        HomePageObject homePage = new HomePageObject();
        WebElement el = getDriver().findElement(By.xpath("//a[@href='" + link + "']"));
        homePage.waitAndClick(el);
        Assert.assertEquals("https://cueconnect:d5ertf5@cueconnect.net/benefits/#transform-traffic", getDriver().getCurrentUrl());

    }

    @Test
    public void scrollingToRetargetShoppers() throws FindFailed, IOException {
        String link = "/benefits/#retarget-shoppers";
        HomePageObject homePage = new HomePageObject();
        WebElement el = getDriver().findElement(By.xpath("//a[@href='" + link + "']"));
        homePage.waitAndClick(el);
        Assert.assertEquals("https://cueconnect:d5ertf5@cueconnect.net/benefits/#retarget-shoppers", getDriver().getCurrentUrl());

    }

    @Test
    public void scrollingToDriveEcommerce() throws FindFailed, IOException {
        String link = "/benefits/#drive-ecommerce";
        HomePageObject homePage = new HomePageObject();
        WebElement el = getDriver().findElement(By.xpath("//a[@href='" + link + "']"));
        homePage.waitAndClick(el);
        Assert.assertEquals("https://cueconnect:d5ertf5@cueconnect.net/benefits/#drive-ecommerce", getDriver().getCurrentUrl());

    }

    @Test(groups = "positive")
    public void scrollingToCueConnectBlog() throws FindFailed, IOException {
        String link = "/blog";
        HomePageObject homePage = new HomePageObject();
        WebElement el = getDriver().findElement(By.xpath("//a[@href='" + link + "'][text()='Learn More']"));
        homePage.waitAndClick(el);
        Assert.assertEquals("https://cueconnect.net/blog/", getDriver().getCurrentUrl());
        Assert.assertEquals("Cue Connect Blog", homePage.getTitle());

    }

    @Test(groups = "positive")
    public void scrollingToResources() throws FindFailed, IOException {
        String link = "https://cueconnect.net/resources/";
        HomePageObject homePage = new HomePageObject();
        WebElement el = getDriver().findElement(By.xpath("//a[@href='" + link + "'][text()='Learn More ']"));
        homePage.waitAndClick(el);
        Assert.assertEquals("https://cueconnect.net/resources/", getDriver().getCurrentUrl());
        Assert.assertEquals("Marketing Guides", homePage.getTitle());

    }


    @Test(groups = "positive")
    public void typingValidEmailAndClickRequestDemo() throws InterruptedException, FindFailed, IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.typingEmailAndclickOnRequestDemoButton("test@test.com");
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", homePage.getTitle());
        Assert.assertEquals("https://cueconnect.net/request-a-demo/?merchant_email=test%40test.com", getDriver().getCurrentUrl());

    }

    @Test(groups = "negative")
    public void emptyEmailAndClickRequestDemo() throws InterruptedException, FindFailed, IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.typingEmailAndclickOnRequestDemoButton("");
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", homePage.getTitle());
        Assert.assertEquals("https://cueconnect.net/request-a-demo/?merchant_email=", getDriver().getCurrentUrl());

    }

    @Test(groups = "negative")
    public void notEmailFormatAndClickRequestDemo() throws InterruptedException, FindFailed, IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.typingEmailAndclickOnRequestDemoButton("test");
        Assert.assertEquals("https://cueconnect:d5ertf5@cueconnect.net/", getDriver().getCurrentUrl());
    }

    @Test(groups = "positive")
    public void sendingUpdatesToValidEmail() throws InterruptedException, FindFailed, IOException {

        HomePageObject homePage = new HomePageObject();
        homePage.sendMeUpdatesVerifying("test@test.com");
        Assert.assertEquals("Thank you for subscribing!", homePage.getValidEmailMessage());


    }

    @Test(groups = "negative")
    public void sendingUpdatesEmptyEmail() throws InterruptedException, FindFailed, IOException {

        HomePageObject homePage = new HomePageObject();
        homePage.sendMeUpdatesVerifying("");
        //Assert.assertEquals("Email is required", homePage.getEmptyEmailMessage());

    }

    @Test(groups = "negative")
    public void sendingUpdatesIncorrectEmail() throws InterruptedException, FindFailed, IOException {

        HomePageObject homePage = new HomePageObject();
        homePage.sendMeUpdatesVerifying("test");
       // Assert.assertEquals("Email must be formatted correctly.", homePage.getEmptyEmailMessage());

    }
    @Test(groups = "negative")
    public void sendingUpdatesIncorrectEmailWithAt() throws InterruptedException, FindFailed, IOException {

        HomePageObject homePage = new HomePageObject();
        homePage.sendMeUpdatesVerifying("test@test");
       // Assert.assertEquals("Please enter a valid email address.", homePage.getEmptyEmailMessage());

    }

    @Test(groups = "positive")
    public void bottomMenuVerifying() throws InterruptedException, FindFailed, IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.clickOnBottomMenuElement("Features", "Build Customer Relationships That Last Forever");
        homePage.clickOnBottomMenuElement("Resources", "Marketing Guides");
        homePage.clickOnBottomMenuElement("Benefits", "Grow Conversions Increase Sales");
        homePage.clickOnBottomMenuElement("Blog", "Cue Connect Blog");
        homePage.clickOnBottomMenuElement("Privacy", "Privacy Policy");
        homePage.clickOnBottomMenuElement("Terms", "Terms and Conditions");

    }

    @Test(groups = "positive")
    public void getStartedFreeChecking() throws InterruptedException, FindFailed, IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.getStartedFree();
        Assert.assertEquals("Store Information", homePage.storeInformationPageTitle());

    }
}
