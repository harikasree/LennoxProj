package com.lnx.pageobjects;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lnx.utils.*;

//import com.relevantcodes.extentreports.LogStatus;

public class AddLeadPage {

	public WebDriver driver;
	public WebDriverWait wdwait;
	
	ExcelUtil objExcelUtil;
	HomePage objHomePage;
	
	 @FindBy(how=How.XPATH, using = "//div[@class='col-sm-9 align-right']/a/span[contains(.,\"ADD LEAD\")]")
	 private WebElement addLead;
	 
	 @FindBy(how=How.XPATH, using = "//button[@id=\"btn-addLeadsForm\"]")
	 private WebElement saveLeadBtn;
	
	 
	 @FindBy(how=How.ID, using = "firstName")
	 private WebElement txtFirstname;
	 
	 @FindBy(how=How.ID, using = "lastName")
	 private WebElement txtLastname;
	 
	 @FindBy(how=How.ID, using = "phNo")
	 private WebElement txtPhoneNum;
	 
	 @FindBy(how=How.ID, using = "email")
	 private WebElement txtEmail;
	 
	 @FindBy(how=How.ID, using = "calender1")
	 private WebElement calenderDate;
	 
	 @FindBy(how=How.XPATH, using = "//div[@class='leads-uploads-add']/p[contains(.,\"Add Document\")]")
	 private WebElement addDocument;

	 @FindBy(how=How.XPATH, using = "//div[@class='leads-uploads-add']/p[contains(.,\"Add Image\")]")
	 private WebElement addImage;
	 
	 public AddLeadPage(WebDriver driver) 
	   {
//		     super(report);
			 this.driver=driver;
			 wdwait=new WebDriverWait(driver, 20);
		     PageFactory.initElements(driver, this);
	   }
	 
	 public void enterUsername(String userName){
		 txtFirstname.clear();
		 txtFirstname.click();
		 txtFirstname.sendKeys(userName);
//	    	report.log(LogStatus.PASS, "Entered Username is: "+userName);
	    }
	 
	 public void enterLastname(String lastName){
		 txtLastname.clear();
		 txtLastname.click();
		 txtLastname.sendKeys(lastName);
//	    	report.log(LogStatus.PASS, "Entered Username is: "+userName);
	    }
	 
	 public void enterPhoneNum(String phoneNum){
		 txtPhoneNum.clear();
		 txtPhoneNum.click();
		 txtPhoneNum.sendKeys(phoneNum);
//	    	report.log(LogStatus.PASS, "Entered Username is: "+userName);
	    }
	 
	 public void enterEmail(String email){
		 txtEmail.clear();
		 txtEmail.click();
		 txtEmail.sendKeys(email);
//	    	report.log(LogStatus.PASS, "Entered Username is: "+userName);
	    }
	 
	 public void enterDate(String date){
		 calenderDate.sendKeys(date);
//	    	report.log(LogStatus.PASS, "Entered Username is: "+userName);
	    }
	 
	 public void submitLead() throws InterruptedException, IOException {

		 addLead.click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 enterUsername(ExcelUtil.testData("firstName"));
		 enterLastname(ExcelUtil.testData("lastName"));
		 enterPhoneNum(ExcelUtil.testData("phoneNum"));
		 enterEmail(ExcelUtil.testData("email"));
//		 enterDate(ExcelUtil.testData("date"));
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 saveLeadBtn.click();

	 }
}
