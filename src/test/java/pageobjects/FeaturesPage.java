package pageobjects;

import javafx.scene.image.Image;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

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



    public void sikuliClick() throws FindFailed, InterruptedException {
        Screen screen = new Screen();
        Pattern pattern = new Pattern("/Users/vitaliybizilia/Desktop/request_demo.png");

        screen.wait(pattern, 5000);
        screen.click();
        Thread.sleep(10000);
    }


}
