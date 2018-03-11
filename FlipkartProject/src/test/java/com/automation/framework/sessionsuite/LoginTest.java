package com.automation.framework.sessionsuite;


import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.framework.BaseTest;
import com.automation.framework.Keywords;

import com.automation.framework.util.Constants;
import com.automation.framework.util.DataUtil;
import com.automation.framework.util.ExtentManager;
import com.automation.framework.util.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends BaseTest{
	
	
	
	@BeforeTest
	public void init(){
		xls = new Xls_Reader(Constants.SessionSuite_XLS);
		testName = "LoginTest";
	}
	
	
	@Test(dataProvider="getData")
	public void loginTest(Hashtable<String,String> data){
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, data.toString());
		
		if(DataUtil.isSkip(xls, testName) || data.get("Runmode").equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is N");
			throw new SkipException("Skipping the test as runmode is N");
		}
		
		test.log(LogStatus.INFO, "Starting "+testName);
		
		app = new Keywords(test);
		test.log(LogStatus.INFO, "Executing keywords");
		app.executeKeywords(testName, xls,data);
		// add the screenshot
		//app.getGenericKeyWords().reportFailure("xxxx");
		test.log(LogStatus.PASS, "PASS");
		app.getGenericKeyWords().takeScreenShot();
	}
	
	
}
