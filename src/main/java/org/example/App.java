package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class App {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        WebElement inputbox=driver.findElement(By.xpath("//input[@id='name']"));

        // passing the text into inputbox - alternate of sendKeys()
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value','John')",inputbox);

        //scroll
//2) scroll the page till element is visible

		WebElement ele=driver.findElement(By.xpath("//strong[normalize-space()='Community poll']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
//

        //zZoom
        js.executeScript("document.body.style.zoom='80%'");  // set zoom level 50%

}}






