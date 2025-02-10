package org.example.Get_Browser_Conditional_Methods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver=new ChromeDriver();
		
		//get(url) - opens the url on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);

		//getTitle() - returns title of the page
		System.out.println(driver.getTitle());  //OrangeHRM

		//getCurrentUrl() - returns URL of the page
		System.out.println(driver.getCurrentUrl()); //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		
		//getPageSource()- returns source code of the page
		//System.out.println(driver.getPageSource());

		//getWindowHandle
		String windowid= driver.getWindowHandle();
		System.out.println(windowid);

		Set <String> windowids=driver.getWindowHandles();
		System.out.println(windowids);

	   driver.quit();
	}
}
