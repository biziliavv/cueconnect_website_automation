package tests;


import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import pageobjects.RequestDemoPage;
import setup.SeleniumBaseTest;
import org.testng.Assert;

/**
 * Created by vitaliybizilia on 2/23/17.
 */
public class RequestDemoTests extends SeleniumBaseTest {

    @Test
    public void requestDemoOpening() {
        HomePageObject homePage = new HomePageObject();
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();

        Assert.assertEquals("Learn How Cue Can Help You Grow Your Business", requestDemoPage.getTitle());
    }
}
