package testcases;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabsandPopups {

	public static void main(String[] args) {



		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://paytm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
		/*
		 * 0 - abc1
		 * 1 - xyz1
		 * 2 - abc1
		 * 
		 * 
		 */
		
		System.out.println("---Generating window ids from first window---");
		
		Set<String> winids = driver.getWindowHandles();
		Iterator<String> iterate = winids.iterator(); //first
		
		String first_window = iterate.next(); //1st
		System.out.println(first_window);
		
		
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/span[6]/span")).click();
		
	
		
		
		System.out.println("---Generating window ids from second window---");
		
	
		
		winids = driver.getWindowHandles();
		iterate = winids.iterator();
		
		System.out.println(iterate.next()); //1st
		String second_window = iterate.next(); //2nd
		System.out.println(second_window);
		
		
		
		
		
		driver.switchTo().window(second_window);
		driver.findElement(By.xpath("//*[@id=\"search\"]")).sendKeys("1234");
	/*	
		driver.close(); //2nd
		driver.switchTo().window(first_window);
		driver.close();*/
		
		driver.quit();
		
	}

}
