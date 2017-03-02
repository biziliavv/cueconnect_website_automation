package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/23/17.
 */
public class RequestDemoPage extends BaseObjectPage {

    public RequestDemoPage() {
        super(getDriver());


    }

    public void requiredFieldFillingIn(String fieldName, String fieldValue) throws InterruptedException {
        Thread.sleep(2000);
        WebElement field = getDriver().findElement(By.id(fieldName));
        Thread.sleep(5000);
        field.click();
        fluentWaitforElement(field, 10, 7);
        field.clear();
        field.sendKeys(fieldValue);
        Thread.sleep(3000);



    }

    public void sendingData() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@type='submit']")).click();



    }
    public String getMessageOfEmptyFields(String fieldName) throws InterruptedException {
        Thread.sleep(4000);

        return getDriver().findElement(By.xpath("//span[@class='wpcf7-form-control-wrap "+fieldName+"']/span[@role='alert']")).getText();
    }
    public String getValidMessageAfterSendingForm() throws InterruptedException {
        Thread.sleep(4000);
        WebElement messageAfterSending = getDriver().findElement(By.xpath("//div[@role='alert']"));
        fluentWaitforElement(messageAfterSending, 10, 5);
        return messageAfterSending.getText();

    }




}
