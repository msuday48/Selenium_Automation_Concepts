package org.example.Check_Boxes_RadioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CheckBox {

    public static void main(String[] args) {
        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize browser window to full screen
        driver.manage().window().maximize();

        // Initialize WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize SoftAssert for soft assertions
        SoftAssert softAssert = new SoftAssert();

        try {
            // Step 1: Navigate to the website
            driver.get("https://staging-web.wise.live");
            System.out.println("Navigated to the website successfully.");

            // Step 2: Click on login using phone number
            WebElement phoneLoginButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//span[normalize-space()='Continue with Mobile'])[1]")));
            phoneLoginButton.click();
            System.out.println("Clicked on 'Continue with Mobile' button.");

            // Step 3: Enter the phone number
            WebElement phoneNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//input[@placeholder='Phone number']")));
            phoneNumberField.sendKeys("1111100000");
            System.out.println("Entered phone number successfully.");

            // Step 4: Click on the "Get OTP" button
            WebElement getOtpButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[normalize-space()='Get OTP']")));
            getOtpButton.click();
            System.out.println("Clicked on 'Get OTP' button.");

            // Step 5: Wait for OTP input fields to be visible and enter OTP
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
            System.out.println("OTP entered successfully.");

            // Step 6: Click on the "Verify" button
            WebElement verifyButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//span[normalize-space()='Verify'])[1]")));
            verifyButton.click();
            System.out.println("Clicked on 'Verify' button.");

            // Step 7: Verify the institute name is displayed
            WebElement instituteNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//div[@class='name text--24 font-weight--600 ml-3'])[1]")));
            String actualInstituteName = instituteNameElement.getText();
            softAssert.assertEquals(actualInstituteName, "Testing Institute", "Institute name mismatch!");
            System.out.println("Verified institute name: " + actualInstituteName);

            // Step 8: Click on the "Group Courses" button
            WebElement groupCoursesButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//div[@class='card-content d-flex py-sm-5 py-3 px-4 border-radius--8 card-hover-effect'])[2]")));
            groupCoursesButton.click();
            System.out.println("Clicked on 'Group Courses' button.");

            // Step 9: Close the custom popup if it appears
            WebElement closePopupButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[@class='v-icon notranslate v-icon--link mdi mdi-close theme--light']")));
            closePopupButton.click();
            System.out.println("Custom popup closed successfully.");

            // Step 10: Navigate to the "Classroom for Automated Testing" page
            WebElement classroomAutomationTestingLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//a[normalize-space()='Classroom for Automated testing'])[1]")));
            classroomAutomationTestingLink.click();
            System.out.println("Navigated to 'Classroom for Automated Testing' page.");

            // Step 11: Verify the classroom page is loaded
            WebElement classroomElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("(//div[@class='name text--24 font-weight--600 ml-3'])[1]")));
            String classroomName = classroomElement.getText();
            softAssert.assertEquals(classroomName, "Testing Institute", "Classroom name mismatch!");
            System.out.println("Verified classroom name: " + classroomName);

            // Step 12: Perform all soft assertions and print confirmation message
            softAssert.assertAll();
            System.out.println("All assertions passed successfully.");
//
        } catch (Exception e) {
            // Handle exceptions and log the error
            System.err.println("Test failed due to exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
            System.out.println("Browser closed successfully.");
        }
    }
}