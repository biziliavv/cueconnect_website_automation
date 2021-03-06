package tests.Blog;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Blog.ResourcesPage;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;
import static setup.SeleniumDriver.getDriver;

import java.io.IOException;

/**
 * Created by vitaliybizilia on 3/6/17.
 */
public class ResourcesPageTests extends SeleniumBaseTest {

    @Test
    public void templateOpeningChecking() throws IOException {

        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        ResourcesPage resourcesPage = homePage.goToResources();
        waitFor(3);
        Assert.assertEquals("Marketing Guides", resourcesPage.getTitle());
        Assert.assertTrue(resourcesPage.getPageImage("520", "708"));
        String linkTitle = resourcesPage.getLinkTitle();
        resourcesPage.templateOpening();
        waitFor(2);
        Assert.assertEquals(linkTitle, resourcesPage.getTemplateTitle());

    }
    @Test
    public void avalidDataFormChecking() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(5);
        ResourcesPage resourcesPage = homePage.goToResources();
        waitFor(3);
        resourcesPage.templateOpening();
        waitFor(2);
        String pageTitle = resourcesPage.getTemplateTitle();
        resourcesPage.fillingInForm("John", "Smith", "jsmith@gmail.com", 1);
        resourcesPage.donwloadButtonClicking();
        waitFor(2);
        Assert.assertTrue(resourcesPage.getThankfulMessage().contains(pageTitle));



    }
    @Test
    public void aemptyDataFormChecking() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        ResourcesPage resourcesPage = homePage.goToResources();
        waitFor(3);
        resourcesPage.templateOpening();
        waitFor(2);
        resourcesPage.cleaningForm();
        waitFor(2);
        resourcesPage.fillingInForm("", "", "", 0);
        waitFor(3);
        resourcesPage.donwloadButtonClicking();
        waitFor(2);
        Assert.assertEquals(resourcesPage.getValidationMessage("firstname"), "Please complete this mandatory field.");
        waitFor(2);
        Assert.assertEquals(resourcesPage.getValidationMessage("lastname"), "Please complete this mandatory field.");
        waitFor(2);
        Assert.assertEquals(resourcesPage.getValidationMessage("email"), "Please complete this mandatory field.");
        waitFor(2);
        //Assert.assertEquals(resourcesPage.getValidationMessage("numemployees"), "Please select an option from the dropdown.");

    }
    @Test
    public void wrongEmailWithoutAtDataFormChecking() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        ResourcesPage resourcesPage = homePage.goToResources();
        waitFor(3);
        resourcesPage.templateOpening();
        waitFor(2);
        resourcesPage.cleaningForm();
        waitFor(2);
        resourcesPage.fillingInForm("John", "Smith", "john.smith", 1);
        waitFor(3);
        resourcesPage.donwloadButtonClicking();
        waitFor(2);
        Assert.assertEquals(resourcesPage.getValidationMessage("email"), "Email must be formatted correctly.");

    }
    @Test
    public void wrongEmailWithAtDataFormChecking() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        ResourcesPage resourcesPage = homePage.goToResources();
        waitFor(3);
        resourcesPage.templateOpening();
        waitFor(2);
        resourcesPage.cleaningForm();
        waitFor(2);
        resourcesPage.fillingInForm("John", "Smith", "jsmith@gmail", 1);
        resourcesPage.donwloadButtonClicking();
        waitFor(2);
        Assert.assertEquals(resourcesPage.getValidationMessage("email"), "Email must be formatted correctly.");

    }
    @Test
    public void downloadTemplateAndSubscribeForUpdates() throws IOException {
        HomePageObject homePage = new HomePageObject();
        ResourcesPage resourcesPage = homePage.goToResources();
        waitFor(3);
        resourcesPage.templateOpening();
        waitFor(2);
        resourcesPage.cleaningForm();
        waitFor(2);
        resourcesPage.fillingInForm("John", "Smith", "jsmith@gmail.com", 1);
        waitFor(3);
        resourcesPage.donwloadButtonClicking();
        waitFor(2);
        resourcesPage.fillingInEmailForUpdates("jsmith@gmail.com");
        waitFor(5);
        Assert.assertEquals("Thanks for signing up!", resourcesPage.getSubscribeForUpdatesMessage());
    }

    @Test
    public void downloadTemplateAndSubscribeForUpdatesEmptyEmail() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        ResourcesPage resourcesPage = homePage.goToResources();
        waitFor(3);
        resourcesPage.templateOpening();
        waitFor(2);
        resourcesPage.cleaningForm();
        waitFor(2);
        resourcesPage.fillingInForm("John", "Smith", "jsmith@gmail.com", 1);
        waitFor(3);
        resourcesPage.donwloadButtonClicking();
        waitFor(2);
        resourcesPage.fillingInEmailForUpdates("");
        waitFor(4);
        Assert.assertEquals(resourcesPage.getValidationMessage("email"), "Please complete this mandatory field.");
    }

    @Test
    public void downloadTemplateAndSubscribeForUpdatesEmailWithoutAt() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(2);
        ResourcesPage resourcesPage = homePage.goToResources();
        waitFor(3);
        resourcesPage.templateOpening();
        waitFor(2);
        resourcesPage.cleaningForm();
        waitFor(2);
        resourcesPage.fillingInForm("John", "Smith", "jsmith@gmail.com", 1);
        waitFor(3);
        resourcesPage.donwloadButtonClicking();
        waitFor(4);
        resourcesPage.fillingInEmailForUpdates("jsmith");
        waitFor(4);
        Assert.assertEquals(resourcesPage.getValidationMessage("email"), "Email must be formatted correctly.");
    }

    @Test
    public void downloadTemplateAndSubscribeForUpdatesEmailWithAt() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        ResourcesPage resourcesPage = homePage.goToResources();
        waitFor(3);
        resourcesPage.templateOpening();
        waitFor(2);
        resourcesPage.fillingInForm("John", "Smith", "jsmith@gmail.com", 1);
        waitFor(4);
        resourcesPage.donwloadButtonClicking();
        waitFor(2);
        resourcesPage.fillingInEmailForUpdates("john.smith@test");
        waitFor(6);
        Assert.assertEquals(resourcesPage.getValidationMessage("email"), "Email must be formatted correctly.");
    }


}
