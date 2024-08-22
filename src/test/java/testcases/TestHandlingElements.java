package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHandlingElements {

	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		
		/*String title = driver.getTitle();
		System.out.println(title.length());*/
		
		driver.getTitle().length();
		driver.manage().window().maximize();
		
		/*
		WebElement username = driver.findElement(By.id("identifierId"));
		username.sendKeys("trainer@way2automation.com");
		
		WebElement nxtBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span"));
		nxtBtn.click();*/
		//driver.manage().window().maximize();
		
		driver.findElement(By.id("identifierId")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"))).sendKeys("sdfsdff");
		
		
		//driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("asdfsfdsf");
		
		
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span")).getText());
	}	

}
