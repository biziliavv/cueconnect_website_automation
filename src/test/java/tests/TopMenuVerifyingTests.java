package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/13/17.
 */
public class TopMenuVerifyingTests extends SeleniumBaseTest {
    @Test(groups = "desktop")
    public void movingToFeaturesFirstHalfMenu() throws IOException {

        HomePageObject homePage = new HomePageObject();

        homePage.movingToMenuElement("Features", "Reporting Suite", "Reporting Suite");
        Assert.assertEquals("https://cueconnect.com/features/#reporting-suite", getDriver().getCurrentUrl());
        waitFor(3);
        homePage.movingToMenuElement("Features", "Share Tools", "Share Tools");
        Assert.assertEquals("https://cueconnect.com/features/#share-tools", getDriver().getCurrentUrl());
        waitFor(3);
    }
    @Test(groups = "desktop")
    public void movingToFeaturesSecondHalfMenu() throws IOException {

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("Features", "My List", "My List");
        Assert.assertEquals("https://cueconnect.com/features/#my-list", getDriver().getCurrentUrl());
        waitFor(5);
        homePage.movingToMenuElement("Features", "Cue Proximity", "Cue Proximity");
        Assert.assertEquals("https://cueconnect.com/features/#cue-proximity", getDriver().getCurrentUrl());
        waitFor(3);


    }
    @Test(groups = "desktop")
    public void movingToAboutMenu() throws IOException {

        HomePageObject homePage = new HomePageObject();
        waitFor(2);
        homePage.movingToMenuElement("About", "Cue Connect Story","Our Story");
        Assert.assertEquals("https://cueconnect.com/about/", getDriver().getCurrentUrl());
        Assert.assertEquals("Our Story", homePage.getTitle());
        waitFor(3);
        homePage.movingToMenuElement("About", "Press", "Press");
        Assert.assertEquals("https://cueconnect.com/press/", getDriver().getCurrentUrl());
        waitFor(3);
        homePage.movingToMenuElement("About", "Cue Connect Team", "Team");
        Assert.assertEquals("https://cueconnect.com/team/", getDriver().getCurrentUrl());
        waitFor(3);
        homePage.movingToMenuElement("About", "Careers", "Careers");
        Assert.assertEquals("https://cueconnect.com/careers/", getDriver().getCurrentUrl());
        waitFor(3);
        homePage.movingToMenuElement("About", "Contact Us", "Contact");
        Assert.assertEquals("https://cueconnect.com/contactus/", getDriver().getCurrentUrl());


    }
    @Test(groups = "desktop")
    public void movingToBlogMenu() throws IOException {

        HomePageObject homePage = new HomePageObject();

        homePage.movingToMenuElement("Blog", "Blog", "Blog");
        Assert.assertEquals("https://cueconnect.com/blog/", getDriver().getCurrentUrl());
        waitFor(5);
        Assert.assertEquals("Cue Connect Blog", homePage.getTitle());
        homePage.movingToMenuElement("Blog", "Resources", "Resources");
        Assert.assertEquals("https://cueconnect.com/resources/", getDriver().getCurrentUrl());
        waitFor(3);
//        homePage.movingToMenuElement("Blog", "Cue Academy");
//        Assert.assertEquals("https://cueconnect.com/cue-academy/", getDriver().getCurrentUrl());
    }
    @Test(groups = "desktop")
    public void singleClickOnLoginTopMenuItems() throws IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.hamburgerMenuClicking();
        homePage.singleClickOnLoginButton();
        Assert.assertEquals("Get Started for Free »", homePage.getLoginTitle());
    }
    @Test(groups = "desktop")
    public void singleClickOnTopMenuItems() throws IOException {
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
}
