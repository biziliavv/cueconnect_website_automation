package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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
            fluentWaitforElement(el, 5, 5);
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


        String[] dimensions = driver.manage().window().getSize().toString().split("\\D");
        int screenWidth = Integer.parseInt(dimensions[1]);
        int screenHeight = Integer.parseInt(dimensions[3]);

        if (screenWidth>=1208 && screenHeight>=680){

        Actions builder = new Actions(getDriver());
        WebElement el = getDriver().findElement(By.xpath("//span[text()='"+menuElement+"']"));

        fluentWaitforElement(el, 10, 5);
        builder.moveToElement(el).build().perform();
            WebElement submenuButton = getDriver().findElement(By.xpath("//span[text()='"+submenuElement+"']"));
            Thread.sleep(5000);
            fluentWaitforElement(submenuButton, 10, 5);
            submenuButton.click();

            Thread.sleep(7000);
        }

        else {
            WebElement hamburgerMenuButton = getDriver().findElement(By.xpath("//div[@class='mobile-navigation-toggle']"));
            hamburgerMenuButton.click();
            Thread.sleep(3000);
            WebElement neededMenu = getDriver().findElement(By.xpath("//a[text()='"+submenuElement.toUpperCase()+"']"));
            Thread.sleep(4000);
            neededMenu.click();
            Thread.sleep(7000);
        }


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

    public String getValidEmailMessage() throws InterruptedException {
        Thread.sleep(5000);
        return getDriver().findElement(By.xpath("//div[@class='submitted-message']")).getText();
    }
    public void fillingInEmailForUpdates(String emailValue) throws InterruptedException {
        WebElement emailField = getDriver().findElement(By.xpath("//input[@name='email']"));
        emailField.clear();
        emailField.sendKeys(emailValue);
        Thread.sleep(3000);
        WebElement sendUpdatesButton = getDriver().findElement(By.xpath("//input[@type='submit']"));
        sendUpdatesButton.click();
        Thread.sleep(5000);
    }
    public static void waitFor(Integer seconds){
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void hamburgerMenuClicking() throws InterruptedException {
        Thread.sleep(2000);
        WebElement hamburgerMenu = getDriver().findElement(By.xpath("//div[@class='mobile-navigation-toggle']"));
        if (hamburgerMenu.isDisplayed()){
            hamburgerMenu.click();
            Thread.sleep(4000);
        }
    }
}

