package org.example.Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertwithInputbox {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("(//button[normalize-space()='Click for JS Prompt'])[1]")).click();

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());
        alert.sendKeys("Hello");
        alert.accept();

        String text = driver.findElement(By.xpath("//p [contains(@id,'result')]")).getText();

        if (text.equals("Hello")) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }
        driver.quit();
    }
}