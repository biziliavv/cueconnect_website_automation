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
    public void requestDemoEmptyRequiredFieldsOpening() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        requestDemoPage.scrollDown();
        requestDemoPage.sendingData();
        Assert.assertEquals("The field is required.", requestDemoPage.getMessageOfEmptyFields("request-name"));
        Assert.assertEquals("The field is required.", requestDemoPage.getMessageOfEmptyFields("request-email"));
        Assert.assertEquals("The field is required.", requestDemoPage.getMessageOfEmptyFields("request-phoneNumber"));
    }

    @Test(groups = "negative")
    public void emailFieldValidations() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        //checking of simple word without @
        requestDemoPage.requiredFieldFillingIn("request-email", "test");
        requestDemoPage.sendingData();
        Assert.assertEquals("The e-mail address entered is invalid.", requestDemoPage.getMessageOfEmptyFields("request-email"));

    }

    @Test(groups = "negative")
    public void phoneNumberFieldValidations() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        //checking phone number with alphabetical values
        requestDemoPage.requiredFieldFillingIn("request-phoneNumber", "blablabla");
        requestDemoPage.sendingData();
        Assert.assertEquals("The telephone number is invalid.", requestDemoPage.getMessageOfEmptyFields("request-phoneNumber"));


    }
    @Test(groups = "positive")
    public void sendingFormWithValidData() throws InterruptedException {
        HomePageObject homePage = new HomePageObject();
        RequestDemoPage requestDemoPage = homePage.goToRequestDemoPage();
        requestDemoPage.requiredFieldFillingIn("request-name", "test");
        requestDemoPage.requiredFieldFillingIn("request-email", "cuetest@mailinator.com");
        requestDemoPage.scrollDown();
        requestDemoPage.requiredFieldFillingIn("request-phoneNumber", "12345678");
        requestDemoPage.sendingData();
        Assert.assertEquals("We just received your request for a demo! One of our specialists will reach out to you in the next 48 hours to get it scheduled.", requestDemoPage.getValidMessageAfterSendingForm());

    }

}
