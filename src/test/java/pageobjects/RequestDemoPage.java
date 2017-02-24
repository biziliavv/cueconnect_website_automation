package pageobjects;

import org.openqa.selenium.By;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/23/17.
 */
public class RequestDemoPage extends BaseObjectPage {

    public RequestDemoPage() {
        super(getDriver());


    }

    public String getTitle(){

        return getDriver().findElement(By.xpath("//h1[@class='page-title']")).getText();
    }
}
