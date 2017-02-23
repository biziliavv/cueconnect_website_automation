package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;


import java.awt.*;
import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.driver;
import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/23/17.
 */
public class HomePageTests extends SeleniumBaseTest {

    @Test
    public void movingToMenu() throws InterruptedException {

        HomePageObject homePage = new HomePageObject();
        WebElement element = getDriver().findElement(By.xpath("//span[text()='Features']"));

        homePage.movingToMenuElement(element);

        homePage.selectingReportingSuite();

    }

    @Test
    public void scrollingToDiscoverMoreShoppersSection(){
        HomePageObject homePage = new HomePageObject();
        WebElement el = getDriver().findElement(By.xpath("//div[@class='wpb_wrapper']/p/a[text()='See How It Works']"));
        homePage.waitAndClick(el);

    }

}
