package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTryIt {

	public static WebDriver driver;

	public static void captureScreenshot() {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("./screenshot/" + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void captureElementScreenshot(WebElement element) {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("./screenshot/" + "Element_"+fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().frame("iframeResult"); // switch to a frame without id???
		// driver.findElement(By.xpath("/html/body/button")).click();

		((JavascriptExecutor) driver).executeScript("myFunction()");

		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
				driver.findElement(By.xpath("//*[@id=\"mySubmit\"]")));

		
		captureElementScreenshot(driver.findElement(By.xpath("//*[@id=\"mySubmit\"]")));
		
		
		driver.switchTo().defaultContent();

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));

		System.out.println(frames.size());

		captureScreenshot();

		for (WebElement frame : frames) {

			System.out.println(frame.getAttribute("id"));

		}

	}

}
