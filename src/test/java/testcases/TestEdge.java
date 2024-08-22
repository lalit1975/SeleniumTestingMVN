package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestEdge {

	public static void main(String[] args) {


		WebDriverManager.iedriver().setup();
		
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://gmail.com");
		
		

	}

}
