package tests.About;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/2/17.
 */
public class PressTests extends SeleniumBaseTest {

    @Test
    public void downloadLinkCheckingLogoBlack() throws IOException {

        HomePageObject homePage = new HomePageObject();
        waitFor(2);
        homePage.movingToMenuElement("About", "Press", "Press");
        waitFor(3);
        WebElement downloadCueLogoEps = getDriver().findElement(By.xpath("//div[@class='brand_download']/span/a[text()='.eps']"));
        downloadCueLogoEps.click();
        waitFor(3);
        homePage.isFileDownloaded("download", "cue-logo-black.eps");
        WebElement downloadCueLogoPng = getDriver().findElement(By.xpath("//div[@class='brand_download']/span/a[text()='.png']"));
        downloadCueLogoPng.click();
        waitFor(3);
        homePage.switchingBetweenTabs(1);
        getDriver().close();
        homePage.switchingBetweenTabs(0);




    }

    @Test
    public void downloadLinkCheckingIconBlack() throws IOException {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("About", "Press", "Press");
        waitFor(3);
        String href_eps = "/assets/files/e-icon-black.eps";
        WebElement downloadCueIconEps = getDriver().findElement(By.xpath("//a[@href='"+href_eps+"']"));
        downloadCueIconEps.click();
        waitFor(5);
        homePage.isFileDownloaded("download", "e-icon-black.eps");
        String href_png = "/assets/files/e-icon-black.png";
        WebElement downloadCueIconPng = getDriver().findElement(By.xpath("//a[@href='"+href_png+"']"));
        downloadCueIconPng.click();
        waitFor(5);
        homePage.switchingBetweenTabs(1);
        getDriver().close();
        homePage.switchingBetweenTabs(0);


    }
    @Test
    public void downloadLinkCheckingLogo() throws IOException {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("About", "Press", "Press");
        waitFor(3);
        String href_eps = "/assets/files/cue-connect-logo-black.eps";
        WebElement downloadCueIconEps = getDriver().findElement(By.xpath("//a[@href='"+href_eps+"']"));
        downloadCueIconEps.click();
        waitFor(5);
        homePage.isFileDownloaded("download", "cue-connect-logo-black.eps");
        String href_png = "/assets/files/cue-connect-logo-black.png";
        WebElement downloadCueIconPng = getDriver().findElement(By.xpath("//a[@href='"+href_png+"']"));
        downloadCueIconPng.click();
        waitFor(5);
        homePage.switchingBetweenTabs(1);
        getDriver().close();
        homePage.switchingBetweenTabs(0);



    }
    @Test
    public void downloadLinkCheckingLogoVertical() throws IOException {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("About", "Press", "Press");
        waitFor(3);
        String href_eps = "/assets/files/cue-connect-logo-vertical.eps";
        WebElement downloadCueIconEps = getDriver().findElement(By.xpath("//a[@href='"+href_eps+"']"));
        downloadCueIconEps.click();
        waitFor(5);
        homePage.isFileDownloaded("download", "cue-connect-logo-vertical.eps");
        String href_png = "/assets/files/cue-connect-logo-vertical.png";
        WebElement downloadCueIconPng = getDriver().findElement(By.xpath("//a[@href='"+href_png+"']"));
        downloadCueIconPng.click();
        waitFor(5);
        homePage.switchingBetweenTabs(1);
        getDriver().close();
        homePage.switchingBetweenTabs(0);


    }

    @Test
    public void chekingStyleGuide() throws IOException {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("About", "Press", "Press");
        waitFor(3);
        String href_guide = "/assets/files/press-kit-2017.pdf";
        WebElement downloadCueIconPng = getDriver().findElement(By.xpath("//a[@href='"+href_guide+"']"));
        downloadCueIconPng.click();
        waitFor(2);
        homePage.switchingBetweenTabs(1);
        waitFor(7);
        getDriver().close();
        homePage.switchingBetweenTabs(0);




    }
    @Test
    public void checkinReadMoreLink() throws IOException {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePageObject homePage = new HomePageObject();

        homePage.movingToMenuElement("About", "Press", "Press");
        waitFor(3);
        WebElement readMore = getDriver().findElement(By.xpath("//span[@class='press-article-link']/a[@target='_blank']"));
        readMore.click();
        waitFor(3);
        homePage.switchingBetweenTabs(1);
        getDriver().close();
        homePage.switchingBetweenTabs(0);
    }

}
