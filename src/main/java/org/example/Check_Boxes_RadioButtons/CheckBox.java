package org.example.Check_Boxes_RadioButtons;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import java.time.Duration;

public class CheckBox {
    public static void main(String[] args) {

        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();
        // Maximize browser window to full screen
        driver.manage().window().maximize();

        // Initialize WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Visit the website
            driver.get("https://staging-web.wise.live");

            // Click on login using phone number
            WebElement phoneLoginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//span[normalize-space()='Continue with Mobile'])[1]")));
            phoneLoginButton.click();

            // Enter the phone number
            WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@placeholder='Phone number']")));
            phoneNumberField.sendKeys("1111100000");

            // Click on the "Get OTP" button
            WebElement clickOnGetOtp = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[normalize-space()='Get OTP']")));
            clickOnGetOtp.click();

            // Wait for OTP input fields to be visible and enter OTP
            WebElement otpField1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//input[@class='otp-field-box--0'])[1]")));
            otpField1.sendKeys("0");

            WebElement otpField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//input[@class='otp-field-box--1'])[1]")));
            otpField2.sendKeys("0");

            WebElement otpField3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//input[@class='otp-field-box--2'])[1]")));
            otpField3.sendKeys("0");

            WebElement otpField4 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//input[@class='otp-field-box--3'])[1]")));
            otpField4.sendKeys("0");

            // Click on the "Verify" button
            WebElement submitOtpButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//span[normalize-space()='Verify'])[1]")));
            submitOtpButton.click();

            // Wait for the institute name to appear
            WebElement instituteNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//div[@class='name text--24 font-weight--600 ml-3'])[1]")));
            String actualInstituteName = instituteNameElement.getText();

            // Initialize SoftAssert for soft assertions
            SoftAssert softAssert = new SoftAssert();
            // Assert that the institute name is "Testing Institute"
            softAssert.assertEquals(actualInstituteName, "Testing Institute", "Institute name mismatch!");

            // Verify the institute name is displayed
            WebElement instituteName = driver.findElement(By.xpath("//*[text()='Testing Institute']"));
            Assert.assertTrue(instituteName.isDisplayed(), "Institute name not found!");

            // Click on the "Group Courses" button
            WebElement groupCourses = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//div[@class='card-content d-flex py-sm-5 py-3 px-4 border-radius--8 card-hover-effect'])[2]")));
            groupCourses.click();

            // Wait for the custom popup to appear and locate the "X" button
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@class='v-icon notranslate v-icon--link mdi mdi-close theme--light']")));
            closeButton.click();

            System.out.println("Custom popup closed successfully!");

            // Click on the "Classroom for Automated Testing" link
            WebElement classroomAutomationTesting = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//a[normalize-space()='Classroom for Automated testing'])[1]")));
            classroomAutomationTesting.click();

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            System.err.println("Test failed due to exception: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}