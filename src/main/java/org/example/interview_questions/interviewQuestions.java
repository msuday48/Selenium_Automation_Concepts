import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class interviewQuestions {

    public static void main(String[] args) {

        // WAITS
        WebDriver driver = new ChromeDriver();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Explicit wait
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
        mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("your_xpath_here")));

        // Fluent wait
        Wait<WebDriver> waits = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        // AUTO SUGGESTIONS DROPDOWN
        driver.findElement(By.xpath("your_input_xpath")).sendKeys("selenium");
        List<WebElement> we = driver.findElements(By.xpath("your_suggestions_xpath"));
        for (int i = 0; i < we.size(); i++) {
            if (we.get(i).getText().equalsIgnoreCase("selenium")) {
                System.out.println(we.get(i).getText());
                we.get(i).click();
                break;
            }
        }

        // DROPDOWN
        WebElement drop = driver.findElement(By.xpath("your_dropdown_xpath"));
        Select dropdown = new Select(drop);
        dropdown.selectByVisibleText("Visible Text");
        dropdown.selectByValue("value");
        dropdown.selectByIndex(0);

        dropdown.deselectByVisibleText("Visible Text");
        dropdown.deselectByValue("value");
        dropdown.deselectByIndex(0);

        // Dropdown without <select> tag
        drop.click();
        List<WebElement> drp = driver.findElements(By.xpath("dropdown_options_xpath"));
        for (int i = 0; i < drp.size(); i++) {
            String title = drp.get(i).getText();
            if (title.equals("OptionText")) {
                drp.get(i).click();
                break;
            }
        }

        // CHECKBOXES
        List<WebElement> chk = driver.findElements(By.xpath("checkboxes_xpath"));
        for (int j = 0; j < chk.size(); j++) {
            chk.get(j).click();
        }

        // JAVASCRIPT EXECUTOR
        WebElement ele = driver.findElement(By.xpath("element_xpath"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll
        js.executeScript("arguments[0].scrollIntoView();", ele);

        // Input
        js.executeScript("arguments[0].setAttribute('value','your_value');", ele);

        // Click
        js.executeScript("arguments[0].click();", ele);

        // FRAMES
        WebElement frame = driver.findElement(By.xpath("frame_xpath"));
        driver.switchTo().frame(frame);  // switch using WebElement
        driver.switchTo().frame(0);      // switch using index
        driver.switchTo().defaultContent(); // back to main page

        // ALERT
        Alert al = driver.switchTo().alert();
        al.sendKeys("some text");
        al.accept();
        al.dismiss();

        // ACTION CLASS
        WebElement acti = driver.findElement(By.xpath("element1_xpath"));
        WebElement actionsEl = driver.findElement(By.xpath("element2_xpath"));

        Actions action = new Actions(driver);
        action.moveToElement(acti).perform();
        action.contextClick(acti).perform();
        action.doubleClick(acti).perform();
        action.dragAndDrop(acti, actionsEl).perform();

        // KEYBOARD ACTIONS
        Actions aon = new Actions(driver);
        aon.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        aon.sendKeys(Keys.ENTER).perform();

        // WINDOW HANDLES
        WebElement window = driver.findElement(By.xpath("open_window_xpath"));
        window.click();

        Set<String> wind = driver.getWindowHandles();
        for (String windowid : wind) {
            String titles = driver.switchTo().window(windowid).getTitle();
            System.out.println(titles);
            if (titles.equals("Title1") || titles.equals("Title2")) {
                driver.close();
            }
        }

        // SCREENSHOT
        // Entire page
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("target/location/screenshot.png");
        sourceFile.renameTo(targetFile);

        // Element screenshot
        WebElement elementScreenshot = driver.findElement(By.xpath("element_xpath"));
        File elemSource = elementScreenshot.getScreenshotAs(OutputType.FILE);
        File elemTarget = new File("target/location/elementshot.png");
        elemSource.renameTo(elemTarget);

        // HEADLESS BROWSING
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        // INCOGNITO MODE
        ChromeOptions options1 = new ChromeOptions();
        options1.addArguments("--incognito");

        // SSL CERTIFICATE HANDLING
        ChromeOptions options2 = new ChromeOptions();
        options2.setAcceptInsecureCerts(true);

        // DISABLE AUTOMATION BANNER
        ChromeOptions options3 = new ChromeOptions();
        options3.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // TESTNG — DATA PROVIDER EXAMPLE (Uncomment when using TestNG)
        /*
        @DataProvider(name = "data")
        public Object[][] logindata() {
            return new Object[][] {
                    {"student", "pass123"},
                    {"admin", "admin123"}
            };
        }

        @Test(dataProvider = "data")
        public void datafromDataProvider(String username, String password) {
            driver.get("https://your-login-page.com");
            driver.findElement(By.id("username")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
        }
        */

        // TESTNG — PARALLEL TESTING EXAMPLE (Uncomment when using TestNG)
        /*
        @Parameters({"browser"})
        @BeforeMethod
        public void setup(String br) {
            if (br.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (br.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            } else {
                System.out.println("Browser not supported");
            }
        }
        */
//TESTNG ANNOTATIONS

             /*  @BeforeSuite
                @BeforeTest
                @BeforeClass
                @BeforeMethod
                @Test
                @AfterMethod
                @AfterClass
                @AfterTest
                @afterSuite

                       @Test(groups = {"regression", "Sanity"})
                       @Test(priority = 1)
                       @Test(invocationCount = 2)
                       @Test(enabled = true)
                       @Test(alwaysRun = true)
                       @Test(dependsOnMethods = " ")
                       @Test(Timeout=200)*/
        // Close the driver
        driver.quit();
    }
}