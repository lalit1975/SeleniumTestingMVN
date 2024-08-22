package regression;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {
	
	
	@Test
	public void validateTitles() {
		
		
	
	
		String expected = "Gmail.com";
		String actual = "Gmail.com";
		
		
	/*	if(expected.equals(actual)) {
			
			System.out.println("Test case pass");
		}else {
			
			System.out.println("Test case fail");
		}*/
		System.out.println("Beginning !!!");
		
		
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(actual, expected);
		
		
		
		softAssert.assertTrue(false,"Submit button not found !!!");
		
		softAssert.fail("Failing the test as the condition is not met");
	
	
		System.out.println("Ending !!!");
		
		softAssert.assertAll();
		
		}

	
	
}
