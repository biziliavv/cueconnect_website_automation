package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/23/17.
 */
public abstract class BaseObjectPage {
    private WebDriver driver;


    public BaseObjectPage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void type(By inputLocator, String text) {
        find(inputLocator).sendKeys(text);
    }

    public void type(WebElement input, String text) {
        input.sendKeys(text);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void click(WebElement element) {
        element.click();
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

// Custom wait for element after scrolling

    public void waitAndClick(WebElement el) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5, 200);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
            wait.until(ExpectedConditions.elementToBeClickable(el)).click();
        } catch (WebDriverException wde) {
            scrollToElement(el);
            el.click();
        }
    }

    public void movingToMenuElement(WebElement el) {

        Actions builder = new Actions(getDriver());

        fluentWaitforElement(el, 10, 3);
        builder.moveToElement(el).build().perform();
    }

    public void attachFile() throws InterruptedException {

        this.scrollDown();
        Thread.sleep(3000);
        WebElement el = getDriver().findElement(By.xpath("//input[@id='request-attachments']"));
        fluentWaitforElement(el, 10, 3);
        String filePath = System.getProperty("user.dir") + "/src/example.jpg";

        el.sendKeys(filePath);


    }
    public void attachFileNew() throws InterruptedException {
        Thread.sleep(3000);

        WebElement El = getDriver().findElement(By.xpath("//input[@type='file'"));

        El.sendKeys("/Users/vitaliybizilia/Desktop/example.jpg");


    }

    public void scrollDown(){

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,450)", "");
    }
}

