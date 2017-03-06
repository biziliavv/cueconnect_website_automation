package pageobjects.Blog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageobjects.BaseObjectPage;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/6/17.
 */
public class ResourcesPage extends BaseObjectPage {
    public ResourcesPage() {
        super(getDriver());
    }

    public void templateOpening(){
        WebElement template = getDriver().findElement(By.xpath("//a/p[@class='regular-text']"));
        template.click();
    }
    public String getLinkTitle() throws InterruptedException {
        Thread.sleep(3000);
        return getDriver().findElement(By.xpath("//a/p[@class='regular-text']")).getText();
    }
    public String getTemplateTitle() throws InterruptedException {
        Thread.sleep(3000);
        return getDriver().findElement(By.xpath("//div/div/span/h1")).getText();
    }
    public void fillingInForm(String firstNameValue, String lastNameValue, String emailValue, Integer selectorValue){
        WebElement firstNameField = getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstNameField.sendKeys(firstNameValue);
        WebElement lastNameField = getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastNameField.sendKeys(lastNameValue);
        WebElement emailField = getDriver().findElement(By.xpath("//input[@name='email']"));
        emailField.sendKeys(emailValue);
        Select employees_number = new Select(getDriver().findElement(By.xpath("//select[@name='numemployees']")));
        employees_number.selectByIndex(selectorValue);
        Select platform = new Select(getDriver().findElement(By.xpath("//select[@name='commerce_platform']")));
        platform.selectByIndex(selectorValue);

    }

    public void donwloadButtonClicking() throws InterruptedException {
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@type='submit']")).click();
    }

    public String getThankfulMessage() throws InterruptedException {
        Thread.sleep(2000);
        return getDriver().findElement(By.xpath("//p[@class='p1']")).getText();
    }
    public void downloadYourTemplateButtonClicking() throws InterruptedException {
        Thread.sleep(2000);
        WebElement downloadBtn = getDriver().findElement(By.xpath("//a[@class='cta_button']"));
        downloadBtn.click();
        }
    public String getValidationMessage(String fieldName){
        return getDriver().findElement(By.xpath("//div[@class='hs_"+fieldName+" field hs-form-field']//li/label")).getText();
    }
    public String getSubscribeForUpdatesMessage() throws InterruptedException {
        Thread.sleep(2000);
        return getDriver().findElement(By.xpath("//span[@data-hs-cos-type='form']//strong")).getText();
    }
}
