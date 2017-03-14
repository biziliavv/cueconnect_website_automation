package pageobjects.Blog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.BaseObjectPage;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/6/17.
 */
public class CueAcademyPage extends BaseObjectPage {
    public CueAcademyPage() {
        super(getDriver());
    }
    public void openItemByClickingOnPicture()  {
        WebElement item = getDriver().findElement(By.cssSelector(".vc_gitem-link.vc-zone-link"));
        item.click();
        waitFor(3);
    }
    public String getItemTitle()  {
        waitFor(3);
        return getDriver().findElement(By.xpath("//div/div/h4")).getText();
    }
    public String getOpenedItemTitle()  {
        waitFor(2);
        return getDriver().findElement(By.xpath("//div[@id='blog-content']/h1")).getText();
    }
    public void openItemByClickOnReadMoreButton()  {
        WebElement item = getDriver().findElement(By.xpath("//a[@title='Read more']"));
        item.click();
        waitFor(3);
    }
}
