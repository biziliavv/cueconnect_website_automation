package setup;

import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.getDriver;

/**
 * SeleniumBaseTest
 *
 * Created by vitaliybizilia on 2/23/17.
 */
public class SeleniumBaseTest {


  /*  @BeforeMethod
    public static void setUp() {
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }*/
    @AfterSuite
    public static void tearDown() {
        getDriver().close();
    }


}
