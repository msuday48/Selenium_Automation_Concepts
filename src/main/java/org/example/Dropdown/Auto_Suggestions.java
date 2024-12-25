package org.example.Dropdown;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Auto_Suggestions  {

    public static void main(String[]args) throws InterruptedException
    {
        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");;

        driver.manage().window().maximize();

        driver.findElement((By.xpath("//textarea[@title=\"Search\"]"))).sendKeys("selenium");

        Thread.sleep(1000);

     List<WebElement> list =driver.findElements((By.xpath("//div[@aria-label=\"selenium\"]")));

     System.out.println(list.size());

     for(int i=0;i<list.size();i++)
     {
     if(list.get(i).getText().equals("selenium")){
         System.out.println(list.get(i).getText());
         list.get(i).click();
         break;
     }
     }
    }
}