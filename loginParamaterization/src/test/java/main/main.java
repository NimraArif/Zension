package main;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.base;
import loginParamaterization.loginTest;

public class main {
	loginTest login1;
		 base basech;
	  private WebDriver driver;		
		@BeforeTest
		public void launch() {
			  // Reporter.log("We are going to login");
			   driver = base.launchbowoser();
		        login1 = new loginTest(driver);
		        
		    }
		
		 @Test(priority = 0)
		    public void Successfull_Login() throws InterruptedException, IOException {
		  	  
			 login1.login_page();
		  	 String title = "Jarir E-Invoicing"; 
		  	 String actual = driver.getTitle();
		  	 
		 if(!title.equals(actual)) {
			 System.out.println("Failed!!!");
		
		 }
		 else {
			 System.out.println("PASS");
				
			 Reporter.log("Login is successfull");
		  	
		    }
      }
		    
}
