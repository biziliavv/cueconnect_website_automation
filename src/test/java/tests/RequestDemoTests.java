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
    public void requestDemoEmptyRequiredFieldsOpening() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        waitFor(3);
        requestDemoPage.requiredFieldFillingIn("firstname", "", 0);
        requestDemoPage.requiredFieldFillingIn("email", "", 0);
        requestDemoPage.requiredFieldFillingIn("phone", "", 0);
        requestDemoPage.sendingData();
        Assert.assertEquals("Name is required", requestDemoPage.getMessageOfEmptyFieldsName());
        Assert.assertEquals("Email is required", requestDemoPage.getMessageOfEmptyFieldsEmail());

    }


    @Test(groups = "negative")
    public void emailFieldValidations() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        //checking of simple word without @
        requestDemoPage.requiredFieldFillingIn("firstname", "", 1);
        requestDemoPage.requiredFieldFillingIn("email", "test", 1);
        requestDemoPage.requiredFieldFillingIn("phone", "", 1);
        requestDemoPage.sendingData();
        Assert.assertEquals("Email must be formatted correctly.", requestDemoPage.getMessageOfEmptyFieldsEmail());

    }

    @Test(groups = "negative")
    public void phoneNumberFieldValidations() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        //checking phone number with alphabetical values
        requestDemoPage.requiredFieldFillingIn("phone", "blablabla", 1);
        requestDemoPage.requiredFieldFillingIn("firstname", "", 1);
        requestDemoPage.requiredFieldFillingIn("email", "", 1);
        requestDemoPage.sendingData();
        waitFor(3);
        Assert.assertEquals("Must contain only numbers, +()-. and x.", requestDemoPage.getMessageOfEmptyFieldsPhone());


    }
    @Test(groups = "positive")
    public void sendingFormWithValidData() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        requestDemoPage.requiredFieldFillingIn("firstname", "test", 1);
        requestDemoPage.requiredFieldFillingIn("email", "test@test.com", 1);
        requestDemoPage.scrollDown();
        requestDemoPage.requiredFieldFillingIn("phone", "12345678", 1);
        requestDemoPage.sendingData();
        Assert.assertEquals("We just received your request for a demo! One of our specialists will reach out to you in the next 48 hours to get it scheduled.", requestDemoPage.getValidMessageAfterSendingForm());

    }

}
