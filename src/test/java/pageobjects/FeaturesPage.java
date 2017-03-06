package pageobjects;

import javafx.scene.image.Image;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/28/17.
 */
public class FeaturesPage extends BaseObjectPage {

    public FeaturesPage() {
        super(getDriver());


    }


    public void clickOnSecondRequestDemo() throws InterruptedException {
        Thread.sleep(3000);
        WebElement requestDemoButton = getDriver().findElement(By.xpath("//div[@data-vc-full-width='true']//a[text()='Request a demo']"));
        requestDemoButton.click();
    }
    public void scrollAndVerifyEachElement() throws InterruptedException {
        String title[] = {"Create A Complete Picture Of Your Shoppers", "Connect Shoppers With Items They Care Most", "Provide a Seamless Sharing Experience", "Create Proximity-Based Engagement"};
        String width[] = {"738", "567", "639", "551"};
        String height[] = {"437", "394", "412", "396"};


        for (int j = 0; j < title.length; j++) {
            Thread.sleep(6000);
            WebElement section = getDriver().findElement(By.xpath("//h3[text()='"+title[j]+"']"));
            waitForElementAfterScroll(section);
            Assert.assertTrue(getPageImage(width[j], height[j]));

        }
    }






}
