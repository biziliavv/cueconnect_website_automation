package tests.About;


import org.openqa.selenium.By;
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
        Thread.sleep(3000);
        careersPage.scrollDown();
        Thread.sleep(15000);
        getDriver().findElement(By.xpath("//a[@data-mapped='true']")).click();
       // careersPage.waitForElementAfterScroll(getDriver().findElement(By.xpath("//h2[@id='21522']")));
        Assert.assertEquals("Administrative", careersPage.getCategoryTitle(21522));
        Assert.assertEquals("Sales & Operations", careersPage.getCategoryTitle(21518));
        Assert.assertEquals("Technology", careersPage.getCategoryTitle(21520));


    }
}
