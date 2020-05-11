package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.pages.DeleteServicePage;
import com.qa.utility.InvokeBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ValidateDeleteService extends InvokeBrowser {


	
	
	
	@Parameters({"serviceName","username","password"})
	@Test
	public void deleteServiceTest(String serviceName, String username,String password) throws InterruptedException
	{
		
	
		// SoftAssert sa=new SoftAssert();
		DeleteServicePage deletePage=new DeleteServicePage(driver);
		deletePage.login(username,password);
	    Thread.sleep(3000);
	    deletePage.navigateToServiceTypes();
	    Thread.sleep(3000);
	    deletePage.verifyService(serviceName);
	    boolean result= deletePage.verifyDeleteService(serviceName);
	    System.out.println(result);

		
		}
}
