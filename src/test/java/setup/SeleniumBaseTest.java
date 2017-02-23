package setup;

import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;


import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.getDriver;

/**
 * SeleniumBaseTest
 *
 * Created by vitaliybizilia on 2/23/17.
 */
public class SeleniumBaseTest {
    @AfterClass
    public static void tearDown() {
        getDriver().close();
    }


}
