package com.ebanking.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ebanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username entered");
		lp.setPassword(password);
		logger.info("password entered");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}
}
