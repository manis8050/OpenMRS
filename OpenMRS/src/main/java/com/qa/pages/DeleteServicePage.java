package com.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.utility.InvokeBrowser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteServicePage {

	WebDriver driver;
	By uName=By.id("username");
	By uPwd=By.id("password");
	By inpntWard=By.id("Inpatient Ward");
	By loginbtn=By.id("loginButton");
	
	public DeleteServicePage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	/**
	 * Login Method
	 * @param username
	 * @param password
	 */
	public void login(String username,String password) 
	{
		//WebDriverManager.firefoxdriver().setup();
		// driver=new FirefoxDriver();
		
		

		driver.findElement(uName).sendKeys(username);
		driver.findElement(uPwd).sendKeys(password);
		driver.findElement(inpntWard).click();
		driver.findElement(By.id("loginButton")).submit();
	}
	
	public void navigateToServiceTypes()
	{
		driver.findElement(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
		driver.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app")).click();
	}
	
		
	
	
	public void verifyService(String serviceName)
	{
	     
	     
	     
	     List<WebElement> serviceList=driver.findElements(By.xpath("//table[@id='appointmentTypesTable']//tbody/tr/td[1]"));
		 outerloop:
		 for(int i=1;i<=3;i++) //To navigate through each pagination link.
		 {
			 serviceList=driver.findElements(By.xpath("//table[@id='appointmentTypesTable']//tbody/tr/td[1]"));
			 
		 for(int j=0;j<serviceList.size();j++)    //To get the list of services in each page
		 {
			
			 if(serviceList.get(j).getText().equals(serviceName))
			 {
				 driver.findElement(By.xpath("//td[text()='"+serviceName+"']/following-sibling::td[3]/descendant::i[@title='Delete']")).click();
			
				  break outerloop;

				}

				
			 }
		
		  driver.findElement(By.linkText((i+1)+"")).click();
		}
		
		}
	

	public boolean verifyDeleteService(String serviceName)
	{
		boolean result=false;
		//To get the button list and find which one is enabled.
		 List<WebElement> buttonList=driver.findElements(By.xpath("//*[@id='delete-appointment-type-dialog']/div[2]/button[@class='confirm right'][contains(text(),'Yes')]"));
			System.out.println(buttonList.size());
			// WebDriverWait wait=new WebDriverWait(driver,30);
			for(int k=0;k<buttonList.size();k++)
			{
				try{						
				if(buttonList.get(k).isDisplayed()|| buttonList.get(k).isEnabled())
				{
					System.out.println("inside if condition1");
					buttonList.get(k).click();
					System.out.println("inside if condition 2");
					result=true;
					break;
				}
				}
				catch(Exception e)
				{
					System.out.println("Element is not visible|| enabled" + e.getMessage());
				}
				
		 }
			return result;
	}
}