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
    public void openingItemFromListByClickingOnPicture() throws IOException {
        HomePageObject homePage = new HomePageObject();
        CueAcademyPage cueAcademyPage = homePage.goToCueAcademy();
        waitFor(5);
        String itemText = cueAcademyPage.getItemTitle();
        cueAcademyPage.openItemByClickingOnPicture();
        waitFor(3);
        Assert.assertEquals(itemText, cueAcademyPage.getOpenedItemTitle());

    }
    @Test
    public void openingItemFromListByClickingOnReadMore() throws IOException {
        HomePageObject homePage = new HomePageObject();
        CueAcademyPage cueAcademyPage = homePage.goToCueAcademy();
        waitFor(5);
        String itemText = cueAcademyPage.getItemTitle();
        cueAcademyPage.openItemByClickOnReadMoreButton();
        waitFor(3);
        Assert.assertEquals(itemText, cueAcademyPage.getOpenedItemTitle());

    }
}
