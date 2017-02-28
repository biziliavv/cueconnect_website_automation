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
        WebElement field = getDriver().findElement(By.xpath("//div[@class='input']/input[@name='"+fieldName+"']"));
        fluentWaitforElement(field, 10, 7);
        field.click();
        fluentWaitforElement(field, 10, 7);
        field.clear();
        field.sendKeys(fieldValue);
        WebElement jobtitle = getDriver().findElement(By.xpath("//input[@name='jobtitle']"));
        jobtitle.click();
        Thread.sleep(3000);



    }

    public void sendingData() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@type='submit']")).click();



    }
    public String getMessageForRequiredField(String fieldName) throws InterruptedException {
        Thread.sleep(5000);
        WebElement message = getDriver().findElement(By.xpath("//div[@class='hs_"+fieldName+" field hs-form-field']/ul/li/label[@class='visible']"));
        fluentWaitforElement(message, 10, 6);
        return message.getText();
    }

    public String getValidMessageAfterSendingForm(){
        WebElement messageAfterSending = getDriver().findElement(By.xpath("//div[@class='submitted-message']"));
        fluentWaitforElement(messageAfterSending, 10, 5);
        return messageAfterSending.getText();
    }



}
