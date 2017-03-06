package tests.Blog;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.Blog.CueAcademyPage;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;

import java.io.IOException;

/**
 * Created by vitaliybizilia on 3/6/17.
 */
public class CueAcademyPageTests extends SeleniumBaseTest {

    @Test
    public void openingItemFromListByClickingOnPicture() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        CueAcademyPage cueAcademyPage = homePage.goToCueAcademy();
        Thread.sleep(5000);
        String itemText = cueAcademyPage.getItemTitle();
        cueAcademyPage.openItemByClickingOnPicture();
        Thread.sleep(3000);
        Assert.assertEquals(itemText, cueAcademyPage.getOpenedItemTitle());

    }
    @Test
    public void openingItemFromListByClickingOnReadMore() throws IOException, InterruptedException {
        HomePageObject homePage = new HomePageObject();
        CueAcademyPage cueAcademyPage = homePage.goToCueAcademy();
        Thread.sleep(5000);
        String itemText = cueAcademyPage.getItemTitle();
        cueAcademyPage.openItemByClickOnReadMoreButton();
        Thread.sleep(3000);
        Assert.assertEquals(itemText, cueAcademyPage.getOpenedItemTitle());

    }
}
