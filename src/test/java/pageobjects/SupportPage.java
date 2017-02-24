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

    }


    public void searchOnPage(String searchValue){

       WebElement searchInput =  getDriver().findElement(By.xpath("//input[@type='search']"));
        searchInput.sendKeys(searchValue);
        WebElement searchButton = getDriver().findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();
    }
    public boolean getFilePresent(){

        return getDriver().findElement(By.xpath("//a[@class='upload-link']")).isDisplayed();

    }

    public boolean getSearchHeader(){

        return isElementDisplayed(getDriver().findElement(By.xpath("//header[@class='page-header']")));
    }
}
