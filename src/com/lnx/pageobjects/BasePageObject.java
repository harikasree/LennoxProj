package com.lnx.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.ebs.properties.ExecutionContext;
//import com.relevantcodes.extentreports.ExtentTest;

public abstract class BasePageObject {
//	 protected ExecutionContext context;
//	    protected ExtentTest report;
	    public WebDriver driver;
	    public WebDriverWait wdwait;

//	    protected BasePageObject(ExtentTest report) {
//	        this.context = ExecutionContext.getInstance();
//	        this.report = report;
//	    }
	    public abstract boolean isDisplayed();
}
