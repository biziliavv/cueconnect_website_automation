package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/23/17.
 */
public class RequestDemoPage extends BaseObjectPage {

    public RequestDemoPage() {
        super(getDriver());


    }

    public void requiredFieldFillingIn(String fieldName, String fieldValue, Integer identifier) throws InterruptedException {
        Thread.sleep(2000);
        //WebElement field = getDriver().findElement(By.id(fieldName));
        scrollDown();
        WebElement field = getDriver().findElement(By.xpath("//input[@name='"+fieldName+"']"));
        Thread.sleep(5000);
        fluentWaitforElement(field, 10, 7);
        field.clear();
        field.sendKeys(fieldValue);
        Thread.sleep(3000);
        Select platform = new Select(getDriver().findElement(By.xpath("//select[@name='ecomm_platform__c']")));
        platform.selectByIndex(identifier);
        Thread.sleep(2000);



    }

    public void sendingData() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
    }

    public String getValidMessageAfterSendingForm() throws InterruptedException {
        Thread.sleep(4000);
        WebElement messageAfterSending = getDriver().findElement(By.xpath("//div[@class='hbspt-form']/div[@class='submitted-message']"));
        fluentWaitforElement(messageAfterSending, 10, 5);
        return messageAfterSending.getText();

    }
    public String getMessageOfEmptyFields(String fieldName) throws InterruptedException {
        Thread.sleep(4000);

        return getDriver().findElement(By.xpath("//div[@class='hs_"+fieldName+" field hs-form-field']//ul/li/label[@class='visible']")).getText();
    }



}
