package setup;

import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;


import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.getDriver;

/**
 * SeleniumBaseTest
 *
 * Created by vitaliybizilia on 2/23/17.
 */
public class SeleniumBaseTest {
    @AfterTest
    public static void tearDown() {
        getDriver().close();
    }


}
