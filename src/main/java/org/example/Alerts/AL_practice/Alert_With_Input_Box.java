package org.example.Alerts.AL_practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Alert_With_Input_Box {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Open a site that contains prompt alert (with input box)
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

driver.findElement(By.xpath("(//button[normalize-space()='Click for JS Prompt'])[1]")).click();

Alert al=driver.switchTo().alert();
System.out.println(al.getText());
al.sendKeys("Hello");

al.accept();

String text= driver.findElement(By.xpath("//p[starts-with(text(),'You entered: Hello')]")).getText();

System.out.println(text);

if(text.equals("Hello")) {

    System.out.println("Test case passed");
}
else{
    System.out.println("Testcase case failed");
    }
}}