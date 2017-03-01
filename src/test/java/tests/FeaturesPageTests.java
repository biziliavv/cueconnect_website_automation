package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.FeaturesPage;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/28/17.
 */
public class FeaturesPageTests extends SeleniumBaseTest {

    @Test
    public void openingFeaturesPageAndClickOnRequestDemo() {

        HomePageObject homePage = new HomePageObject();
        FeaturesPage featuresPage = homePage.goToFeaturesPage();
        Assert.assertEquals("Build Customer Relationships That Last Forever", featuresPage.getTitle());
        featuresPage.clickOnFirstRequestDemo();
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", featuresPage.getTitle());
    }
    @Test
    public void openingSecondRequestDemoButton() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        FeaturesPage featuresPage = homePage.goToFeaturesPage();
        WebElement secondRequestButton = getDriver().findElement(By.xpath("//div[@data-vc-full-width='true']//a[text()='Request a demo']"));
        featuresPage.waitAndClick(secondRequestButton);
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", featuresPage.getTitle());

    }

    @Test
    public void openingThirdRequestDemoButton() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        FeaturesPage featuresPage = homePage.goToFeaturesPage();
        WebElement thirdRequestButton = getDriver().findElement(By.xpath("//p/a[text()='REQUEST A DEMO']"));
        featuresPage.waitAndClick(thirdRequestButton);
        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", featuresPage.getTitle());

    }
    @Test
    public void scrollingToEachSection() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        FeaturesPage featuresPage = homePage.goToFeaturesPage();
        Assert.assertTrue(featuresPage.getPageImage("452", "412"));
        WebElement firstSection = getDriver().findElement(By.xpath("//h3[@class='section-title']"));
        featuresPage.waitForElementAfterScroll(firstSection, "Create A Complete Picture Of Your Shoppers");
        Assert.assertTrue(featuresPage.getPageImage("738", "437"));
        Thread.sleep(2000);
        WebElement secondSection = getDriver().findElement(By.xpath("//div[@id='my-list']//h3[@class='section-title']"));
        featuresPage.waitForElementAfterScroll(secondSection, "Connect Shoppers With Items They Care Most");
        Assert.assertTrue(featuresPage.getPageImage("567", "394"));
        Thread.sleep(2000);
        WebElement thirdSection = getDriver().findElement(By.xpath("//div[@id='share-tools']//h3[@class='section-title']"));
        featuresPage.waitForElementAfterScroll(thirdSection, "Provide a Seamless Sharing Experience");
        Assert.assertTrue(featuresPage.getPageImage("639", "412"));
        Thread.sleep(2000);
        WebElement fourthSection = getDriver().findElement(By.xpath("//div[@id='cue-proximity']//h3[@class='section-title']"));
        featuresPage.waitForElementAfterScroll(fourthSection, "Create Proximity-Based Engagement");
        Assert.assertTrue(featuresPage.getPageImage("551", "396"));
        Thread.sleep(3000);

    }

    @Test
    public void sikuliTry() throws InterruptedException, FindFailed {
        HomePageObject homePage = new HomePageObject();
        FeaturesPage featuresPage = homePage.goToFeaturesPage();
        featuresPage.sikuliClick();
        Thread.sleep(5000);



    }
}
