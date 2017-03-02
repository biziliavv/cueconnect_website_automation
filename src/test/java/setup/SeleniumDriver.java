package setup;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.awt.*;
import java.awt.Dimension;
import java.util.HashMap;

/**
 * Selenium driver wrapper
 *
 * Created by vitaliybizilia on 2/23/17.
 */
public class SeleniumDriver {

	public static WebDriver driver;


	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			ChromeOptions options = new ChromeOptions();

			HashMap<String, Object> chromePref = new HashMap();

			chromePref.put("download.default_directory", "download");

			options.setExperimentalOption("prefs", chromePref);
			driver = new ChromeDriver(options);
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			org.openqa.selenium.Dimension screenResolution = new org.openqa.selenium.Dimension((int)
					toolkit.getScreenSize().getWidth(), (int)
					toolkit.getScreenSize().getHeight());

			driver.manage().window().setSize(screenResolution);


		}
		return driver;
	}

}
