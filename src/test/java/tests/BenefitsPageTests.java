package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.BenefitsPage;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;
import static setup.SeleniumDriver.getDriver;
import java.io.IOException;

/**
 * Created by vitaliybizilia on 3/6/17.
 */
public class BenefitsPageTests extends SeleniumBaseTest {

    @Test
    public void openingPageAndClickOnRequestDemo() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        BenefitsPage benefitsPage = homePage.goToBenefitsPage();
        Assert.assertTrue(benefitsPage.getPageImage("548", "360"));
        Assert.assertEquals("Grow Conversions Increase Sales", benefitsPage.getTitle());
        benefitsPage.clickOnFirstRequestDemo();
        Thread.sleep(5000);
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", benefitsPage.getTitle());

    }
    @Test
    public void scrollingDownAndVerifyingPresenceOfElements() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        BenefitsPage benefitsPage = homePage.goToBenefitsPage();
        Thread.sleep(3000);
        benefitsPage.scrollAndVerifyEachElement();
    }
}
