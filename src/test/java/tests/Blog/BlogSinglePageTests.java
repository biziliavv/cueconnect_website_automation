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
    public void recentPostChecking() throws IOException, InterruptedException {

        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();
        blogPage.openPostByClickOnTitle();
        String postTitle = blogPage.getTitleOfRecentOfPost();
        blogPage.clickOnRecentPostLink();
        Assert.assertEquals(postTitle, blogPage.getPostTitleOnBlogPage());
    }

    @Test
    public void findMeOnChecking() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();
        blogPage.openPostByClickOnTitle();
        blogPage.findMeOnClicking();
        blogPage.switchingBetweenTabs(1);
        String openedUrl = getDriver().getCurrentUrl();
        Assert.assertTrue(openedUrl.contains("twitter.com"));
        getDriver().close();
        blogPage.switchingBetweenTabs(0);


    }

    @Test
    public void socialSharingIconsChecking() throws InterruptedException, IOException {
        HomePageObject homePage = new HomePageObject();
        BlogPage blogPage = homePage.goToBlogPage();
        blogPage.openPostByClickOnTitle();
        blogPage.socialNetworksClickOnIcon();
    }
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
        Assert.assertEquals("Email is required", blogPage.getValidationMessages());

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
}
