package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.BlogPage;
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
        Assert.assertTrue(blogPage.getPageImage("1795", "482"));
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

        blogPage.clickOnSocialNetworkButton("facebook");
        blogPage.switchingBetweenTabs(1);
        Assert.assertTrue(blogPage.getPartOfLink("Facebook"));
        getDriver().close();
        blogPage.switchingBetweenTabs(0);
        Thread.sleep(3000);
        blogPage.clickOnSocialNetworkButton("twitter");
        blogPage.switchingBetweenTabs(1);
        Thread.sleep(3000);
        Assert.assertTrue(blogPage.getPartOfLink("Twitter"));
        getDriver().close();
        blogPage.switchingBetweenTabs(0);
        Thread.sleep(3000);
        blogPage.clickOnSocialNetworkButton("plusone");
        blogPage.switchingBetweenTabs(1);
        Thread.sleep(3000);
        Assert.assertTrue(blogPage.getPartOfLink("Google+"));
        getDriver().close();
        blogPage.switchingBetweenTabs(0);
        Thread.sleep(3000);
        blogPage.clickOnSocialNetworkButton("linkedin");
        blogPage.switchingBetweenTabs(1);
        Thread.sleep(3000);
        Assert.assertTrue(blogPage.getPartOfLink("linkedin"));
        getDriver().close();
        blogPage.switchingBetweenTabs(0);
        Thread.sleep(3000);
        blogPage.clickOnSocialNetworkButton("pinterest");
        blogPage.switchingBetweenTabs(1);
        Thread.sleep(3000);
        Assert.assertTrue(blogPage.getPartOfLink("Pinterest"));
        getDriver().close();
        blogPage.switchingBetweenTabs(0);
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



}
