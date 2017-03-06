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
}
