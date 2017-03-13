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
    public void checkSocialNetworkButton() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();
        blogPage.scrollDown();
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
        blogPage.closeSendUpdates();
        String authorName = "Carlos Hernandez";
        blogPage.clickingOnAuthor(authorName);
        Thread.sleep(3000);
        Assert.assertEquals("Author: "+authorName+"", blogPage.getTitle());

    }


}
