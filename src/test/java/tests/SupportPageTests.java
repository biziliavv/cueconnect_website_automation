package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import pageobjects.SupportPage;
import setup.SeleniumBaseTest;
import static setup.SeleniumDriver.getDriver;
import java.io.IOException;

/**
 * Created by vitaliybizilia on 2/24/17.
 */
public class SupportPageTests extends SeleniumBaseTest {


    @Test(groups = {"good"})
    public void searchWithValidValue() throws IOException {
        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();
        supportPage.searchOnPage("test");

        Assert.assertTrue(supportPage.getSearchHeader());

    }
    @Test(groups = {"bad"})
    public void searchWithTooLongValue() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        SupportPage supportPage = homePage.goToSupportPage();
        supportPage.searchOnPage("testtesttest");
        Assert.assertTrue(supportPage.getSearchHeader());
        Assert.assertTrue(supportPage.getBrowseKnowledgeBaselink());

    }
    @Test
    public void submitRequestPageUploading() throws IOException {

        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        SupportPage supportPage = homePage.goToSupportPage();

        supportPage.goToSubmitRequest();
        //supportPage.fillingFormSubmitRequest("Test", "Test description");
        String filePath = System.getProperty("user.dir") + "/src/example.jpg";
        WebElement fileUpl = getDriver().findElement(By.id("request-attachments"));
        fileUpl.clear();
        fileUpl.sendKeys(filePath);
        //supportPage.openUploadDialog(filePath);
        waitFor(7);
        Assert.assertTrue(supportPage.getFilePresent());
        supportPage.scrollDown();
        waitFor(2);
        supportPage.sendingRequest();


    }
    @Test
    public void asubmitRequestEmptyFieldsChecking() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        SupportPage supportPage = homePage.goToSupportPage();

        supportPage.goToSubmitRequest();
        supportPage.fillingFormSubmitRequest("", "", "");
        supportPage.scrollDown();
        waitFor(2);
        supportPage.sendingRequest();
        Assert.assertEquals("Requester: Email: cannot be blank", supportPage.getValidationMessageForSendingRequestEmail());
        Assert.assertEquals("Subject: cannot be blank", supportPage.getValidationMessageForSendingRequestSubject());
        Assert.assertEquals("Description: cannot be blank", supportPage.getValidationMessageForSendingRequestDescription());

    }
    @Test
    public void asubmitRequestEmptyWrongEmailWithoutAt() throws IOException {
        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();

        supportPage.goToSubmitRequest();
        String value = "test";
        supportPage.fillingFormSubmitRequest(value, "", "");
        supportPage.scrollDown();
        waitFor(2);
        supportPage.sendingRequest();
        Assert.assertEquals("Requester: Email: "+value+" is not properly formatted", supportPage.getValidationMessageForSendingRequestEmail());


    }
    @Test
    public void openingArticleFromPopular() throws IOException {

        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();
        String link_title = supportPage.getLinkText();
        supportPage.openFromPopularTopics();
        waitFor(2);
        Assert.assertEquals(link_title, supportPage.getArticleTitle());

    }
    @Test
    public void openArticleFromCategory() throws IOException {
        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();
        supportPage.openArticleFromCategory();
        waitFor(3);

    }
    @Test
    public void openArticleFromSideBarMenu() throws IOException {
        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();
        supportPage.openArticleFromCategory();
        waitFor(3);
        String title = supportPage.getArticleTitleSideBar();
        supportPage.openArticleFromSideBarMenu();
        Assert.assertEquals(title, supportPage.getArticleTitle());
    }
    @Test
    public void breadCrumbsChecking() throws IOException {
        HomePageObject homePage = new HomePageObject();
        SupportPage supportPage = homePage.goToSupportPage();
        supportPage.openArticleFromCategory();
        waitFor(3);
        String title = supportPage.getBreadcrumbLinkText();
        supportPage.clickOnBradcrumbLink();
        Assert.assertEquals(title, supportPage.getCategoryHeader());



    }
    @Test
    public void backToDashboardChecking() throws IOException {
        HomePageObject homePage = new HomePageObject();
        SupportPage supportPage = homePage.goToSupportPage();
        supportPage.openArticleFromCategory();
        waitFor(3);
        supportPage.clickOnBackToDashboard();
        Assert.assertEquals(supportPage.getSearchTitle(), "What can we help you with?");

    }

    @Test
    public void singInChecking() throws IOException {
        HomePageObject homePage = new HomePageObject();
        SupportPage supportPage = homePage.goToSupportPage();
        waitFor(3);
        supportPage.signInToCueConnect();
    }




}
