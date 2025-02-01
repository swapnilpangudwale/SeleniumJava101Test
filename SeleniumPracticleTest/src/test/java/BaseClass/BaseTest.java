package BaseClass;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	// public static WebDriver driver;

	public static Properties prop = new Properties();
	public static Properties locator = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	public static RemoteWebDriver driver = null;
	ChromeOptions browserOptions = new ChromeOptions();

	@BeforeClass
	public void setup() throws IOException, InterruptedException

	{

		String username = "pangudwales05";
		String authkey = "SSkNAfekTdDBMdjiIJhRd33uy7GyhiV8sCIi4yIuu6zikmoUtw";
		String hub = "@hub.lambdatest.com/wd/hub";

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platform", "MacOS Catalina");
		caps.setCapability("browserName", "Safari");
		caps.setCapability("version", "latest");
		caps.setCapability("build", "TestNG With Java");
		caps.setCapability("visual", true);
		caps.setCapability("video", true);
		caps.setCapability("resolution", "2560x1440");
		caps.setCapability("network", true);
		caps.setCapability("build", "SeleniumJava101");
		caps.setCapability("project", "SeleniumJava101Certification");
		caps.setCapability("name", "TC_03_validateInputFromSubmit");
		caps.setCapability("w3c", true);
		caps.setCapability("plugin", "java-testNG");

		driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);

		fr = new FileReader(System.getProperty("user.dir") + "/src/test/resources/configfiles/config.properties");
		fr1 = new FileReader(System.getProperty("user.dir") + "/src/test/resources/configfiles/Locator.properties");
		prop.load(fr);
		locator.load(fr1);

		if (prop.getProperty("browser").equalsIgnoreCase("Chrome")) {

			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.whitelistedIps", "");
			browserOptions.addArguments("--remote-allow-origins=*");
			// driver = new ChromeDriver(browserOptions);
			Thread.sleep(1000);
			driver.get(prop.getProperty("testUrl"));
			driver.manage().window().maximize();
			Thread.sleep(1000);

		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new FirefoxDriver(options);
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
			driver.get(prop.getProperty("testUrl"));
			driver.manage().window().maximize();
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
