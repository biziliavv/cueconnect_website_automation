package pageobjects.About;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.BaseObjectPage;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/2/17.
 */
public class Contact extends BaseObjectPage {

    public Contact() {
        super(getDriver());

    }

    public void fillInData(String nameData, String emailData, String textData) throws InterruptedException {
        WebElement contact_name = getDriver().findElement(By.id("contact-name"));
        contact_name.sendKeys(nameData);
        Thread.sleep(1000);
        WebElement contact_email = getDriver().findElement(By.id("contact-email"));
        contact_email.sendKeys(emailData);
        Thread.sleep(1000);
        WebElement contact_message = getDriver().findElement(By.id("contact-message"));
        contact_message.sendKeys(textData);
        Thread.sleep(3000);
    }

    public void sendingData(){
        WebElement contactUsButton = getDriver().findElement(By.xpath("//input[@value='Contact us']"));
        contactUsButton.click();
    }
    public String getMessageAfterSending(){

        return getDriver().findElement(By.xpath("//div[@role='alert']")).getText();
    }

    public String getMessageOfEmptyFields(String fieldName) throws InterruptedException {
        Thread.sleep(4000);

        return getDriver().findElement(By.xpath("//span[@class='wpcf7-form-control-wrap "+fieldName+"']//span[@role='alert']")).getText();
    }



}
