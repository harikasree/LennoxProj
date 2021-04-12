package com.lnx.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//import com.relevantcodes.extentreports.LogStatus;

public class LandingPage {

	public WebDriver driver;
	
	 @FindBy(how=How.NAME, using = "Sign In")
	 private WebElement signInButton;
	 
	 
	 public void clickSignIn(String userName){
		 	signInButton.click();
	    	
//	    	report.log(LogStatus.PASS, "Clicked SignIn button");
	    }
}


