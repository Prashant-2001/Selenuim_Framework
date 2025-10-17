package WebApplicationAutomaton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWithCorrectUserAndPassTest {

	public static void main(String[] args) {
		
		
		//To Launch the website
		WebDriver driver = new ChromeDriver();
		driver.get("https://automationexercise.com");
		
		//To Maximize the window
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Signup / Login")).click();
		
		 
		  //2.Validate the heading
		WebElement heading = driver.findElement(By.cssSelector("div.login-form h2"));
		  
		  String act_Heading = heading.getText();
		  String Exp_Heading = "Login to your account";
		  
		  if(act_Heading.equals(Exp_Heading))
		  {
			  System.out.println("✅ Heading verified: " + act_Heading);
			// Enter Email
			  WebElement LoginName = driver.findElement(By.cssSelector("[data-qa='login-email']"));
			  LoginName.sendKeys("prashants9@gmail.com");
			  
			  //Enter Password
			  WebElement pass = driver.findElement(By.cssSelector("[data-qa='login-password']"));
			  pass.sendKeys("prashant@");


			  // Click Login Button
			  WebElement LoginButton = driver.findElement(By.cssSelector("[data-qa='login-button']"));
			  LoginButton.click();
			  
	        } else {
	            System.out.println("❌ Heading mismatch. Found: " + act_Heading);
	        }
	      
		 WebElement heading1 = driver.findElement(By.tagName("h2"));
	        System.out.println("Heading after signup is: " + heading1.getText());
	        
	        WebElement loggedInElement = driver.findElement(By.cssSelector("a i.fa-user")).findElement(By.xpath("./.."));
	        String actualText = loggedInElement.getText().trim();
	        
	        if(actualText.equals("Logged in as Prashant Sharma"))
	        {
	        	System.out.println("Test Passed!");
	        }
	        else
	        {
	        	System.out.println("Test Failed!");
	        }
	        
	        //Delete the account
	        
	      driver.findElement(By.cssSelector("a[href='/delete_account'][style*='color:brown']")).click();
	      
	      WebElement successMessage = driver.findElement(By.cssSelector("h2[data-qa='account-deleted']"));
	       String actualtext = successMessage.getText().trim();
	       System.out.println(actualText);
	       
	    // Verify the text contains expected message
	       if (actualtext.contains("ACCOUNT DELETED")) {
	           System.out.println("TEST CASE PASSED: Account deletion is successful");
	       } else {
	           System.out.println("TEST CASE FAILED: Account Deleteed message not found");
	           throw new AssertionError("Expected 'Account Deleted!' but got: " + actualText);
	       }
	       try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			


	       driver.quit();
	}

}
