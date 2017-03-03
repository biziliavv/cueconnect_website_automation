package pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/3/17.
 */
public class BlogPage extends BaseObjectPage {

    public BlogPage() {
        super(getDriver());
    }

    public void fillingInEmailForUpdates(String emailValue) throws InterruptedException {
        WebElement emailField = getDriver().findElement(By.xpath("//input[@name='email']"));
        emailField.clear();
        emailField.sendKeys(emailValue);
        WebElement sendUpdatesButton = getDriver().findElement(By.xpath("//input[@value='Send me Updates']"));
        sendUpdatesButton.click();
        Thread.sleep(3000);
    }

    public String getValidationMessages() throws InterruptedException {
        Thread.sleep(3000);
        return getDriver().findElement(By.xpath("//li/label")).getText();
    }

    public void clickOnSocialNetworkButton(String socialNetworkName) throws InterruptedException {

        Thread.sleep(4000);
        WebElement socialNetwork = getDriver().findElement(By.xpath("//div[@class='social-likes__button social-likes__button_"+socialNetworkName+"']"));
        socialNetwork.click();
        Thread.sleep(3000);
    }

    public Boolean getPartOfLink(String socialNetworkText){

        return getDriver().getPageSource().contains(socialNetworkText);
    }

    public void openPostByClickOnTitle() {
        WebElement postTitle= getDriver().findElement(By.xpath("//h2[@class='post-title']"));
        postTitle.click();
    }

    public String getPostTitleOnMainBlog(){
        return getDriver().findElement(By.xpath("//h2[@class='post-title']")).getText();
    }

    public String getPostTitleOnBlogPage(){
        return getDriver().findElement(By.xpath("//h1[@class='post-title']")).getText();
    }

}
