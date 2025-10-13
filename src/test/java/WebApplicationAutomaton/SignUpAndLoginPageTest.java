package WebApplicationAutomaton;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpAndLoginPageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Launch the browser(chrome)
		//ChromeDriver driver =  new ChromeDriver();
		WebDriver driver = new ChromeDriver();
		
		//*2. Open URL https://demo.opencart.com/
		driver.get("https://automationexercise.com/");
		
		 // 3. Maximize window
        driver.manage().window().maximize();
		
		//Thread.sleep(10000);
		//Find Login Page
//		WebElement LoginPage = driver.findElement(By.linkText("Signup / Login"));
//		LoginPage.click();
		 driver.findElement(By.linkText("Signup / Login")).click(); //Single Step
		
		
		try {
            Thread.sleep(2000); // Use WebDriverWait in real projects
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		//Validate that weather it Login Page or Not
		String act_title = driver.getTitle();
		if(act_title.equals("Automation Exercise - Signup / Login"))
				{
			 System.out.println("✅ Login page opened successfully");
				}
		else {
			System.out.println("❌ Failed to open Login page");
		}
		
		//Let's Verify 'New User Signup!' is visible
		
		//1. Locate the heading
		  WebElement heading = driver.findElement(By.xpath("//*[text()='New User Signup!']"));
		  
		  //2.Validate the heading
		  
		  String act_Heading = heading.getText();
		  String Exp_Heading = "New User Signup!";
		  
		  if(act_Heading.equals(Exp_Heading))
		  {
			  System.out.println("✅ Heading verified: " + act_Heading);
			// Enter Name
			  WebElement signupName = driver.findElement(By.cssSelector("[data-qa='signup-name']"));
			  signupName.sendKeys("Prashant Sharma");

			  // Enter Email
			  WebElement signupEmail = driver.findElement(By.cssSelector("[data-qa='signup-email']"));
			  signupEmail.sendKeys("prashant@gmail.com");

			  // Click Signup Button
			  WebElement signupButton = driver.findElement(By.xpath("//button[text()='Signup']"));
			  signupButton.click();
			  
	        } else {
	            System.out.println("❌ Heading mismatch. Found: " + act_Heading);
	        }
	      
		 WebElement heading1 = driver.findElement(By.tagName("h2"));
	        System.out.println("Heading after signup is: " + heading1.getText());
	        
	        //This is the example of tag.className for CSS Selector
//	        WebElement heading2 = driver.findElement(By.cssSelector("h2.title"));
//	        System.out.println("Heading after signup is: " + heading2.getText());
//	        
	        
	        //Find the tittle and click on Mr using tag#ClassName
	        driver.findElement(By.cssSelector("input#id_gender1")).click();
	        
	        //Sending the Name but first clering the autofill Name
	        driver.findElement(By.cssSelector("input#name")).clear();
	        
	        driver.findElement(By.cssSelector("input#name")).sendKeys("Prashant Sharma");

	        //Sending the Email 
//	        driver.findElement(By.cssSelector("input#email")).clear();
//	        driver.findElement(By.cssSelector("input#email")).sendKeys("prashant@gmail.com");
        
	   
	        //To Select Date OF birth we will use select class
	        //Day
	        Select DayDropDown = new Select(driver.findElement(By.name("days")));
	        DayDropDown.selectByContainsVisibleText("15");
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	        //Month
	        Select MonthDropDown = new Select(driver.findElement(By.name("months")));
	        MonthDropDown.selectByContainsVisibleText("April");
	        
	       wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	        //Year
	        Select YearDropDown = new Select(driver.findElement(By.name("years")));
	        YearDropDown.selectByContainsVisibleText("2011");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        
	        //Click the checkBOX
	        driver.findElement(By.cssSelector("input#newsletter")).click();
	        driver.findElement(By.cssSelector("input#optin")).click();
	        
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
