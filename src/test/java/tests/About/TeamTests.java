package tests.About;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.HomePageObject;
import setup.SeleniumBaseTest;

import java.io.IOException;

/**
 * Created by vitaliybizilia on 3/2/17.
 */
public class TeamTests extends SeleniumBaseTest {

    @Test
    public void checkingOfEmployeeQuote() throws IOException, InterruptedException {

        HomePageObject homePage = new HomePageObject();
        homePage.movingToMenuElement("About", "Team");
        homePage.moveToEmployeeAndWaitQuote();
        Assert.assertEquals("“If you wish to persuade me, you must think my thoughts, feel my feelings, and speak my words.”\n" +
                "— Cicero", homePage.getEmployeesQuote());
        Assert.assertTrue(homePage.getPageImage("478", "412"));
        Assert.assertEquals("Join & Build Something Great", homePage.getBigTitle());
        Assert.assertEquals("mailto:jobs@cueconnect.com?subject=Join%20cue", homePage.getJoinOurTeamLink());

    }

}
