package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/6/17.
 */
public class BenefitsPage extends BaseObjectPage {
    public BenefitsPage() {
        super(getDriver());
    }

    public void scrollAndVerifyEachElement() throws InterruptedException {
        String title[] = {"Get Insight Only Cue Can Give You", "Enhance Onsite Marketing", "Retarget Offsite With", "Convert More Shoppers", "Get Higher ROI Results"};
        String width[] = {"215", "258", "287", "273", "218"};
        String height[] = {"220", "225", "218", "217", "221"};


        for (int j = 0; j < title.length; j++) {
            Thread.sleep(6000);
            WebElement section = getDriver().findElement(By.xpath("//h3[text()='"+title[j]+"']"));
            waitForElementAfterScroll(section);
            Assert.assertTrue(getPageImage(width[j], height[j]));

        }
    }
}
