package pageobjects.About;

import org.openqa.selenium.By;
import pageobjects.BaseObjectPage;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/2/17.
 */
public class Careers extends BaseObjectPage {
    public Careers() {
        super(getDriver());

    }

    public String getCurrentJobsTitle() throws InterruptedException {
        Thread.sleep(3000);

        return getDriver().findElement(By.xpath("//h1[@id='board_title']")).getText();
    }
    public String getCategoryTitle(Integer identifier){

        return getDriver().findElement(By.xpath("//section/h2[@id='"+identifier+"']")).getText();
    }

}
