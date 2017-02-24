package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/24/17.
 */
public class SupportPage extends BaseObjectPage {

    public SupportPage(){
        super(getDriver());
    }

    public void submitRequestChecking(){

        WebElement submitArequest = getDriver().findElement(By.xpath("//a[@class='submit-a-request']"));
        fluentWaitforElement(submitArequest, 10, 3);
        submitArequest.click();
    }

    public void openUploadDialog(String filePath){

        getDriver().findElement(By.id("upload-dropzone")).click();
        getDriver().switchTo()
                .activeElement()
                .sendKeys(
                        filePath);
        getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        WebElement result = getDriver().findElement(By.xpath("//a[@class='upload-link']"));
        fluentWaitforElement(result, 10, 5);
    }

    public boolean getFilePresent(){

        return getDriver().findElement(By.xpath("//a[@class='upload-link']")).isDisplayed();
    }

    public String getTitle(){

        return getDriver().findElement(By.xpath("//h1[@class='page-title']")).getText();
    }
}
