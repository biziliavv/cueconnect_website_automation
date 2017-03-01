package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/1/17.
 */
public class AboutPage extends BaseObjectPage {

    public AboutPage() {
        super(getDriver());


    }

    public String getJoinOurTeamLink() throws InterruptedException {
        wait(3000);
        WebElement joiOurTeam = getDriver().findElement(By.xpath("//a[@text()='Join Our Team']"));
        waitForElementAfterScroll(joiOurTeam);
        wait(5000);


        return joiOurTeam.getAttribute("href");
    }
}
