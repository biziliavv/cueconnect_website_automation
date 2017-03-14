package setup;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
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

    public static void waitFor(Integer seconds) {
        getDriver().manage().timeouts().setScriptTimeout(seconds, TimeUnit.SECONDS);
    }

    }





