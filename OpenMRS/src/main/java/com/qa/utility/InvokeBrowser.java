package com.qa.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class InvokeBrowser {
	
	protected WebDriver driver;
	
	@BeforeClass
	@Parameters({"browserType","url"})
	
		public void invokeBrowser(String browserType, String url)
		{
			
			switch(browserType)
			{
			case "FF":
			
			//geckodriver.exe
				System.out.println("in FF");
				System.setProperty("webdriver.gecko.driver","C:\\selenium-prerequisites\\executables\\geckodriver.exe");
			driver=new FirefoxDriver();
			break;
			
			case "CH":
			//ChromeDriver.exe
				System.out.println("in Chrome");
				System.setProperty("webdriver.chrome.driver","C:\\selenium-prerequisites\\executables\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
			
			case "IE":
			//IEDriverServer.exe
				System.out.println("in IE");
				System.setProperty("webdriver.ie.driver","C:\\selenium-prerequisites\\executables\\IEDriverServer.exe");
			driver =new InternetExplorerDriver();
			break;
			
			case "ED":
			//MicrosodtWebDriver.exe
			driver=new EdgeDriver();
			break;
			
			}
			
		    driver.get(url);
			
		}

	


	}

