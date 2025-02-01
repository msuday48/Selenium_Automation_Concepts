package org.example.Check_Boxes_RadioButtons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
                    By.xpath("(//div[@class='text--24 font-weight--600'])[1]")));
            String classroomName = classroomElement.getText();
            softAssert.assertEquals(classroomName, "Classroom for Automated testing", "Classroom name mismatch!");
            System.out.println("Verified classroom name: " + classroomName);

            // Step 12: Perform all soft assertions and print confirmation message
            softAssert.assertAll();
            System.out.println("All assertions passed successfully.");

            // Step 13: Navigate to the Live Sessions tab
            WebElement liveSessionsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Live Sessions'])[1]")));
            liveSessionsTab.click();
            System.out.println("Clicked on 'Live Sessions' tab.");

            // Step 14: Click on the Schedule Session button
            WebElement scheduleSessionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'mr-2 v-btn v-btn--has-bg theme--light v-size--default small secondary-bg')]")));
            scheduleSessionButton.click();
            System.out.println("Clicked on 'Schedule Session' button.");


            WebElement addSessionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class, 'v-icon') and contains(@class, 'notranslate') and contains(@class, 'mdi') and contains(@class, 'mdi-plus') and contains(@class, 'theme--light')]")));
            addSessionButton.click();
            System.out.println("Clicked on 'addSession' button.");

            /*
            // Step 15: Wait for the time input field to be clickable

            WebElement timeInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));

            // Scroll the element into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", timeInput);

            // Debugging: Check if the element is displayed and enabled
            System.out.println("Is element displayed? " + timeInput.isDisplayed());
            System.out.println("Is element enabled? " + timeInput.isEnabled());

            // Set the time using JavaScript (if sendKeys doesn't work)
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = '10:00';", timeInput);

            // Locate the input box and press the Enter key to confirm the time
            WebElement confirmInput = driver.findElement(By.xpath(" "));
            confirmInput.sendKeys(Keys.ENTER);
            System.out.println("Time entered and confirmed successfully.");
*/

            // Step 1: Click the time input box to open the dropdown
            WebElement timeInputBox = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//div[@role='combobox'])[1]"))); // Replace with the actual locator
            timeInputBox.click();
            System.out.println("Clicked on the time input box.");

// Step 2: Wait for the dropdown to appear
// Use a more generic XPath to locate the dropdown
            WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(@class, 'v-menu__content') and contains(@class, 'v-autocomplete__content')]")));
            System.out.println("Dropdown is visible.");

// Step 3: Scroll to the desired time option (10:00)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement timeOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@role='option']//div[contains(@class, 'v-list-item__title') and text()='10:00']")));
            js.executeScript("arguments[0].scrollIntoView(true);", timeOption);
            System.out.println("Scrolled to the time option: 10:00");

// Step 4: Click the time option (10:00)
            timeOption.click();
            System.out.println("Selected time: 10:00");

// Step 5: Click the Create button
            WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(@class, 'v-btn') and contains(text(), 'Create')]")));
            createButton.click();
            System.out.println("Clicked on 'Create' button.");
//
        } catch (Exception e) {
            // Handle exceptions and log the error
            System.err.println("Test failed due to exception: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the browser

            System.out.println("Browser closed successfully.");
        }
    }
}