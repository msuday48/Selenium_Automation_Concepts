package org.example.Alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Authontication_popup {
    private static final Logger log = LoggerFactory.getLogger(Authontication_popup.class);

    public static void main(String[] args)
    {
        WebDriver driver=new ChromeDriver();
        //http://the-internet.herokuapp.com/basic_auth
        //http://admin:admin@the-internet.herokuapp.com/basic_auth
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");

        String text=driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).getText();

      if(text.equals("congragulations")){
          System.out.println("test passed");
    }
    else
    {
    System.out.println("test failed");
}
}}