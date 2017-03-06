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
    public void openItemByClickingOnPicture() throws InterruptedException {
        WebElement item = getDriver().findElement(By.cssSelector(".vc_gitem-link.vc-zone-link"));
        item.click();
        Thread.sleep(3000);
    }
    public String getItemTitle() throws InterruptedException {
        Thread.sleep(3000);
        return getDriver().findElement(By.xpath("//div/div/h4")).getText();
    }
    public String getOpenedItemTitle() throws InterruptedException {
        Thread.sleep(2000);
        return getDriver().findElement(By.xpath("//div[@id='blog-content']/h1")).getText();
    }
    public void openItemByClickOnReadMoreButton() throws InterruptedException {
        WebElement item = getDriver().findElement(By.xpath("//a[@title='Read more']"));
        item.click();
        Thread.sleep(3000);
    }
}
