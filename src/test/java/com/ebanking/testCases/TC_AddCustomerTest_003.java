package com.ebanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.AddCustomerPage;
import com.ebanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		
		AddCustomerPage addcust= new AddCustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details...");
		

		addcust.custName("Bhuvana");
		addcust.custgender("female");
		addcust.custdob("01","27","1998");
		addcust.custaddress("INDIA");
		addcust.custcity("VJDA");
		addcust.custstate("AP");
		addcust.custpinno("500032");
		addcust.custtelephoneno("7674007321");
		
		String email = randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("gsaisas");
		addcust.custsubmit();
		
		
		logger.info("validation started... ");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully");
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed...");
		}
		else
		{
			logger.info("test case failed...");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
		
	}
}
