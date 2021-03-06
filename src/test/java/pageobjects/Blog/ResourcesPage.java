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
    public String getLinkTitle()  {
        waitFor(3);
        return getDriver().findElement(By.xpath("//a/p[@class='regular-text']")).getText();
    }
    public String getTemplateTitle()  {
        waitFor(3);
        return getDriver().findElement(By.xpath("//div/div/span/h1")).getText();
    }
    public void fillingInForm(String firstNameValue, String lastNameValue, String emailValue, Integer selectorValue){
        waitFor(2);
        WebElement firstNameField = getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstNameField.clear();
        firstNameField.sendKeys(firstNameValue);
        waitFor(2);
        WebElement lastNameField = getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastNameField.clear();
        lastNameField.sendKeys(lastNameValue);
        waitFor(2);
        WebElement emailField = getDriver().findElement(By.xpath("//input[@name='email']"));
        emailField.clear();
        emailField.sendKeys(emailValue);
        Select employees_number = new Select(getDriver().findElement(By.xpath("//select[@name='numemployees']")));
        employees_number.selectByIndex(selectorValue);
        Select platform = new Select(getDriver().findElement(By.xpath("//select[@name='commerce_platform']")));
        platform.selectByIndex(selectorValue);

    }
    public void cleaningForm(){
        WebElement firstNameField = getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstNameField.clear();
        WebElement lastNameField = getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastNameField.clear();
        WebElement emailField = getDriver().findElement(By.xpath("//input[@name='email']"));
        emailField.clear();
        Select employees_number = new Select(getDriver().findElement(By.xpath("//select[@name='numemployees']")));
        employees_number.selectByIndex(0);
        Select platform = new Select(getDriver().findElement(By.xpath("//select[@name='commerce_platform']")));
        platform.selectByIndex(0);
    }

    public void donwloadButtonClicking()  {
        waitFor(2);
        getDriver().findElement(By.xpath("//input[@type='submit']")).click();
    }

    public String getThankfulMessage()  {
        waitFor(3);
        WebElement thankful = getDriver().findElement(By.xpath("//div[@data-hs-cos-type='rich_text']//p[@class='p1']"));
        fluentWaitforElement(thankful, 50, 3);
        return thankful.getText();
    }
    public void downloadYourTemplateButtonClicking()  {
        waitFor(2);
        WebElement downloadBtn = getDriver().findElement(By.xpath("//a[@class='cta_button']"));
        downloadBtn.click();
        }
    public String getValidationMessage(String fieldName)  {
        waitFor(3);
        WebElement firstName = getDriver().findElement(By.xpath("//div[@class='hs_"+fieldName+" field hs-form-field']//ul/li/label"));
        fluentWaitforElement(firstName, 50, 4);
        return firstName.getText();
    }
    public String getSubscribeForUpdatesMessage()  {
        waitFor(2);
        WebElement message = getDriver().findElement(By.xpath("//span[@data-hs-cos-type='form']//strong"));
        fluentWaitforElement(message, 50, 4);
        return message.getText();
    }
}
