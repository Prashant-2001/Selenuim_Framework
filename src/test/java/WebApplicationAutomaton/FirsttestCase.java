package WebApplicationAutomaton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * Test Case
 * ------------------
 * 1. Launch Browser
  *2. Open URL https://demo.opencart.com/
  *3. Validate title should be  "Your Store"
  *4. Close Browser
  -------------------
 */

public class FirsttestCase {

	public static void main(String[] args) throws InterruptedException {
		
		
		//Launch the browser(chrome)
		//ChromeDriver driver =  new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		
		//*2. Open URL https://demo.opencart.com/
		driver.get("https://automationexercise.com/");
		
		//Thread.sleep(10000);
		
		//3. Validate title should be  "Your Store"
		
		String act_title = driver.getTitle();
		if(act_title.equals("Automation Exercise"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
//	 WebElement logo = driver.findElement(By.className("logo"));
//	 boolean status = logo.isDisplayed();
//	 System.out.println("Display STatus is: " + status);
//	 
	 boolean status = driver.findElement(By.className("logo")).isDisplayed();
	 
	 System.out.println("Display STatus is: " + status);
	 
	 
	 //Link test and Partial Link Test
	 driver.findElement(By.partialLinkText("Products")).click(); //LinkText Locator
	 
	 //Capture all the link in web application
	 java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
	 System.out.println("Total Links is " +links.size());
	 
	//Total Number of images
	 java.util.List<WebElement> images = driver.findElements(By.tagName("img"));
	 System.out.println("Total number of images is " +images.size());

		//*4. Close Browser*8
		driver.quit();
		
		

	}

}
