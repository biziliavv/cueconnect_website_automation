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
import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.driver;
import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/23/17.
 */
public class HomePageTests extends SeleniumBaseTest {

    @Test(groups = "positive")
    public void movingToFeaturesFirstHalfMenu() throws InterruptedException {

        HomePageObject homePage = new HomePageObject();

        homePage.movingToMenuElement("Features", "Reporting Suite");
        Assert.assertEquals("https://cueconnect.com/features/#reporting-suite", getDriver().getCurrentUrl());
        homePage.movingToMenuElement("Features", "Share Tools");
        Assert.assertEquals("https://cueconnect.com/features/#share-tools", getDriver().getCurrentUrl());
    }
    @Test(groups = "positive")
    public void movingToFeaturesSecondHalfMenu() throws InterruptedException {

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("Features", "My List");
        Assert.assertEquals("https://cueconnect.com/features/#my-list", getDriver().getCurrentUrl());
        homePage.movingToMenuElement("Features", "Cue Proximity");
        Assert.assertEquals("https://cueconnect.com/features/#cue-proximity", getDriver().getCurrentUrl());


    }
    @Test(groups = "positive")
    public void movingToAboutMenu() throws InterruptedException {

        HomePageObject homePage = new HomePageObject();

        homePage.movingToMenuElement("About", "Our Story");
        Assert.assertEquals("https://cueconnect.com/about/", getDriver().getCurrentUrl());
        Assert.assertEquals("Our Story", homePage.getTitle());
        homePage.movingToMenuElement("About", "Press");
        Assert.assertEquals("https://cueconnect.com/press/", getDriver().getCurrentUrl());
        homePage.movingToMenuElement("About", "Team");
        Assert.assertEquals("https://cueconnect.com/team/", getDriver().getCurrentUrl());
        homePage.movingToMenuElement("About", "Careers");
        Assert.assertEquals("https://cueconnect.com/careers/", getDriver().getCurrentUrl());
        homePage.movingToMenuElement("About", "Contact");
        Assert.assertEquals("https://cueconnect.com/contactus/", getDriver().getCurrentUrl());


    }
    @Test(groups = "positive")
    public void movingToBlogMenu() throws InterruptedException {

        HomePageObject homePage = new HomePageObject();

        homePage.movingToMenuElement("Blog", "Blog");
        Assert.assertEquals("https://cueconnect.com/blog/", getDriver().getCurrentUrl());
        Assert.assertEquals("Cue Connect Blog", homePage.getTitle());
        homePage.movingToMenuElement("Blog", "Resources");
        Assert.assertEquals("https://cueconnect.com/resources/", getDriver().getCurrentUrl());
    }

    @Test(groups = "positive")
    public void singleClickOnLoginTopMenuItems() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        homePage.singleClickOnLoginButton();
        Assert.assertEquals("Get Started for Free »", homePage.getLoginTitle());
    }
    @Test(groups = "positive")
    public void singleClickOnTopMenuItems() throws InterruptedException {
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
        Assert.assertEquals("https://support.cueconnect.com/hc/en-us", getDriver().getCurrentUrl());
        getDriver().navigate().back();
        homePage.singleClickOnTopMenuItem("Request a Demo");
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", homePage.getTitle());
    }








    @Test
    public void scrollingToFirstLinkOfDiscoverMoreShoppersSection() {
        String link = "/benefits/#transform-traffic";
        HomePageObject homePage = new HomePageObject();
        WebElement el = getDriver().findElement(By.xpath("//a[@href='" + link + "']"));
        homePage.waitAndClick(el);
        Assert.assertEquals("https://cueconnect.com/benefits/#transform-traffic", getDriver().getCurrentUrl());

    }

    @Test
    public void scrollingToSecondLinkOfDiscoverMoreShoppersSection() {
        String link = "/benefits/#retarget-shoppers";
        HomePageObject homePage = new HomePageObject();
        WebElement el = getDriver().findElement(By.xpath("//a[@href='" + link + "']"));
        homePage.waitAndClick(el);
        Assert.assertEquals("https://cueconnect.com/benefits/#retarget-shoppers", getDriver().getCurrentUrl());

    }

    @Test
    public void scrollingToThirdLinkOfDiscoverMoreShoppersSection() {
        String link = "/benefits/#drive-ecommerce";
        HomePageObject homePage = new HomePageObject();
        WebElement el = getDriver().findElement(By.xpath("//a[@href='" + link + "']"));
        homePage.waitAndClick(el);
        Assert.assertEquals("https://cueconnect.com/benefits/#drive-ecommerce", getDriver().getCurrentUrl());

    }

    @Test(groups = "positive")
    public void scrollingToFirstItemOfTakeAdvantagesSection() {
        String link = "/blog";
        HomePageObject homePage = new HomePageObject();
        WebElement el = getDriver().findElement(By.xpath("//a[@href='" + link + "'][text()='Learn More']"));
        homePage.waitAndClick(el);
        Assert.assertEquals("https://cueconnect.com/blog/", getDriver().getCurrentUrl());
        Assert.assertEquals("Cue Connect Blog", homePage.getTitle());

    }

    @Test(groups = "positive")
    public void scrollingToSecondItemOfTakeAdvantagesSection() {
        String link = "https://cueconnect.com/resources/";
        HomePageObject homePage = new HomePageObject();
        WebElement el = getDriver().findElement(By.xpath("//a[@href='" + link + "'][text()='Learn More ']"));
        homePage.waitAndClick(el);
        Assert.assertEquals("https://cueconnect.com/resources/", getDriver().getCurrentUrl());
        Assert.assertEquals("Marketing Guides", homePage.getTitle());

    }


    @Test(groups = "positive")
    public void typingValidEmailAndClickRequestDemo() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        homePage.typingEmailAndclickOnRequestDemoButton("test@test.com");
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", homePage.getTitle());
        Assert.assertEquals("https://cueconnect.com/request-a-demo/?merchant_email=test%40test.com", getDriver().getCurrentUrl());

    }

    @Test(groups = "negative")
    public void emptyEmailAndClickRequestDemo() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        homePage.typingEmailAndclickOnRequestDemoButton("");
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", homePage.getTitle());
        Assert.assertEquals("https://cueconnect.com/request-a-demo/?merchant_email=", getDriver().getCurrentUrl());

    }

    @Test(groups = "negative")
    public void notEmailFormatAndClickRequestDemo() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        homePage.typingEmailAndclickOnRequestDemoButton("test");
        Assert.assertEquals("https://cueconnect.com/", getDriver().getCurrentUrl());
    }

    @Test(groups = "positive")
    public void sendingUpdatesToValidEmail() throws InterruptedException {

        HomePageObject homePage = new HomePageObject();
        homePage.sendMeUpdatesVerifying("test@test.com");
        Assert.assertEquals("Thank you for subscribing!", homePage.getValidEmailMessage());

    }

    @Test(groups = "negative")
    public void sendingUpdatesEmptyEmail() throws InterruptedException {

        HomePageObject homePage = new HomePageObject();
        homePage.sendMeUpdatesVerifying("");
        Assert.assertEquals("Email is required", homePage.getEmptyEmailMessage());

    }

    @Test(groups = "negative")
    public void sendingUpdatesIncorrectEmail() throws InterruptedException {

        HomePageObject homePage = new HomePageObject();
        homePage.sendMeUpdatesVerifying("test");
        Assert.assertEquals("Email must be formatted correctly.", homePage.getEmptyEmailMessage());

    }
    @Test(groups = "negative")
    public void sendingUpdatesIncorrectEmailWithAt() throws InterruptedException {

        HomePageObject homePage = new HomePageObject();
        homePage.sendMeUpdatesVerifying("test@test");
        Assert.assertEquals("Please enter a valid email address.", homePage.getEmptyEmailMessage());

    }

    @Test(groups = "positive")
    public void bottomMenuVerifying() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        homePage.clickOnBottomMenuElement("Features", "Build Customer Relationships That Last Forever");
        homePage.clickOnBottomMenuElement("Resources", "Marketing Guides");
        homePage.clickOnBottomMenuElement("Benefits", "Grow Conversions Increase Sales");
        homePage.clickOnBottomMenuElement("Blog", "Cue Connect Blog");
        homePage.clickOnBottomMenuElement("Privacy", "Privacy Policy");
        homePage.clickOnBottomMenuElement("Terms", "Terms and Conditions");

    }

    @Test(groups = "positive")
    public void getStartedFreeChecking() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        homePage.getStartedFree();
        Assert.assertEquals("Store Information", homePage.storeInformationPageTitle());

    }
}
