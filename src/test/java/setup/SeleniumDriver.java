package setup;

import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Selenium driver wrapper
 *
 * Created by vitaliybizilia on 2/23/17.
 */
public class SeleniumDriver {

	public static WebDriver driver;

	public static final String USERNAME = "cueconnect1";
	public static final String AUTOMATE_KEY = "ySePmTqAPesNaqv4CxYa";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static WebDriver getDriver(){
		if (driver == null) {


			/*System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver = new ChromeDriver();*/

			/*ChromeOptions options = new ChromeOptions();

			HashMap<String, Object> chromePref = new HashMap();

			chromePref.put("download.default_directory", "download");
			options.setBinary("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");

			options.setExperimentalOption("prefs", chromePref);*/

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("browser", "Chrome");
			caps.setCapability("browser_version", "57.0");
			caps.setCapability("os", "OS X");
			caps.setCapability("os_version", "El Capitan");
			caps.setCapability("resolution", "1280x960");


			try {
				driver = new RemoteWebDriver(new URL(URL), caps);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


					}
		return driver;
	}

}
