package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import pageobjects.SupportPage;
import setup.SeleniumBaseTest;

/**
 * Created by vitaliybizilia on 2/24/17.
 */
public class SupportPageTests extends SeleniumBaseTest {

    @Test
    public void submitRequestPageUploading() throws InterruptedException {

        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();

        supportPage.submitRequestChecking();
        supportPage.scrollDown();
        String filePath = System.getProperty("user.dir") + "/src/example.jpg";
        supportPage.openUploadDialog(filePath);
        Assert.assertTrue(supportPage.getFilePresent());



    }
}
