package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {

	/*
	 * Log4j - dep Logger - getLogger - INFO, DEBUG, ERROR Log4j.properties -
	 * Appenders - PropertyConfigurator Console, HTML, File, Mail
	 * 
	 * 
	 */

	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(TestProperties.class.getSimpleName());

	public static void click(String locatorKey) {

		if (locatorKey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();
		} else if (locatorKey.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locatorKey))).click();
		}
		log.info("Clicking on an element : " + locatorKey);
	}

	public static void type(String locatorKey, String value) {

		if (locatorKey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).sendKeys(value);
		} else if (locatorKey.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);
		} else if (locatorKey.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locatorKey))).sendKeys(value);
		}

		log.info("Typing in an element : " + locatorKey + " entered value as : " + value);
	}

	public static void main(String[] args) throws IOException {

		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\log4j.properties");

		fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);
		log.info("OR Properties file loaded !!!");

		fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
		Config.load(fis);
		log.info("Config Properties file loaded !!!");

		// driver.findElement(By.cssSelector(OR.getProperty("username_CSS"))).sendKeys(username)
		System.out.println(OR.getProperty("username_CSS"));

		// driver.get(Config.getProperty("testsiteurl"))
		System.out.println(Config.getProperty("testsiteurl"));

		if (Config.getProperty("browser").equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome launched !!!");

		} else if (Config.getProperty("browser").equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox launched !!!");

		}

		driver.get(Config.getProperty("testsiteurl"));
		log.info("Navigated to : " + Config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);

		type("username_ID", "trainer@way2automation.com");
		click("nextBtn_XPATH");

		driver.quit();
		log.info("Test Execution completed !!!");
	}

}
