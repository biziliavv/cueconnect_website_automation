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

    public void requiredFieldFillingIn(String fieldName, String fieldValue, Integer identifier)  {
        waitFor(2);
        //WebElement field = getDriver().findElement(By.id(fieldName));
        scrollDown();
        WebElement field = getDriver().findElement(By.xpath("//input[@name='"+fieldName+"']"));
        fluentWaitforElement(field, 40, 4);
        field.clear();
        field.sendKeys(fieldValue);
        Select platform = new Select(getDriver().findElement(By.xpath("//select[@name='ecomm_platform__c']")));
        platform.selectByIndex(identifier);
        waitFor(2);



    }

    public void sendingData()  {
        WebElement sendButton = getDriver().findElement(By.xpath("//input[@type='submit']"));
        fluentWaitforElement(sendButton, 40, 4);
        sendButton.click();
        waitFor(3);
    }

    public String getValidMessageAfterSendingForm()  {
        waitFor(4);
        WebElement messageAfterSending = getDriver().findElement(By.xpath("//div[@class='hbspt-form']/div[@class='submitted-message']"));
        fluentWaitforElement(messageAfterSending, 40, 4);
        return messageAfterSending.getText();

    }
    public String getMessageOfEmptyFieldsName()  {
        waitFor(4);
        WebElement message = getDriver().findElement(By.xpath("//div[1]/ul/li/label"));
        return message.getText();
    }

    public String getMessageOfEmptyFieldsEmail()  {
        waitFor(4);
        WebElement message = getDriver().findElement(By.xpath("//div[2]/ul/li/label"));
        return message.getText();
    }
    public String getMessageOfEmptyFieldsPhone()  {
        waitFor(4);
        WebElement message = getDriver().findElement(By.xpath("//div[5]/ul/li/label"));
        return message.getText();
    }

}
