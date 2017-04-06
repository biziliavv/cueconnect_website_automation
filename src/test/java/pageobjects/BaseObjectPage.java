package pageobjects;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.driver;
import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/23/17.
 */
public abstract class BaseObjectPage {
    private WebDriver driver;


    public BaseObjectPage(WebDriver driver) {
        this.driver = driver;

    }




    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }



    // Custom wait method for waiting until element is visible
    public WebElement fluentWaitforElement(WebElement element, int timoutSec, int pollingSec) {

        FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(timoutSec, TimeUnit.SECONDS)
                .pollingEvery(pollingSec, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class, TimeoutException.class).ignoring(StaleElementReferenceException.class);

        for (int i = 0; i < 2; i++) {
            try {
                fWait.until(ExpectedConditions.visibilityOf(element));
                fWait.until(ExpectedConditions.elementToBeClickable(element));
            } catch (Exception e) {

                System.out.println("Element Not found trying again - " + element.toString().substring(70));
                e.printStackTrace();

            }
        }

        return element;

    }

    private void scrollToElement(WebElement el) {
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", el);
        }
    }

// Custom wait for clicking element after scrolling

    public void waitAndClick(WebElement el) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10, 200);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
            wait.until(ExpectedConditions.elementToBeClickable(el)).click();

        } catch (WebDriverException wde) {
            scrollToElement(el);
            fluentWaitforElement(el, 15, 3);
            el.click();
        }
    }

 //Custom wait to scrolling to needed element
 public void waitForElementAfterScroll(WebElement el) {
     try {
         WebDriverWait wait = new WebDriverWait(driver, 10, 400);
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
         wait.until(ExpectedConditions.elementToBeClickable(el));

     } catch (WebDriverException wde) {
         scrollToElement(el);


     }
 }

    public void movingToMenuElement(String menuElement, String submenuElement, String mobileMenuItem) {


        String[] dimensions = driver.manage().window().getSize().toString().split("\\D");
        int screenWidth = Integer.parseInt(dimensions[1]);
        int screenHeight = Integer.parseInt(dimensions[3]);

        if (screenWidth >= 1208 && screenHeight >= 680) {

            waitFor(3);
            Actions builder = new Actions(getDriver());
            waitFor(2);
            WebElement el = getDriver().findElement(By.xpath("//a/span[text()='" + menuElement + "']"));
            waitFor(4);
            builder.moveToElement(el).build().perform();
            WebElement submenuButton = getDriver().findElement(By.xpath("//ul//span[text()='" + submenuElement + "']"));
            fluentWaitforElement(submenuButton, 25, 4);
            submenuButton.click();

            waitFor(7);
        } else {
            waitFor(3);
            WebElement hamburgerMenuButton = getDriver().findElement(By.xpath("//div[@class='mobile-navigation-toggle']"));
            hamburgerMenuButton.click();
            waitFor(5);
            WebElement neededMenu = getDriver().findElement(By.xpath("//a[text()='" + mobileMenuItem.toUpperCase() + "']"));
            fluentWaitforElement(neededMenu, 30, 4);
            neededMenu.click();
            waitFor(7);
        }


    }




    public void scrollDown(){

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0, 250)", "");
    }

    public void scrollUp(Integer startPoint, Integer endPoint){

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy("+startPoint+", "+endPoint+")", "");
    }
    public String getTitle(){

        return getDriver().findElement(By.xpath("//h1[@class='page-title']")).getText();
    }
    public String getSectionTitle(){

        return getDriver().findElement(By.xpath("//div/h3[@class='section-title']")).getText();
    }
    public void clickOnFirstRequestDemo(){

        WebElement requestDemoButton = getDriver().findElement(By.xpath("//a[text()='Request a demo']"));
        requestDemoButton.click();

    }
    public Boolean getPageImage(String width, String height) {

        return getDriver().findElement(By.xpath("//img[@width="+width+"][@height="+height+"]")).isDisplayed();
    }

    public void switchingBetweenTabs(Integer count) {
        ArrayList tabs = new ArrayList(getDriver().getWindowHandles());
        System.out.println(tabs.size());
        getDriver().switchTo().window((String) tabs.get(count));


    }
    public boolean isFileDownloaded(String downloadPath, String fileName) {
        File dir = new File(downloadPath);
        File[] dirContents = dir.listFiles();

        for (int i = 0; i < dirContents.length; i++) {
            if (dirContents[i].getName().equals(fileName)) {
                // File has been found, it can now be deleted:
                dirContents[i].delete();
                return true;
            }
        }
        return false;
    }
    public String getCurrentLink(){
        return getDriver().getCurrentUrl();

    }

    public void moveToEmployeeAndWaitQuote(){

        Actions builder = new Actions(getDriver());
        WebElement employee = getDriver().findElement(By.xpath("//div[@class='cue-employee']"));
        fluentWaitforElement(employee, 10, 5);
        builder.moveToElement(employee).build().perform();

    }

    public String getEmployeesQuote() {
        WebElement quote = getDriver().findElement(By.xpath("//div[@class='cue-person-quote']/p"));
        return quote.getText();
    }

    public String getBigTitle() {
        return getDriver().findElement(By.xpath("//h1[@class='page-title big-title']")).getText();
    }
    public String getJoinOurTeamLink(){

        return getDriver().findElement(By.xpath("//a[text()='Join our team']")).getAttribute("href");
    }

    public String getValidEmailMessage()  {
        waitFor(5);
        WebElement message = getDriver().findElement(By.xpath("//div[@class='submitted-message'][@data-reactid='.hbspt-forms-0']"));
        fluentWaitforElement(message, 30, 3);
        return message.getText();
    }
    public void fillingInEmailForUpdates(String emailValue)  {
        waitFor(3);
        WebElement emailField = getDriver().findElement(By.xpath("//input[@name='email']"));
        emailField.clear();
        emailField.sendKeys(emailValue);
        waitFor(3);
        WebElement sendUpdatesButton = getDriver().findElement(By.xpath("//input[@value='Send me Updates']"));
        fluentWaitforElement(sendUpdatesButton, 20, 3);
        sendUpdatesButton.click();
    }
    public static void waitFor(Integer seconds){
        getDriver().manage().timeouts().setScriptTimeout(seconds, TimeUnit.SECONDS);
    }
    public void hamburgerMenuClicking()  {
        waitFor(2);
        WebElement hamburgerMenu = getDriver().findElement(By.xpath("//div[@class='mobile-navigation-toggle']"));
        if (hamburgerMenu.isDisplayed()){
            hamburgerMenu.click();
            waitFor(4);
        }
    }


}

