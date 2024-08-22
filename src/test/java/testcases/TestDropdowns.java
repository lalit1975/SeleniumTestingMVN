package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdowns {
	
	public static WebDriver driver;
	
	public static boolean isElementPresent(By by) {
		/*
		try {
		driver.findElement(By.xpath(xpathExpression));
		return true;
		}catch(Throwable t) {
			
			return false;
		}*/
	
		int size = driver.findElements(by).size();
	
		if(size==0) {
			
			return false;
		}else {
			
			return true;
		}
	}
	
	
	
	public static void main(String[] args) {


		/*
		 * 
		 * English - US
		 * English - UK
		 * 
		 * 
		 */
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.wikipedia.org/");
	//	driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]")).sendKeys("English");

		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]"));
		
		
		//System.out.println(dropdown.isDisplayed());
	/*	Select select = new Select(dropdown);
		
		
		//select.selectByVisibleText("English");
		select.selectByValue("hi");
		
		
		List<WebElement> values = dropdown.findElements(By.tagName("option"));
	
		System.out.println(values.size());
		
		System.out.println(values.get(7).getText());
		System.out.println(values.get(0).getAttribute("lang"));
	
	
		for(int i=0; i<values.size(); i++) {
			
			
			System.out.println(values.get(i).getAttribute("value"));
		}
	
		
		System.out.println("---Printing links-----");
		
		*/
		/*WebElement section = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[60]/div[3]"));
		*/
		System.out.println(isElementPresent(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[6]/div[3]")));
	//	System.out.println(section.isDisplayed());
		
		
		
		
		
	//	driver.findElement(By.xpath("//section[2]")).findElements(By.id("abc")).get(2).click();
		
	/*	
		List<WebElement> links = section.findElements(By.tagName("a"));
		
		
		System.out.println(links.size());
		
		for(WebElement link:links) {
			
			System.out.println(link.getText()+"  URL is : "+link.getAttribute("href"));
			
		}
		
		*/
		
	}

}
