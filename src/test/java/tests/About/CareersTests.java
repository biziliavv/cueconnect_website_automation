package tests.About;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.About.Careers;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;

import java.io.IOException;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/2/17.
 */
public class CareersTests extends SeleniumBaseTest {

    @Test
    public void checkElementsArePresent() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        Careers careersPage = homePage.goToCareers();
        Assert.assertEquals("Join & Build Something Great", careersPage.getBigTitle());
        Assert.assertTrue(careersPage.getPageImage("1064", "412"));
        Assert.assertEquals("mailto:jobs@cueconnect.com?Subject=Join%20cue", careersPage.getJoinOurTeamLink());
        careersPage.scrollDown();
        WebElement currentFrame = getDriver().findElement(By.id("grnhse_iframe"));
        getDriver().switchTo().frame(currentFrame);
        Thread.sleep(2000);
        Assert.assertEquals("Current Job Openings at Cue Connect", careersPage.getCurrentJobsTitle());
        Assert.assertEquals("Marketing", careersPage.getCategoryTitle());


       // careersPage.waitForElementAfterScroll(getDriver().findElement(By.xpath("//h2[@id='21522']")));



    }

    @Test
    public void openingVacancyAndSendingEmptyForm() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        Careers careersPage = homePage.goToCareers();
        WebElement currentFrame = getDriver().findElement(By.id("grnhse_iframe"));
        getDriver().switchTo().frame(currentFrame);
        String vacancyTitle = careersPage.getVacancyTitle();
        careersPage.openingVacancy();
        WebElement newFrame = getDriver().findElement(By.id("grnhse_iframe"));
        getDriver().switchTo().frame(newFrame);
        Assert.assertEquals(vacancyTitle, careersPage.getOpenedVacancyTitle());


    }
}
