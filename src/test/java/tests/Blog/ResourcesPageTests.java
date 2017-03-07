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
    public void templateOpeningChecking() throws IOException, InterruptedException {

        HomePageObject homePage = new HomePageObject();
        ResourcesPage resourcesPage = homePage.goToResources();
        Thread.sleep(3000);
        Assert.assertEquals("Marketing Guides", resourcesPage.getTitle());
        Assert.assertTrue(resourcesPage.getPageImage("520", "708"));
        String linkTitle = resourcesPage.getLinkTitle();
        resourcesPage.templateOpening();
        Thread.sleep(2000);
        Assert.assertEquals(linkTitle, resourcesPage.getTemplateTitle());

    }
    @Test
    public void validDataFormChecking() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        ResourcesPage resourcesPage = homePage.goToResources();
        Thread.sleep(3000);
        resourcesPage.templateOpening();
        Thread.sleep(2000);
        String pageTitle = resourcesPage.getTemplateTitle();
        resourcesPage.fillingInForm("Test", "Test", "test@test.com", 1);
        resourcesPage.donwloadButtonClicking();
        Thread.sleep(2000);
        Assert.assertTrue(resourcesPage.getThankfulMessage().contains(pageTitle));



    }
    @Test
    public void emptyDataFormChecking() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        ResourcesPage resourcesPage = homePage.goToResources();
        Thread.sleep(3000);
        resourcesPage.templateOpening();
        Thread.sleep(2000);
        resourcesPage.cleaningForm();
        Thread.sleep(2000);
        resourcesPage.fillingInForm("", "", "", 0);
        resourcesPage.donwloadButtonClicking();
        Thread.sleep(2000);
        Assert.assertEquals(resourcesPage.getValidationMessage("firstname"), "Please complete this mandatory field.");
        Assert.assertEquals(resourcesPage.getValidationMessage("lastname"), "Please complete this mandatory field.");
        Assert.assertEquals(resourcesPage.getValidationMessage("email"), "Please complete this mandatory field.");
        Assert.assertEquals(resourcesPage.getValidationMessage("numemployees"), "Please select an option from the dropdown.");

    }
    @Test
    public void wrongEmailWithoutAtDataFormChecking() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        ResourcesPage resourcesPage = homePage.goToResources();
        Thread.sleep(3000);
        resourcesPage.templateOpening();
        Thread.sleep(2000);
        resourcesPage.cleaningForm();
        Thread.sleep(2000);
        resourcesPage.fillingInForm("Test", "Test", "test", 1);
        resourcesPage.donwloadButtonClicking();
        Thread.sleep(2000);
        Assert.assertEquals(resourcesPage.getValidationMessage("email"), "Email must be formatted correctly.");

    }
    @Test
    public void wrongEmailWithAtDataFormChecking() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        ResourcesPage resourcesPage = homePage.goToResources();
        Thread.sleep(3000);
        resourcesPage.templateOpening();
        Thread.sleep(2000);
        resourcesPage.cleaningForm();
        Thread.sleep(2000);
        resourcesPage.fillingInForm("Test", "Test", "test@test", 1);
        resourcesPage.donwloadButtonClicking();
        Thread.sleep(2000);
        Assert.assertEquals(resourcesPage.getValidationMessage("email"), "Please enter a valid email address.");

    }
    @Test
    public void downloadTemplateAndSubscribeForUpdates() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        ResourcesPage resourcesPage = homePage.goToResources();
        Thread.sleep(3000);
        resourcesPage.templateOpening();
        Thread.sleep(2000);
        resourcesPage.cleaningForm();
        Thread.sleep(2000);
        resourcesPage.fillingInForm("Test", "Test", "test@test.com", 1);
        resourcesPage.donwloadButtonClicking();
        Thread.sleep(2000);
        resourcesPage.fillingInEmailForUpdates("test@test.com");
        Assert.assertEquals("Thanks for signing up!", resourcesPage.getSubscribeForUpdatesMessage());
    }

    @Test
    public void downloadTemplateAndSubscribeForUpdatesEmptyEmail() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        ResourcesPage resourcesPage = homePage.goToResources();
        Thread.sleep(3000);
        resourcesPage.templateOpening();
        Thread.sleep(2000);
        resourcesPage.cleaningForm();
        Thread.sleep(2000);
        resourcesPage.fillingInForm("Test", "Test", "test@test.com", 1);
        resourcesPage.donwloadButtonClicking();
        Thread.sleep(2000);
        resourcesPage.fillingInEmailForUpdates("");
        Assert.assertEquals(resourcesPage.getValidationMessage("email"), "Please complete this mandatory field.");
    }

    @Test
    public void downloadTemplateAndSubscribeForUpdatesEmailWithoutAt() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        ResourcesPage resourcesPage = homePage.goToResources();
        Thread.sleep(3000);
        resourcesPage.templateOpening();
        Thread.sleep(2000);
        resourcesPage.cleaningForm();
        Thread.sleep(2000);
        resourcesPage.fillingInForm("Test", "Test", "test@test.com", 1);
        resourcesPage.donwloadButtonClicking();
        Thread.sleep(2000);
        resourcesPage.fillingInEmailForUpdates("test");
        Assert.assertEquals(resourcesPage.getValidationMessage("email"), "Email must be formatted correctly.");
    }

    @Test
    public void downloadTemplateAndSubscribeForUpdatesEmailWithAt() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        ResourcesPage resourcesPage = homePage.goToResources();
        Thread.sleep(3000);
        resourcesPage.templateOpening();
        Thread.sleep(2000);
        resourcesPage.fillingInForm("Test", "Test", "test@test.com", 1);
        resourcesPage.donwloadButtonClicking();
        Thread.sleep(2000);
        resourcesPage.fillingInEmailForUpdates("test@test");
        Assert.assertEquals(resourcesPage.getValidationMessage("email"), "Please enter a valid email address.");
    }


}
