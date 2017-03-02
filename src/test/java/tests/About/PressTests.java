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
    public void downloadLinkCheckingLogoBlack() throws InterruptedException, IOException {

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("About", "Press");
        Thread.sleep(3000);
        WebElement downloadCueLogoEps = getDriver().findElement(By.xpath("//div[@class='brand_download']/span/a[text()='.eps']"));
        downloadCueLogoEps.click();
        Thread.sleep(3000);
        homePage.isFileDownloaded("download", "cue-logo-black.eps");
        WebElement downloadCueLogoPng = getDriver().findElement(By.xpath("//div[@class='brand_download']/span/a[text()='.png']"));
        downloadCueLogoPng.click();
        Thread.sleep(3000);
        homePage.switchingBetweenTabs(1);
        Assert.assertEquals("https://cueconnect.net/assets/files/cue-logo-black.png", homePage.getCurrentLink());
        getDriver().close();
        homePage.switchingBetweenTabs(0);




    }

    @Test
    public void downloadLinkCheckingIconBlack() throws InterruptedException, IOException {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("About", "Press");
        Thread.sleep(3000);
        String href_eps = "/assets/files/e-icon-black.eps";
        WebElement downloadCueIconEps = getDriver().findElement(By.xpath("//a[@href='"+href_eps+"']"));
        downloadCueIconEps.click();
        Thread.sleep(5000);
        homePage.isFileDownloaded("download", "e-icon-black.eps");
        String href_png = "/assets/files/e-icon-black.png";
        WebElement downloadCueIconPng = getDriver().findElement(By.xpath("//a[@href='"+href_png+"']"));
        downloadCueIconPng.click();
        Thread.sleep(5000);
        homePage.switchingBetweenTabs(1);
        Assert.assertEquals("https://cueconnect.net/assets/files/e-icon-black.png", homePage.getCurrentLink());
        getDriver().close();
        homePage.switchingBetweenTabs(0);


    }
    @Test
    public void downloadLinkCheckingLogo() throws InterruptedException, IOException {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("About", "Press");
        Thread.sleep(3000);
        String href_eps = "/assets/files/cue-connect-logo-black.eps";
        WebElement downloadCueIconEps = getDriver().findElement(By.xpath("//a[@href='"+href_eps+"']"));
        downloadCueIconEps.click();
        Thread.sleep(5000);
        homePage.isFileDownloaded("download", "cue-connect-logo-black.eps");
        String href_png = "/assets/files/cue-connect-logo-black.png";
        WebElement downloadCueIconPng = getDriver().findElement(By.xpath("//a[@href='"+href_png+"']"));
        downloadCueIconPng.click();
        Thread.sleep(5000);
        homePage.switchingBetweenTabs(1);
        Assert.assertEquals("https://cueconnect.net/assets/files/cue-connect-logo-black.png", homePage.getCurrentLink());
        getDriver().close();
        homePage.switchingBetweenTabs(0);



    }
    @Test
    public void downloadLinkCheckingLogoVertical() throws InterruptedException, IOException {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("About", "Press");
        Thread.sleep(3000);
        String href_eps = "/assets/files/cue-connect-logo-vertical.eps";
        WebElement downloadCueIconEps = getDriver().findElement(By.xpath("//a[@href='"+href_eps+"']"));
        downloadCueIconEps.click();
        Thread.sleep(5000);
        homePage.isFileDownloaded("download", "cue-connect-logo-vertical.eps");
        String href_png = "/assets/files/cue-connect-logo-vertical.png";
        WebElement downloadCueIconPng = getDriver().findElement(By.xpath("//a[@href='"+href_png+"']"));
        downloadCueIconPng.click();
        Thread.sleep(5000);
        homePage.switchingBetweenTabs(1);
        Assert.assertEquals("https://cueconnect.net/assets/files/cue-connect-logo-vertical.png", homePage.getCurrentLink());
        getDriver().close();
        homePage.switchingBetweenTabs(0);


    }

    @Test
    public void chekingStyleGuide() throws InterruptedException, IOException {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("About", "Press");
        Thread.sleep(3000);
        String href_guide = "/assets/files/press-kit-2017.pdf";
        WebElement downloadCueIconPng = getDriver().findElement(By.xpath("//a[@href='"+href_guide+"']"));
        downloadCueIconPng.click();
        Thread.sleep(2000);
        homePage.switchingBetweenTabs(1);
        Thread.sleep(7000);
        Assert.assertEquals("https://cueconnect.net/assets/files/press-kit-2017.pdf", homePage.getCurrentLink());
        getDriver().close();
        homePage.switchingBetweenTabs(0);




    }
    @Test
    public void checkinReadMoreLink() throws InterruptedException, IOException {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        HomePageObject homePage = new HomePageObject();

        homePage.movingToMenuElement("About", "Press");
        Thread.sleep(3000);
        WebElement readMore = getDriver().findElement(By.xpath("//span[@class='press-article-link']/a[@target='_blank']"));
        readMore.click();
        Thread.sleep(3000);
        homePage.switchingBetweenTabs(1);
        Assert.assertEquals("http://www.marketingprofs.com/opinions/2016/31117/why-experiential-retail-might-is-just-what-you-need-this-holiday-season", homePage.getCurrentLink());
        getDriver().close();
        homePage.switchingBetweenTabs(0);
    }

}
