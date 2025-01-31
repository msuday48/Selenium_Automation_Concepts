package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Wise_App {

    public static void main(String[] args) {
        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();


            // Maximize browser window to full screen
            driver.manage().window().maximize();

            // Visit the website
            driver.get("https://staging-web.wise.live");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
            // Click on login using phone number
            WebElement phoneLoginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Continue with Mobile'])[1]")));
            phoneLoginButton.click();

            // Enter the phone number
            WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Phone number']")));
            phoneNumberField.sendKeys("1111100000");

            // Locate and enter OTP into 4 input fields
            for (int i = 0; i < 4; i++) {
                // Construct the XPath for each OTP input field dynamically
                String otpFieldXPath = "//div[@class='col col-12']" + i + "']";
                WebElement otpField = driver.findElement(By.xpath(otpFieldXPath));
                otpField.sendKeys("0"); // Enter '0' in each OTP field
            }}}

             /* Submit the OTP
            WebElement submitOtpButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit-otp-button")));
            submitOtpButton.click();

            // Wait for the institute name to appear
            WebElement instituteNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("institute-name")));
            String actualInstituteName = instituteNameElement.getText();

// SoftAssert softAssert = new SoftAssert();
            // Assert that the institute name is "Testing Institute"
            softAssert.assertEquals(actualInstituteName, "Testing Institute", "Institute name mismatch!");

            // Collect all soft assertion results
            softAssert.assertAll();

        } catch (Exception e) {
            e.printStackTrace();
            softAssert.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
*/