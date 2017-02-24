package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static setup.SeleniumDriver.driver;
import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/23/17.
 */
public class HomePageObject extends BaseObjectPage {

    private static final String url = "https://cueconnect.com/";

    public HomePageObject() {
        super(getDriver());
        getDriver().get(url);

    }

    @FindBy(xpath = "//span[text()='Request a Demo']")
    WebElement requestDemo;


    public RequestDemoPage goToRequestDemoPage() {
        getDriver().findElement(By.xpath("//span[text()='Request a Demo']")).click();
        return new RequestDemoPage();
    }

    public SupportPage goToSupportPage() throws InterruptedException {
        getDriver().findElement(By.xpath("//span[text()='Support']")).click();
        Thread.sleep(3000);
        return new SupportPage();
    }




    public void selectingReportingSuite(){

       WebElement reportingSuite = getDriver().findElement(By.xpath("//span[text()='Reporting Suite']"));
        fluentWaitforElement(reportingSuite, 10, 3);

        reportingSuite.click();
    }





}
