package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.AboutPage;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;

import java.io.IOException;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/1/17.
 */
public class AboutPageTests extends SeleniumBaseTest {

    @Test
    public void checkingOurStoryPageAppears() throws InterruptedException, IOException {

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("About", "Our Story");
        Assert.assertEquals("Our Story", homePage.getTitle());

    }
    @Test
    public void checkingOurStoryThatElementsArePresent() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("About", "Our Story");
        Assert.assertTrue(homePage.getPageImage("489", "412"));
        Assert.assertEquals("Our Story", homePage.getTitle());
        WebElement buildConnectionsAround = getDriver().findElement(By.xpath("//h1[@class='section-title']"));
        homePage.waitForElementAfterScroll(buildConnectionsAround);
        Assert.assertTrue(homePage.getPageImage("1096", "449"));
        Assert.assertEquals(buildConnectionsAround.getText(), "Build Connections Around\n" +
        "Things That Matter");
        WebElement weStartedJourney = getDriver().findElement(By.xpath("//h2[@class='section-title color-teal']"));
        homePage.waitForElementAfterScroll(weStartedJourney);
        Assert.assertEquals(weStartedJourney.getText(), "We Started Journey By\n" +
                "Acknowledging These Core Truths");
        Assert.assertTrue(homePage.getPageImage("134", "138"));
        Assert.assertTrue(homePage.getPageImage("121", "139"));
        Assert.assertTrue(homePage.getPageImage("148", "138"));
        WebElement meetCue = getDriver().findElement(By.xpath("//h2[@class='section-title']"));
        homePage.waitForElementAfterScroll(meetCue);
        Assert.assertTrue(homePage.getPageImage("738", "437"));
        Assert.assertEquals(meetCue.getText(), "Meet Cue");
        String buildingBetterCommerceValue = "Building Better Commerce\n" +
                "Is A Global Effort";
        WebElement buildingBetterCommerce = getDriver().findElement(By.xpath("//h2[@class='section-title'][@style='text-align: center;']"));
        homePage.waitForElementAfterScroll(buildingBetterCommerce);
        Assert.assertTrue(homePage.getPageImage("1142", "442"));
        WebElement joinOurTeam = getDriver().findElement(By.xpath("//a[text()='Join Our Team']"));
        Assert.assertEquals(joinOurTeam.getAttribute("href"), "mailto:jobs@cueconnect.com?subject=Join%20cue");

    }

    @Test
    public void downloadLinkChecking() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("About", "Press");
        Thread.sleep(3000);
        WebElement downloadCueLogoEps = getDriver().findElement(By.xpath("//div[@class='brand-download']/span/a[text()='.eps']"));
        downloadCueLogoEps.click();
        homePage.switchingBetweenTabs();
        Thread.sleep(5000);

    }

}
