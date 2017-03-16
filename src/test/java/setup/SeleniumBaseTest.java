package setup;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static setup.SeleniumDriver.driver;
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


    @BeforeSuite
//Parameter will get browser from testng.xml on which browser test to run
    @Parameters("myDevice")
    public void beforeClass(@Optional("desktop") String myDevice) throws IOException {
        FileInputStream inStream;
        inStream = new FileInputStream(new File("properties/BaseProperties.properties"));
        Properties prop = new Properties();
        prop.load(inStream);
        switch (myDevice) {
            case "desktop":

                String resolution = prop.getProperty("desktop_res");
                String[] parts = resolution.split("x");

                // Screen resolution
                Dimension screenRes = new Dimension(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));

                // Set browser resolution
                getDriver().manage().window().setSize(screenRes);
                break;
            case "nexus6":

                resolution = prop.getProperty("nexus6_res");
                parts = resolution.split("x");

                // Screen resolution
                screenRes = new Dimension(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));

                // Set browser resolution
                getDriver().manage().window().setSize(screenRes);
                break;
            case "iphone7":
                resolution = prop.getProperty("iphone7_res");
                parts = resolution.split("x");

                // Screen resolution
                screenRes = new Dimension(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));

                // Set browser resolution
                getDriver().manage().window().setSize(screenRes);
            default:

                break;
        }

    }
}





