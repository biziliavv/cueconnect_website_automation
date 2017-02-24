package setup;

import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;


import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.getDriver;

/**
 * SeleniumBaseTest
 *
 * Created by vitaliybizilia on 2/23/17.
 */
public class SeleniumBaseTest {
    @AfterSuite
    public static void tearDown() {
        getDriver().close();
    }


}
