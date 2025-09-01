package org.example.TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class Parallel_Testing {

    WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    void setup(String br) throws InterruptedException {
        switch (br.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid browser specified.");
                return;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(3000);  // Wait for elements to load
    }


    @Test(priority = 1)
    void testLogo() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logo = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//img[@alt='company-branding']")));  // Updated XPath
        Assert.assertTrue(logo.isDisplayed(), "Logo is not visible on the page.");
    }

    @Test(priority = 2)
    void testTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleContains("OrangeHRM"));
        Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Title does not match!");
    }

    @Test(priority = 3)
    void testUrl() {
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
                "URL does not match expected.");
    }

    @AfterClass
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}