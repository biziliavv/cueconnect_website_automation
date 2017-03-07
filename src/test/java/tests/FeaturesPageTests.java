package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.FeaturesPage;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;

import java.io.IOException;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/28/17.
 */
public class FeaturesPageTests extends SeleniumBaseTest {

    @Test
    public void openingFeaturesPageAndClickOnRequestDemo() throws  InterruptedException, IOException {

        HomePageObject homePage = new HomePageObject();
        FeaturesPage featuresPage = homePage.goToFeaturesPage();
        Assert.assertTrue(featuresPage.getPageImage("452", "412"));
        Assert.assertEquals("Build Customer Relationships That Last Forever", featuresPage.getTitle());
        featuresPage.clickOnFirstRequestDemo();
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", featuresPage.getTitle());
    }
    @Test
    public void openingSecondRequestDemoButton() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        FeaturesPage featuresPage = homePage.goToFeaturesPage();
        WebElement secondRequestButton = getDriver().findElement(By.xpath("//div[@data-vc-full-width='true']//a[text()='Request a demo']"));
        featuresPage.waitAndClick(secondRequestButton);
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", featuresPage.getTitle());

    }

    @Test
    public void openingThirdRequestDemoButton() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        FeaturesPage featuresPage = homePage.goToFeaturesPage();
        WebElement thirdRequestButton = getDriver().findElement(By.xpath("//div/div/div[2]/a"));
        featuresPage.waitAndClick(thirdRequestButton);
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", featuresPage.getTitle());

    }
    @Test
    public void scrollingToEachSection() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        FeaturesPage featuresPage = homePage.goToFeaturesPage();
        Assert.assertTrue(featuresPage.getPageImage("452", "412"));
        featuresPage.scrollAndVerifyEachElement();

    }

}
