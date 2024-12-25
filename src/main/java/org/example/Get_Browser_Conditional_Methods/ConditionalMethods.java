package org.example.Get_Browser_Conditional_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ConditionalMethods {

	public static void main(String[] args) {

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();

		// Open the URL and maximize the browser window
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();

		// 1. isDisplayed()
	//	WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
	//	System.out.println("Logo displayed: " + logo.isDisplayed());

		Boolean logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println("Logo displayed: " + logo);


		// 2. isEnabled()
		WebElement registerButton = driver.findElement(By.id("register-button"));
		System.out.println("Register button enabled: " + registerButton.isEnabled());

		// 3. isSelected()
		WebElement maleRadioButton = driver.findElement(By.id("gender-male"));
		WebElement femaleRadioButton = driver.findElement(By.id("gender-female"));

		System.out.println("Before selection:");
		System.out.println("Male selected: " + maleRadioButton.isSelected());//true
		System.out.println("Female selected: " + femaleRadioButton.isSelected());//false

		// Select the male radio button
		maleRadioButton.click();

		System.out.println("After selecting male:");
		System.out.println("Male selected: " + maleRadioButton.isSelected());//true
		System.out.println("Female selected: " + femaleRadioButton.isSelected());//false

		// Close the browser
		driver.quit();
	}
}
