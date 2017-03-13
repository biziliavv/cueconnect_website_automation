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

        supportPage.goToSubmitRequest();
        //supportPage.fillingFormSubmitRequest("Test", "Test description");
        String filePath = System.getProperty("user.dir") + "/src/example.jpg";
        WebElement fileUpl = getDriver().findElement(By.id("request-attachments"));
        fileUpl.sendKeys(filePath);
        //supportPage.openUploadDialog(filePath);
        Thread.sleep(7000);
        Assert.assertTrue(supportPage.getFilePresent());
        supportPage.scrollDown();
        Thread.sleep(2000);
        supportPage.sendingRequest();


    }
    @Test
    public void submitRequestEmptyFieldsChecking() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();

        supportPage.goToSubmitRequest();
        supportPage.fillingFormSubmitRequest("", "", "");
        supportPage.scrollDown();
        Thread.sleep(2000);
        supportPage.sendingRequest();
        Assert.assertEquals("Requester: Email: cannot be blank", supportPage.getValidationMessageForSendingRequestEmail());
        Assert.assertEquals("Subject: cannot be blank", supportPage.getValidationMessageForSendingRequestSubject());
        Assert.assertEquals("Description: cannot be blank", supportPage.getValidationMessageForSendingRequestDescription());

    }
    @Test
    public void submitRequestEmptyWrongEmailWithoutAt() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();

        supportPage.goToSubmitRequest();
        String value = "test";
        supportPage.fillingFormSubmitRequest(value, "", "");
        supportPage.scrollDown();
        Thread.sleep(2000);
        supportPage.sendingRequest();
        Assert.assertEquals("Requester: Email: "+value+" is not properly formatted", supportPage.getValidationMessageForSendingRequestEmail());


    }
    @Test
    public void openingArticleFromPopular() throws InterruptedException,  IOException {

        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();
        String link_title = supportPage.getLinkText();
        supportPage.openFromPopularTopics();
        Thread.sleep(2000);
        Assert.assertEquals(link_title, supportPage.getArticleTitle());

    }
    @Test
    public void openArticleFromCategory() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();
        supportPage.openArticleFromCategory();
        Thread.sleep(3000);

    }
    @Test
    public void openArticleFromSideBarMenu() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();

        SupportPage supportPage = homePage.goToSupportPage();
        supportPage.openArticleFromCategory();
        Thread.sleep(3000);
        String title = supportPage.getArticleTitleSideBar();
        supportPage.openArticleFromSideBarMenu();
        Assert.assertEquals(title, supportPage.getArticleTitle());
    }
    @Test
    public void breadCrumbsChecking() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        SupportPage supportPage = homePage.goToSupportPage();
        supportPage.openArticleFromCategory();
        Thread.sleep(3000);
        String title = supportPage.getBreadcrumbLinkText();
        supportPage.clickOnBradcrumbLink();
        Assert.assertEquals(title, supportPage.getCategoryHeader());



    }
    @Test
    public void backToDashboardChecking() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        SupportPage supportPage = homePage.goToSupportPage();
        supportPage.openArticleFromCategory();
        Thread.sleep(3000);
        supportPage.clickOnBackToDashboard();
        Assert.assertEquals(supportPage.getSearchTitle(), "What can we help you with?");

    }

    @Test
    public void singInChecking() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        SupportPage supportPage = homePage.goToSupportPage();
        Thread.sleep(3000);
        supportPage.signInToCueConnect();
    }

    @Test
    public void expandAndCollapseCategories() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        SupportPage supportPage = homePage.goToSupportPage();
        Thread.sleep(3000);
        supportPage.expandAndCollapseBottomCategories();
    }


}
