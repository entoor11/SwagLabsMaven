package com.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;


public class LoginTestCase extends BaseClass {

	//Method name test4 should be same as test4 in excel data
	@Test
	public void valid(Method method) throws FilloException, InterruptedException {

		LoginPage login = new LoginPage(driver);	
		Recordset recordset = connection.executeQuery("select * from data where TestName='"+method.getName()+"'");
		
		recordset.next();
		
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");

		login.LoginFunction(UserName, Password);//span[@class='title']
		
		WebElement validMsg = driver.findElement(By.xpath("//span[@class='title']"));
		Thread.sleep(5000);
		String ActError = validMsg.getText();
		String ExpError = "Products";
		System.out.println("The Actual Message:"+ActError);
		
		Thread.sleep(3000);
		Assert.assertEquals(ActError, ExpError);

	}
	
	@Test
	public void invalid(Method method) throws FilloException, InterruptedException {
		
		LoginPage login = new LoginPage(driver);
		Recordset recordset = connection.executeQuery("select * from data where TestName='"+method.getName()+"'");
		//Recordset recordset = connection.executeQuery("select * from data where TestName='test4'");
		
		recordset.next();
		
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");

		login.LoginFunction(UserName, Password);
		
		WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
		Thread.sleep(5000);
		String ActError = error.getText();
		String ExpError = "Epic sadface: Username and password do not match any user in this service";
		Thread.sleep(3000);
		
		System.out.println("The Actual Message:"+ActError);
		Assert.assertEquals(ActError, ExpError);		
	}

}
