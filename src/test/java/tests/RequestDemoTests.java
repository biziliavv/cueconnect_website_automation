package tests;


import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import pageobjects.RequestDemoPage;
import setup.SeleniumBaseTest;
import org.testng.Assert;

import java.io.IOException;

/**
 * Created by vitaliybizilia on 2/23/17.
 */
public class RequestDemoTests extends SeleniumBaseTest {

    @Test(groups = "negative")
    public void requestDemoEmptyRequiredFieldsOpening() throws InterruptedException,  IOException {
        HomePageObject homePage = new HomePageObject();
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        requestDemoPage.scrollDown();
        requestDemoPage.sendingData();
        Assert.assertEquals("Name is required", requestDemoPage.getMessageOfEmptyFields("firstname"));
        Assert.assertEquals("Email is required", requestDemoPage.getMessageOfEmptyFields("email"));
        Assert.assertEquals("Phone Number is required", requestDemoPage.getMessageOfEmptyFields("phone"));
    }

    @Test(groups = "negative")
    public void emailFieldValidations() throws InterruptedException,  IOException {
        HomePageObject homePage = new HomePageObject();
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        //checking of simple word without @
        requestDemoPage.requiredFieldFillingIn("email", "test");
        requestDemoPage.sendingData();
        Assert.assertEquals("Email must be formatted correctly.", requestDemoPage.getMessageOfEmptyFields("email"));

    }

    @Test(groups = "negative")
    public void phoneNumberFieldValidations() throws InterruptedException,  IOException {
        HomePageObject homePage = new HomePageObject();
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        //checking phone number with alphabetical values
        requestDemoPage.requiredFieldFillingIn("phone", "blablabla");
        requestDemoPage.sendingData();
        Assert.assertEquals("Must contain only numbers, +()-. and x.", requestDemoPage.getMessageOfEmptyFields("phone"));


    }
    @Test(groups = "positive")
    public void sendingFormWithValidData() throws InterruptedException,  IOException {
        HomePageObject homePage = new HomePageObject();
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        requestDemoPage.requiredFieldFillingIn("firstname", "test");
        requestDemoPage.requiredFieldFillingIn("email", "test@test.com");
        requestDemoPage.scrollDown();
        requestDemoPage.requiredFieldFillingIn("phone", "12345678");
        requestDemoPage.sendingData();
        Assert.assertEquals("We just received your request for a demo! One of our specialists will reach out to you in the next 48 hours to get it scheduled.", requestDemoPage.getValidMessageAfterSendingForm());

    }

}
