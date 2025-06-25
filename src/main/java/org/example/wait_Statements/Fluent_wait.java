package org.example.wait_Statements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
import java.util.NoSuchElementException;

public class Fluent_wait {
    public static void main(String[] args) {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        // Initialize FluentWait
        FluentWait<WebDriver> mywait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))   // Total wait time
                .pollingEvery(Duration.ofSeconds(2))  // Polling interval
                .ignoring(NoSuchElementException.class); // Ignore specific exceptions

        // Open the URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        // Wait for the username field using Fluent Wait
        WebElement txtusername = mywait.until(driver1-> driver1.findElement(By.xpath("//input[@placeholder='Username']")));

        // Enter the username
        txtusername.sendKeys("Admin");

        // Close the browser
        driver.quit();
    }
}