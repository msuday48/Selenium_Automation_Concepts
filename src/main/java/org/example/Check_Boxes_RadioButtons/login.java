package org.example.Check_Boxes_RadioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class login {
    public static void main(String[]args){

        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("");

        WebElement ele= driver.findElement(By.xpath(""));
        ele.sendKeys("msuday48@gmail.com");

        WebElement password= driver.findElement(By.xpath(" "));
        password.sendKeys("Uday@151997");

        WebElement submitbutton= driver.findElement(By.xpath(" "));
        submitbutton.click();

    }
}
