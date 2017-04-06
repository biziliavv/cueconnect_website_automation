package tests.Blog;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Blog.BlogPage;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;

import java.io.IOException;

import static setup.SeleniumDriver.getDriver;

/**
 * Created by vitaliybizilia on 3/3/17.
 */
public class BlogSinglePageTests extends SeleniumBaseTest {

    @Test
    public void recentPostChecking() throws IOException {

        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        BlogPage blogPage = homePage.goToBlogPage();
        blogPage.openPostByClickOnTitle();
        String postTitle = blogPage.getTitleOfRecentOfPost();
        blogPage.clickOnRecentPostLink();
        Assert.assertEquals(postTitle, blogPage.getPostTitleOnBlogPage());
    }

    @Test
    public void findMeOnChecking() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        BlogPage blogPage = homePage.goToBlogPage();
        waitFor(3);
        blogPage.openPostByClickOnTitle();
        waitFor(3);
        blogPage.findMeOnClicking();
        waitFor(3);
        blogPage.switchingBetweenTabs(1);
        String openedUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(openedUrl.contains("twitter.com"));
        getDriver().close();
        blogPage.switchingBetweenTabs(0);


    }

    @Test
    public void socialSharingIconsChecking() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        BlogPage blogPage = homePage.goToBlogPage();
        blogPage.openPostByClickOnTitle();
        blogPage.socialNetworksClickOnIcon();
    }
    @Test
    public void subscribeToValidEmail() throws IOException {

        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        BlogPage blogPage = homePage.goToBlogPage();
        blogPage.fillingInEmailForUpdates("test@test.com");
        Assert.assertEquals("Thank you for subscribing!", blogPage.getValidEmailMessage());


    }

    @Test
    public void subscribeToEmptyEmail() throws IOException {

        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        BlogPage blogPage = homePage.goToBlogPage();
        Assert.assertEquals("Cue Connect Blog", blogPage.getTitle());
        Assert.assertTrue(blogPage.getPageImage("2394", "643"));
        blogPage.fillingInEmailForUpdates("");
        Assert.assertEquals("Email is required", blogPage.getValidationMessages());

    }
    @Test
    public void subscribeToWrongEmailWithoutAt() throws IOException {

        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        BlogPage blogPage = homePage.goToBlogPage();
        blogPage.fillingInEmailForUpdates("test");
        Assert.assertEquals("Email must be formatted correctly.", blogPage.getValidationMessages());

    }
    @Test
    public void subscribeToWrongEmailWithAt() throws IOException {

        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        BlogPage blogPage = homePage.goToBlogPage();
        waitFor(3);
        blogPage.fillingInEmailForUpdates("test@test");
        Assert.assertEquals("Please enter a valid email address.", blogPage.getValidationMessages());

    }

    @Test
    public void checkSocialNetworkButton() throws IOException {
        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        BlogPage blogPage = homePage.goToBlogPage();
        blogPage.scrollDown();
        blogPage.clickOnSocialNetworkButton();

    }

    @Test
    public void openingPostByClickOnTitle() throws IOException {

        HomePageObject homePage = new HomePageObject();
        waitFor(3);
        BlogPage blogPage = homePage.goToBlogPage();
        String postTitle = blogPage.getPostTitleOnMainBlog();
        blogPage.openPostByClickOnTitle();
        waitFor(3);
        Assert.assertEquals(postTitle, blogPage.getPostTitleOnBlogPage());

    }
}
