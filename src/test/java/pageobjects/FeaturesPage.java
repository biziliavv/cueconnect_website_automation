package pageobjects;

import javafx.scene.image.Image;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/28/17.
 */
public class FeaturesPage extends BaseObjectPage {

    public FeaturesPage() {
        super(getDriver());


    }

    public void clickOnFirstRequestDemo(){

        WebElement requestDemoButton = getDriver().findElement(By.xpath("//a[text()='Request a demo']"));
        requestDemoButton.click();

    }
    public void clickOnSecondRequestDemo() throws InterruptedException {
        Thread.sleep(3000);
        WebElement requestDemoButton = getDriver().findElement(By.xpath("//div[@data-vc-full-width='true']//a[text()='Request a demo']"));
        requestDemoButton.click();
    }

    public Boolean getPageImage(String width, String height) {

        return getDriver().findElement(By.xpath("//img[@width="+width+"][@height="+height+"]")).isDisplayed();
    }


}
