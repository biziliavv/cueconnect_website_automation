package setup;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Selenium driver wrapper
 *
 * Created by vitaliybizilia on 2/23/17.
 */
public class SeleniumDriver {

	public static WebDriver driver;


	public static WebDriver getDriver() {
		if (driver == null) {

			//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

			/*ChromeOptions options = new ChromeOptions();

			HashMap<String, Object> chromePref = new HashMap();

			chromePref.put("download.default_directory", "download");
			options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");

			options.setExperimentalOption("prefs", chromePref);
			driver = new ChromeDriver(options);*/
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "drivers/phantomjs");
			driver = new PhantomJSDriver();


			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


					}
		return driver;
	}

}
