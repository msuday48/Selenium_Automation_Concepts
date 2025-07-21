package org.example.TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Google_search {
    public static void main(String[] args) {
        // Define search string and page number
        String searchString = "Postman";
        int totalPages = 9;

        System.getProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
//Set Chrome options
        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        // Setup WebDriver
        WebDriver driver = new EdgeDriver(options);
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Open Google
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();

            // Search for the given string
            WebElement searchBox = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@title='Search']")));
            searchBox.sendKeys(searchString);
            searchBox.submit();

            // Loop through the required number of pages
            for (int page = 1; page <= totalPages; page++) {
                // Wait for search results to load
                mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3")));

                // Extract and print the first search result title
                List<WebElement> searchResults = driver.findElements(By.xpath("//h3"));
                if (!searchResults.isEmpty()) {
                    WebElement firstResult = searchResults.get(0);
                    System.out.println("Page " + page + " First Link: " + firstResult.getText());
                } else {
                    System.out.println("No results found on page " + page);
                }

                // Go to the next page if not on the last page
                if (page < totalPages) {
                    try {
                        WebElement nextButton = mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='pnnext']")));
                        nextButton.click();
                        Thread.sleep(3000); // Allow time for the next page to load
                    } catch (Exception e) {
                        System.out.println("Next page button not found. Ending search.");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
        }
    }
}