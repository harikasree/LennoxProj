package com.lnx.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public WebDriver driver;
	
//	static ExtentTest report;
//	static ExtentReports testreports;
	

	
	 @FindBy(how=How.XPATH, using = "//div/a[text()='Sign In']")
	 private WebElement signInBtnLandingPage;
	 
	 
	 public void clickSignIn(){
		 signInBtnLandingPage.click();
	    	
//	    	report.log(LogStatus.PASS, "Clicked SignIn button");
	    }
	
	 @FindBy(how=How.ID, using = "j_username")
	 private WebElement txtUsername;
   
   @FindBy(how=How.ID, using = "j_password")
   private WebElement txtPassword;
   
   @FindBy(how=How.ID, using = "loginSubmit")
 //button[contains(@message,'LOGIN')]
   private WebElement btnSignIn;
   
//   @FindBy(how=How.LINK_TEXT, using = "forgotLink")
//   private WebElement lnkForgotPassword;
//   
//   @FindBy(how=How.ID, using = "Languages")
//   private WebElement selectLanguage;
   
   public WebDriverWait wdwait;
   
   public void enterUsername(String userName){
   	txtUsername.clear();
   	txtUsername.click();
   	txtUsername.sendKeys(userName);
//   	report.log(LogStatus.PASS, "Entered Username is: "+userName);
   }
   
   public void enterPassword(String passWord){
   	txtPassword.clear();
   	txtPassword.click();
   	txtPassword.sendKeys(passWord);
//   	report.log(LogStatus.PASS, "Entered Password is: "+passWord);
   }
   
   public void clickSignInButton(){
   	btnSignIn.click();
//       report.log(LogStatus.PASS, "Clicked on Sign in Button");
   }
   
   
//   public LoginPage(WebDriver driver, ExtentTest report) throws InterruptedException 
   public LoginPage(WebDriver driver) 
   {
//	     super(report);
		 this.driver=driver;
		 wdwait=new WebDriverWait(driver, 20);
	     PageFactory.initElements(driver, this);
   }
   
   public LoginPage loginToLennoxSite(String username, String password) throws InterruptedException
   {
	    if (!(username == null || username.isEmpty())) {
	    	enterUsername(username);
	    }
	    if (!(password == null || password.isEmpty())) {
	      	enterPassword(password);
	    }
	    if (btnSignIn.isEnabled())
	    {
	    	//btnSignIn.click();
	    	((JavascriptExecutor) driver).executeScript("arguments[0].click();",btnSignIn);
//	       	report.addScreenCapture(Screenshot.takeScreenshotX(driver, "HomePage", context));
	    } 
//	        return new LoginPage(driver,report);
	        return new LoginPage(driver);
   } 
	
}
