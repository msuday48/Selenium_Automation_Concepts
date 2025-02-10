package org.example.Dropdown;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
     }}}

    public static class HiddenDropdown {
        public static void main(String[] args) {

            // Set up ChromeDriver
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            // Navigate to the website
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");

            // Login steps
            driver.findElement(By.name("username")).sendKeys("Admin");
            driver.findElement(By.name("password")).sendKeys("admin123");
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

            // Navigate to the PIM module
            driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();

            // Locate and click on the dropdown
            WebElement dropdown = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]"));
            dropdown.click();

            // Wait for the dropdown options to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']//span")));

            // Count and print the dropdown options
            List<WebElement> options = driver.findElements(By.xpath("//div[@role='listbox']//span"));
            System.out.println("Number of options: " + options.size());

            for (WebElement option : options) {
                System.out.println(option.getText());
            }
            // Close the browser
            driver.quit();
        }
    }
}