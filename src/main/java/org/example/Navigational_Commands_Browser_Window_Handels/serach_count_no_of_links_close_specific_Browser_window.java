package org.example.Navigational_Commands_Browser_Window_Handels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class serach_count_no_of_links_close_specific_Browser_window {

public static void main(String[]args){

    WebDriver driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.get("https://testautomationpractice.blogspot.com/");
    driver.manage().window().maximize();

    driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("testing");
    driver.findElement(By.xpath("//input[@type='submit']")).click();

    List<WebElement> searchlinks=driver.findElements(By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//div/a"));

    System.out.println("Number of Links:"+ searchlinks.size());

    System.out.println("printing & clicking links................");
    for(WebElement lik:searchlinks){
        System.out.println(lik.getText());
        lik.click();
    }

    Set<String> windowid=driver.getWindowHandles();
    for(String window:windowid){
        String title=driver.switchTo().window(window).getTitle();
        System.out.println(title);
    }
    driver.quit();
}
}