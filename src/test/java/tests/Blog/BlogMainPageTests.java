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
    public void openingPostByClickOnReadThisPostBtn() throws IOException {

        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        BlogPage blogPage = homePage.goToBlogPage();
        String postTitle = blogPage.getPostTitleOnMainBlog();
        blogPage.openPostByClickOnReadThisPost();
        waitFor(3);
        Assert.assertEquals(postTitle, blogPage.getPostTitleOnBlogPage());

    }

    @Test
    public void goingToCommentsSectionByClickOnClickHereLink() throws IOException {

        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        BlogPage blogPage = homePage.goToBlogPage();
        waitFor(2);
        blogPage.clickOnClickHereLink();
        waitFor(3);
        WebElement newFrame = getDriver().findElement(By.id("dsq-app1"));
        getDriver().switchTo().frame(newFrame);
        Assert.assertEquals("Powered by Disqus", blogPage.getTitleOfDisqus());

    }
    @Test
    public void clickingOnTagChecking() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        BlogPage blogPage = homePage.goToBlogPage();
        waitFor(3);
        String tagName = blogPage.getTagName();
        blogPage.clickingOnTag(tagName);
        waitFor(3);
        Assert.assertEquals("Tag: "+tagName+"", blogPage.getTitle());

    }
    @Test
    public void clickingOnAuthorChecking() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        BlogPage blogPage = homePage.goToBlogPage();
        waitFor(3);
        blogPage.closeSendUpdates();
        String authorName = blogPage.getAuthorName();
        blogPage.clickingOnAuthor(authorName);
        waitFor(3);
        Assert.assertEquals("Author: "+authorName+"", blogPage.getTitle());

    }


}
