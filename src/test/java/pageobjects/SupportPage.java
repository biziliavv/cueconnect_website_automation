package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 2/24/17.
 */
public class SupportPage extends BaseObjectPage {

    public SupportPage(){
        super(getDriver());
    }

    public void goToSubmitRequest(){

        WebElement submitArequest = getDriver().findElement(By.xpath("//a[@class='submit-a-request']"));
        fluentWaitforElement(submitArequest, 10, 3);
        submitArequest.click();
    }

    public void searchOnPage(String searchValue){

       WebElement searchInput =  getDriver().findElement(By.xpath("//input[@type='search']"));
        searchInput.sendKeys(searchValue);
        WebElement searchButton = getDriver().findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();
    }
    public boolean getFilePresent(){

        return getDriver().findElement(By.xpath("//a[@class='upload-link']")).isDisplayed();

    }

    public boolean getSearchHeader(){

        return isElementDisplayed(getDriver().findElement(By.xpath("//header[@class='page-header']")));
    }

    public boolean getBrowseKnowledgeBaselink(){

        return isElementDisplayed(getDriver().findElement(By.xpath("//a[@title='Home']")));
    }
    public void openFromPopularTopics() throws InterruptedException {
        Thread.sleep(3000);
        WebElement popularArticle = getDriver().findElement(By.xpath("//ul[@class='article-list']/li/a"));
        popularArticle.click();
    }
    public String getLinkText(){
        return getDriver().findElement(By.xpath("//ul[@class='article-list']/li/a")).getText();
    }
    public String getArticleTitle(){
        return getDriver().findElement(By.xpath("//h1[@class='article-title']")).getText();
    }
    public void fillingFormSubmitRequest(String email_value, String subjectName, String description){
        WebElement email = getDriver().findElement(By.id("request_anonymous_requester_email"));
        email.sendKeys(email_value);
        WebElement subject = getDriver().findElement(By.id("request_subject"));
        subject.sendKeys(subjectName);
        WebElement descript = getDriver().findElement(By.id("request_description"));
        descript.sendKeys(description);

    }
    public void sendingRequest() throws InterruptedException {
        Thread.sleep(3000);
        WebElement submit = getDriver().findElement(By.xpath("//input[@value='Submit']"));
        waitAndClick(submit);

    }
    public String getValidationMessageForSendingRequestEmail(){
        return getDriver().findElement(By.xpath("//div[@class='form-field string required request_anonymous_requester_email']//div[@class='notification notification-error notification-inline']")).getText();
    }
    public String getValidationMessageForSendingRequestSubject(){
        return getDriver().findElement(By.xpath("//div[@class='form-field string  required  request_subject']//div[@class='notification notification-error notification-inline']")).getText();
    }
    public String getValidationMessageForSendingRequestDescription(){
        return getDriver().findElement(By.xpath("//div[@class='form-field text  required  request_description']//div[@class='notification notification-error notification-inline']")).getText();
    }
    public void openArticleFromCategory(){
        WebElement merchant_category = getDriver().findElement(By.xpath("//h3[text()='Merchant Hub']"));
        merchant_category.click();
        WebElement article = getDriver().findElement(By.xpath("//ul[@class='article-list']/li[1]"));
        article.click();
    }
    public String getArticleTitleSideBar(){
        return getDriver().findElement(By.xpath("//section[@class='article-sidebar']//ul/li[2]")).getText();
    }
    public void openArticleFromSideBarMenu(){
        WebElement article = getDriver().findElement(By.xpath("//section[@class='article-sidebar']//ul/li[2]"));
        article.click();
    }
    public void clickOnBradcrumbLink(){
        WebElement breadCrumb = getDriver().findElement(By.xpath("//ol[@class='breadcrumbs']/li[3]"));
        breadCrumb.click();
    }
    public String getBreadcrumbLinkText(){
       return getDriver().findElement(By.xpath("//ol[@class='breadcrumbs']/li[3]")).getText();
    }
    public String getCategoryHeader(){
        return getDriver().findElement(By.xpath("//div[@class='page-header-left']")).getText();
    }
    public void clickOnBackToDashboard(){
        WebElement backToDashboard = getDriver().findElement(By.xpath("//a[@class='back-link']"));
        backToDashboard.click();
    }
    public String getSearchTitle(){
        return getDriver().findElement(By.xpath("//h1[@class='search-title']")).getText();
    }
    public void signInToCueConnect() throws InterruptedException {
        WebElement login_button = getDriver().findElement(By.xpath("//a[@class='login']"));
        login_button.click();
        Thread.sleep(3000);
        WebElement frame = getDriver().findElement(By.xpath("//iframe[@allowtransparency='true']"));
        getDriver().switchTo().frame(frame);
        WebElement signInTitle = getDriver().findElement(By.xpath("//h2[@class='title']"));
        Assert.assertEquals("Sign in to Cue Connect", signInTitle.getText());
        WebElement emailField = getDriver().findElement(By.id("user_email"));
        emailField.sendKeys("tester.bizilia@gmail.com");
        WebElement password = getDriver().findElement(By.id("user_password"));
        password.sendKeys("bizilia87");
        Thread.sleep(3000);
        WebElement singin_button = getDriver().findElement(By.xpath("//input[@value='Sign in']"));
        singin_button.click();
        Thread.sleep(3000);
        WebElement logout = getDriver().findElement(By.id("user-name"));
        Assert.assertTrue(isElementDisplayed(logout));
    }
    public void expandAndCollapseBottomCategories() throws InterruptedException {
        Integer counter[] = {1, 2, 3, 4};
        for (int i = 0; i <= counter.length; i++) {
            Thread.sleep(2000);
            WebElement section = getDriver().findElement(By.xpath("//li[@class='category']/ul/li["+counter[i]+"]/h3"));
            section.click();
            String value = section.getAttribute("class");
            Thread.sleep(3000);
            Assert.assertEquals("expanded", value);
            Thread.sleep(3000);
            section.click();
            Assert.assertNull("expanded", value);

        }
    }
}
