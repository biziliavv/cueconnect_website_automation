package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

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

// Custom wait for clicking element after scrolling

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

 //Custom wait to scrolling to needed element
 public void waitForElementAfterScroll(WebElement el) {
     try {
         WebDriverWait wait = new WebDriverWait(driver, 5, 200);
         wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader")));
         wait.until(ExpectedConditions.elementToBeSelected(el));

     } catch (WebDriverException wde) {
         scrollToElement(el);

     }
 }
    public void movingToMenuElement(String menuElement, String submenuElement) throws InterruptedException {

        Actions builder = new Actions(getDriver());
        WebElement el = getDriver().findElement(By.xpath("//span[text()='"+menuElement+"']"));

        fluentWaitforElement(el, 10, 3);
        builder.moveToElement(el).build().perform();
        WebElement submenuButton = getDriver().findElement(By.xpath("//span[text()='"+submenuElement+"']"));
        Thread.sleep(5000);

        submenuButton.click();

        Thread.sleep(7000);

    }




    public void scrollDown(){

        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.scrollBy(0,450)", "");
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

    public void switchingBetweenTabs(){
        ArrayList tabs = new ArrayList (getDriver().getWindowHandles());
        System.out.println(tabs.size());
        getDriver().switchTo().window((String) tabs.get(0));
    }
}

