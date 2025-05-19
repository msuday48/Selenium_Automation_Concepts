package org.example.TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class DataProviderTest {
    WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "dp")
    void testLogin(String username, String password) {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn']"));
        submitButton.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            boolean status = wait.until(ExpectedConditions.textToBePresentInElementLocated(
                    By.tagName("h1"), "Logged In Successfully"));
            Assert.assertTrue(status, "Login Successful for: " + username);

            WebElement logoutButton = driver.findElement(By.xpath("//a[normalize-space()='Log out']"));
            logoutButton.click();
        } catch (Exception e) {
            Assert.fail("Login failed for: " + username);
        }
    }
    @DataProvider(name = "dp")
    public Object[][] loginData() {
        return new Object[][]{
                {"student", "Password123"},
                {"testuser", "Test@123"},
        };
    }
    //
    @AfterClass
    void teardown() {

        driver.quit();
    }
}