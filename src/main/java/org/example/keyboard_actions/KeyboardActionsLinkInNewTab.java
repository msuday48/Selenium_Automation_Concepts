package org.example.keyboard_actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
import java.util.List;

public class KeyboardActionsLinkInNewTab {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            // Open website
            driver.get("https://demo.nopcommerce.com/");
            driver.manage().window().maximize();

            // Wait for page to load
            Thread.sleep(3000);

            // Locate Register link
            WebElement regLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));

            // Open Register link in new tab using Actions class
            Actions act = new Actions(driver);
            act.keyDown(Keys.CONTROL).click(regLink).keyUp(Keys.CONTROL).perform();

            // Wait for the new tab to open
            Thread.sleep(3000);

            // Switch to the new tab (Registration page)
            List<String> ids = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(ids.get(1));

            // Enter First Name
            WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
            firstName.sendKeys("John KENEDY");

            // Wait for a few seconds
            Thread.sleep(2000);

            // Switch back to the Home page
            driver.switchTo().window(ids.get(0));
            WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
            searchBox.sendKeys("TShirts");

            // Wait before closing
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted: " + e.getMessage());
        } finally {
            // Close browser
            driver.quit();
        }
    }
}