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

    @Test(groups = "negative")
    public void requestDemoOpening() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        requestDemoPage.requiredFieldFillingIn("firstname", "");
        Assert.assertEquals("Name is required", requestDemoPage.getMessageForRequiredField("firstname"));
        requestDemoPage.requiredFieldFillingIn("email", "");
        Assert.assertEquals("Email is required", requestDemoPage.getMessageForRequiredField("email"));
        requestDemoPage.scrollDown();
        requestDemoPage.requiredFieldFillingIn("phone", "");
        Assert.assertEquals("Phone Number is required", requestDemoPage.getMessageForRequiredField("phone"));
    }

    @Test(groups = "negative")
    public void emailFieldValidations() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        //checking of simple word without @
        requestDemoPage.requiredFieldFillingIn("email", "test");
        Assert.assertEquals("Email must be formatted correctly.", requestDemoPage.getMessageForRequiredField("email"));
        //checking email with unfinished domain name "test@test"
        requestDemoPage.requiredFieldFillingIn("email", "test@test");
        Assert.assertEquals("Please enter a valid email address.", requestDemoPage.getMessageForRequiredField("email"));

    }

    @Test(groups = "negative")
    public void phoneNumberFieldValidations() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        //checking phone number with alphabetical values
        requestDemoPage.requiredFieldFillingIn("phone", "blablabla");
        Assert.assertEquals("Must contain only numbers, +()-. and x.", requestDemoPage.getMessageForRequiredField("phone"));
        //checking with short version of phone number (no more then 6 digits)
        requestDemoPage.requiredFieldFillingIn("phone", "123456");
        Assert.assertEquals("Must be a valid phone number.", requestDemoPage.getMessageForRequiredField("phone"));

    }
    @Test(groups = "positive")
    public void sendingFormWithValidData() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        requestDemoPage.requiredFieldFillingIn("firstname", "test");
        requestDemoPage.requiredFieldFillingIn("email", "cuetest@mailinator.com");
        requestDemoPage.scrollDown();
        requestDemoPage.requiredFieldFillingIn("phone", "12345678");
        requestDemoPage.sendingData();
        Assert.assertEquals("We just received your request for a demo! One of our specialists will reach out to you in the next 48 hours to get it scheduled.", requestDemoPage.getValidMessageAfterSendingForm());

    }

}
