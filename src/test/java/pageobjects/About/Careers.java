package pageobjects.About;

import org.apache.commons.logging.impl.WeakHashtable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        return getDriver().findElement(By.xpath("//div[@id='main']//strong")).getText();
    }
    public String getCategoryTitle(){

        return getDriver().findElement(By.xpath("//section/h2")).getText();
    }

    public void openingVacancy(){
        WebElement openedVacancy = getDriver().findElement(By.xpath("//a[@data-mapped='true']"));
        openedVacancy.click();

    }

    public String getVacancyTitle(){
        return getDriver().findElement(By.xpath("//a[@data-mapped='true']")).getText();
    }
    public String getOpenedVacancyTitle(){
        return getDriver().findElement(By.xpath("//h1[@class='app-title']")).getText();
    }



}
