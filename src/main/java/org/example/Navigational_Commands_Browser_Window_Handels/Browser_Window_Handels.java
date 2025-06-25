package org.example.Navigational_Commands_Browser_Window_Handels;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Browser_Window_Handels
{
    public static void main(String[]args)
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

        Set<String> windowid=driver.getWindowHandles();

        //Aproach1

        List <String> windowlist=new ArrayList<> (windowid);
      /*
        String childwindow=windowlist.get(0);
        String parentwindow=windowlist.get(1);

        //Switch to child window
        driver.switchTo().window(childwindow);
        System.out.println(driver.getTitle());

        //Switch to parent window
        driver.switchTo().window(parentwindow);
        System.out.println(driver.getTitle());
*/
        for(String wind:windowid){
            String title =driver.switchTo().window(wind).getTitle();
            if(title.equals("OrangeHRM")){
                System.out.println(driver.getCurrentUrl());
            }
        }
        driver.quit();
    }}