package org.example.Amazon_website;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Amazon_cart_functionality {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in");

        try {
            WebElement continueShoppingBtn = driver.findElement(By.xpath("//button[text()='Continue shopping']"));
            if (continueShoppingBtn.isDisplayed()) {
                continueShoppingBtn.click();
                System.out.println("'Continue shopping' button clicked.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("'Continue shopping' button not found. Continuing with script.");
        }
    }

    @AfterMethod
    public void tearDown() {
        // driver.quit(); // Uncomment after testing to close browser
    }

    @Test(priority = 1)
    public void addItemToCart() {
        driver.findElement(By.xpath("//span[normalize-space()='Air conditioners'][1]")).click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        driver.findElement(By.xpath("//span[contains(text(),'Daikin 1.5 Ton 3 Star Inverter Split AC (Copper, P')]")).click();
    }

    @Test(priority = 2, dependsOnMethods = "addItemToCart")
    public void add_to_cart() {
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@title='Add to Shopping Cart'])[2]")));
            addToCartBtn.click();
            System.out.println("Add to Cart button clicked successfully.");
        } catch (TimeoutException e) {
            System.out.println("Add to Cart button not found or clickable.");
        }
    }

    @Test(priority = 3, dependsOnMethods = "add_to_cart")
    public void viewCart() {
        driver.findElement(By.xpath("//span[@class='a-button a-button-primary attach-button-large attach-primary-cart-button']//input[@type='submit']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//h2[normalize-space()='Shopping Cart'])[1]")));
        Assert.assertTrue(confirmation.isDisplayed(), "Cart page not displayed properly.");
    }

    @Test(priority = 4, dependsOnMethods = "viewCart")
    public void updateQuantity() {
        driver.findElement(By.xpath("(//span[@class='a-icon a-icon-small-add'])[1]")).click();
        WebElement qtyDropdown = driver.findElement(By.xpath("//span[@data-a-selector='value']"));
        qtyDropdown.click(); // You can expand this logic to select a different quantity
    }

    @Test(priority = 5, dependsOnMethods = "updateQuantity")
    public void removeItemFromCart() {
        driver.findElement(By.xpath("//span[@data-a-selector='value']")).click(); // example interaction
        WebElement emptyMessage = driver.findElement(By.xpath("//div[@class='sc-list-item-removed-msg-delete a-padding-medium']"));
        Assert.assertTrue(emptyMessage.isDisplayed(), "Cart not empty after delete.");
    }
}
