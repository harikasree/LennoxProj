package com.lnx.pageobjects;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.lnx.utils.*;

public class HomePage {

	public WebDriver driver;
	public WebDriverWait wdwait;
	ExcelUtil objExcelUtil;
	
	 @FindBy(how=How.XPATH, using = "//div/a/i[@class =\"far fa-bars v2-hamburger-menu\"]")
	 private WebElement menuIcon;

//	 @FindBy(how=How.XPATH, using = "//div[@class='v2-hamburger-menu-flyout toggle-open']/div/div/div/a[contains(.,'Sales Tools')]")
//	 private WebElement mainMenu;
	 
//	 @FindBy(how=How.XPATH, using = "//div[@class='row flyout-container']/div/div/div/a[contains(.,'Build a Proposal')]")
//	 private WebElement secondaryMenu;
	 
	 @FindBy(how=How.XPATH, using = "//div[@class='moby-inner']")
	 private WebElement switchToPopup;
	 
	 @FindBy(how=How.XPATH, using = "//div[@class='button-set']/a[contains(.,'SELECT LEAD')]")
	 private WebElement leadPopupOption;
	 
	 public HomePage(WebDriver driver) 
	   {
//		     super(report);
			 this.driver=driver;
			 wdwait=new WebDriverWait(driver, 20);
		     PageFactory.initElements(driver, this);
	   }
	 
	 public void navigateMenu() throws InterruptedException, IOException {
		 menuIcon.click();
		 //Value of'step1' and 'step2' below is given in excel sheet
		 String menuStep1 = ExcelUtil.menuData("step1");
		 WebElement mainMenu = driver.findElement(By.xpath("//div[@class='v2-hamburger-menu-flyout toggle-open']/div/div/div/a[contains(.,'"+menuStep1+"')]"));
		 mainMenu.click();
		 
		 String menuStep2 = ExcelUtil.menuData("step2");
		 WebElement secondaryMenu = driver.findElement(By.xpath("//div[@class='row flyout-container']/div/div/div/a[contains(.,'"+menuStep2+"')]"));
		 secondaryMenu.click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.switchTo().activeElement();
		 wdwait.until(ExpectedConditions.visibilityOf(switchToPopup));
		 Thread.sleep(1000);

		 leadPopupOption.click();

	 }

}
