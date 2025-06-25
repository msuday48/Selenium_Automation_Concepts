package org.example.Alerts.AL_practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Handle_Alerts {

    public static void main(String[]args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Open a site that contains prompt alert (with input box)
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click on the button that triggers JS Prompt
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        // Wait for the alert to be present
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert al = mywait.until(ExpectedConditions.alertIsPresent());

        // Get alert text
        System.out.println("Alert Text: " + al.getText());



        // Accept the alert
      //  al.accept(); // closes alert with ok button


        // Close the browser
        al.dismiss(); // closes alert with cancel button
        driver.quit();

    }
}


