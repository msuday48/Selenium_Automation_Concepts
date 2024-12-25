package org.example.wait_Statements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Explicit_wait {

    public static void main(String[] args) {

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Initialize Explicit Wait
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Wait for the username field to be visible and enter the username
        WebElement textUsername = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        textUsername.sendKeys("Admin");

        // Wait for the password field to be visible and enter the password
        WebElement textPassword = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
        textPassword.sendKeys("admin123");

        // Wait for the login button to be clickable and click on it
        WebElement clickingLogin = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
        clickingLogin.click();

        // Close the browser
        driver.quit();
    }
}