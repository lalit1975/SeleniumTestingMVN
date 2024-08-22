package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {

	public static String browser = "chrome";
	public static WebDriver driver;
	

	public static void main(String[] args) {

		/*
		 * Latest jar selenium latest browser latest browser executable
		 * 
		 * Maven - Globally, Project - Selenium + WebDriverManager dependency
		 * mvnrepository.com
		 * 
		 * /
		 */
		// System.setProperty("webdriver.gecko.driver",
		// "F:\\selenium-prerequisite\\geckodriver-v0.26.0-win64_3\\geckodriver.exe");

		if (browser.equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		driver.quit(); // current browser

	}

}
