package tests.About;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.About.Contact;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;

import java.io.IOException;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/2/17.
 */
public class ContactUsPageTests extends SeleniumBaseTest {

   /* @Test
    public void sendingToValidEmailChecking() throws IOException, InterruptedException {

        HomePageObject homePage = new HomePageObject();
        Contact contactPage = homePage.goToContact();
        contactPage.fillInData("Test", "cuetest@mailinator.com", "Testing contact us form");
        contactPage.sendingData();
        Assert.assertEquals("Thank you for your message. It has been sent.", contactPage.getMessageAfterSending());
        Thread.sleep(10000);
        getDriver().get("https://www.mailinator.com/inbox2.jsp?public_to=cuetest#/#public_maildirdiv");


    }*/

    @Test
    public void emptyDataChecking() throws IOException, InterruptedException {

        HomePageObject homePage = new HomePageObject();
        Contact contactPage = homePage.goToContact();
        contactPage.fillInData("", "", "");
        contactPage.sendingData();
        Assert.assertEquals("The field is required.", contactPage.getMessageOfEmptyFields("contact-name"));
        Assert.assertEquals("The field is required.", contactPage.getMessageOfEmptyFields("contact-email"));
        Assert.assertEquals("The field is required.", contactPage.getMessageOfEmptyFields("contact-message"));
        Assert.assertEquals("One or more fields have an error. Please check and try again.", contactPage.getMessageAfterSending());

    }

    @Test
    public void badEmailChecking() throws IOException, InterruptedException {

        HomePageObject homePage = new HomePageObject();
        Contact contactPage = homePage.goToContact();
        contactPage.fillInData("Test", "test", "Test Contact Us");
        contactPage.sendingData();
        Assert.assertEquals("The e-mail address entered is invalid.", contactPage.getMessageOfEmptyFields("contact-email"));
        Assert.assertEquals("One or more fields have an error. Please check and try again.", contactPage.getMessageAfterSending());
    }


}