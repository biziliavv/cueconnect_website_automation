package tests.Blog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Blog.BlogPage;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;
import static setup.SeleniumDriver.getDriver;

import java.io.IOException;

/**
 * Created by vitaliybizilia on 3/3/17.
 */
public class BlogMainPageTests extends SeleniumBaseTest {

    @Test
    public void subscribeToValidEmail() throws IOException, InterruptedException {

        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();
        blogPage.fillingInEmailForUpdates("test@test.com");
        Assert.assertEquals("Thank you for subscribing!", blogPage.getValidEmailMessage());


    }

    @Test
    public void subscribeToEmptyEmail() throws IOException, InterruptedException {

        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();
        Assert.assertEquals("Cue Connect Blog", blogPage.getTitle());
        Assert.assertTrue(blogPage.getPageImage("2394", "643"));
        blogPage.fillingInEmailForUpdates("");
        Assert.assertEquals("Please complete this mandatory field.", blogPage.getValidationMessages());

    }
    @Test
    public void subscribeToWrongEmailWithoutAt() throws IOException, InterruptedException {

        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();
        blogPage.fillingInEmailForUpdates("test");
        Assert.assertEquals("Email must be formatted correctly.", blogPage.getValidationMessages());

    }
    @Test
    public void subscribeToWrongEmailWithAt() throws IOException, InterruptedException {

        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();
        blogPage.fillingInEmailForUpdates("test@test");
        Assert.assertEquals("Please enter a valid email address.", blogPage.getValidationMessages());

    }

    @Test
    public void checkSocialNetworkButton() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();

        blogPage.clickOnSocialNetworkButton();

    }

    @Test
    public void openingPostByClickOnTitle() throws InterruptedException, IOException {

        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();
        String postTitle = blogPage.getPostTitleOnMainBlog();
        blogPage.openPostByClickOnTitle();
        Thread.sleep(3000);
        Assert.assertEquals(postTitle, blogPage.getPostTitleOnBlogPage());

    }

    @Test
    public void openingPostByClickOnReadThisPostBtn() throws InterruptedException, IOException {

        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();
        String postTitle = blogPage.getPostTitleOnMainBlog();
        blogPage.openPostByClickOnReadThisPost();
        Thread.sleep(3000);
        Assert.assertEquals(postTitle, blogPage.getPostTitleOnBlogPage());

    }

    @Test
    public void goingToCommentsSectionByClickOnClickHereLink() throws InterruptedException, IOException {

        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();
        blogPage.clickOnClickHereLink();
        Thread.sleep(3000);
        WebElement newFrame = getDriver().findElement(By.id("dsq-app1"));
        getDriver().switchTo().frame(newFrame);
        Assert.assertEquals("Powered by Disqus", blogPage.getTitleOfDisqus());

    }
    @Test
    public void clickingOnTagChecking() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();
        Thread.sleep(3000);
        String tagName = "Customer Journey";
        blogPage.clickingOnTag(tagName);
        Thread.sleep(3000);
        Assert.assertEquals("Tag: "+tagName+"", blogPage.getTitle());

    }
    @Test
    public void clickingOnAuthorChecking() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();
        Thread.sleep(3000);
        String authorName = "Evan Duarte";
        blogPage.clickingOnAuthor(authorName);
        Thread.sleep(3000);
        Assert.assertEquals("Author: "+authorName+"", blogPage.getTitle());

    }


}
