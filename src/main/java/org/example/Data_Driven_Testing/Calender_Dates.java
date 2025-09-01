package org.example.Data_Driven_Testing;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Calender_Dates {

    // -------------------------------
    // Method to select a FUTURE DATE from DatePicker
    // -------------------------------
    static void selectFutureDate(WebDriver driver, String year, String month, String date) {
        // Keep clicking "Next" until we reach the desired month and year
        while (true) {
            // Get the current month displayed in the date picker
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            // Get the current year displayed in the date picker
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            // If current month & year match our required month & year -> stop looping
            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }

            // Otherwise, keep clicking the "Next" button (right arrow)
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
        }

        // Now pick the correct date from the visible calendar
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));

        for (WebElement dt : allDates) {
            if (dt.getText().equals(date))   // If date text matches our required date
            {
                dt.click();                  // Click that date
                break;                       // Exit loop
            }
        }
    }


    // -------------------------------
    // Method to select a PAST DATE from DatePicker
    // -------------------------------
    static void selectPastDate(WebDriver driver, String year, String month, String date) {
        // Keep clicking "Previous" until we reach the desired month and year
        while (true) {
            // Get the current month displayed in the date picker
            String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            // Get the current year displayed in the date picker
            String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            // If current month & year match our required month & year -> stop looping
            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }

            // Otherwise, keep clicking the "Previous" button (left arrow)
            driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
        }

        // Now pick the correct date from the visible calendar
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr/td//a"));

        for (WebElement dt : allDates) {
            if (dt.getText().equals(date))   // If date text matches our required date
            {
                dt.click();                  // Click that date
                break;                       // Exit loop
            }
        }
    }


    // -------------------------------
    // MAIN METHOD (execution starts here)
    // -------------------------------
    public static void main(String[] args) {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Set implicit wait (max 10 seconds for locating elements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the jQuery Datepicker demo site
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();

        // The datepicker input field is inside an <iframe>, so switch into frame first
        driver.switchTo().frame(0);

        // -------------------------------
        // Method 1: Enter date directly using sendKeys()
        // -------------------------------
        // driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("04/05/2024"); // format: mm/dd/yyyy

        // -------------------------------
        // Method 2: Select date using the Date Picker UI
        // -------------------------------
        driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // Click input -> opens date picker popup

        // Desired date to select
        String year = "2025";
        String month = "sep";
        String date = "01";

        // Choose either future date OR pas

    }
}