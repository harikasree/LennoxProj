package com.lnx.tests;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.lnx.pageobjects.*;
import com.lnx.utils.Environments;
import com.lnx.utils.ExcelUtil;

public class TC_lnx_addLead {
	
	WebDriver driver;
	
	LoginPage objLoginPage;
	HomePage objHomePage;
	AddLeadPage objAddLeadPage;
	Environments objEnvironments;
	ExcelUtil objExcelUtil;
	

	@BeforeTest
	public void setup() throws IOException {
		
		
		
		System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"//drivers//chromedriver.exe"));
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objEnvironments = new Environments();
		driver.get(objEnvironments.getEnvironmentsProperty("url"));

			
	}
	
	@Test(priority=1)
	public void navigateToLoginScreen() {
		objLoginPage = new LoginPage(driver);
		objLoginPage.clickSignIn();
	}
	
	@Test(priority=2)
	public void loginToLennox() throws InterruptedException {
		objLoginPage.loginToLennoxSite("lenproautomation8@lenqat.com", "Community17");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(priority=3)
	public void menuNavigation() throws InterruptedException, IOException {
		objHomePage = new HomePage(driver);
		objHomePage.navigateMenu();
	}
	
	@Test(priority=4)
	public void addLeadandSave() throws InterruptedException, IOException {
		objAddLeadPage = new AddLeadPage(driver);
		objAddLeadPage.submitLead();
//		System.out.println(objExcelUtil.testData(null));
		
	}
	
}
