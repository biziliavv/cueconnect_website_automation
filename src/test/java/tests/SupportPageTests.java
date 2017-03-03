package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import pageobjects.SupportPage;
import setup.SeleniumBaseTest;

import java.io.IOException;

/**
 * Created by vitaliybizilia on 2/24/17.
 */
public class SupportPageTests extends SeleniumBaseTest {


    @Test(groups = {"good"})
    public void searchWithValidValue() throws InterruptedException,  IOException {
        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();
        supportPage.searchOnPage("test");

        Assert.assertTrue(supportPage.getSearchHeader());

    }
    @Test(groups = {"bad"})
    public void searchWithTooLongValue() throws InterruptedException,  IOException {
        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();
        supportPage.searchOnPage("testtesttest");
        Assert.assertTrue(supportPage.getSearchHeader());
        Assert.assertTrue(supportPage.getBrowseKnowledgeBaselink());

    }
    @Test
    public void submitRequestPageUploading() throws InterruptedException,  IOException {

        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();

        supportPage.submitRequestChecking();
        supportPage.scrollDown();
        String filePath = System.getProperty("user.dir") + "/src/example.jpg";
        supportPage.openUploadDialog(filePath);
        Assert.assertTrue(supportPage.getFilePresent());

    }

}
