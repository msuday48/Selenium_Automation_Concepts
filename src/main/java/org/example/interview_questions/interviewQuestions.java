package org.example.interview_questions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class interviewQuestions {

    public static void main(String[] args) {

        //WAITS
        //implicit wait

        WebDriver driver = new ChromeDriver();

        //WAITS

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Expicit wait

        WebDriver mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

        mywait.until(ExpectedConditions.elementToBeClickable(By.xpath(" ")));

        //Fluent wait

        FluentWait<WebDriverWait> waits = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        //=============================================================================================================================================

        //AUTO SUGGESTIONS DROPDOWN

        driver.findElement(By.xpath("")).sendKeys(" ");

        List<WebElement> we = driver.findElements(By.xpath(""));

        for (int i = 0; i <= we.size(); i++) {
            if (we.get(i).getText().equals("selenium")) {
                System.out.println(we.get(i).getText());
                we.get(i).click();
                break;
            }
        }
        //=========================================================================================================================================

        //DROPDOWN

        WebElement drop = driver.findElement(By.xpath(" "));

        Select dropdown = new Select(drop);
        dropdown.selectByVisibleText(" ");
        dropdown.selectByValue(" ");
        dropdown.deselectByIndex(0);

        dropdown.deselectByVisibleText(" ");
        dropdown.deselectByValue(" ");
        dropdown.selectByIndex(0);

        //Dropdown without select option
        drop.click();
        List<WebElement> drp = drop.getOptions();
        for (int i = 0; i < drp.size(); i++) {
            String title = drp.get(i).getText();
            if (title.equals(" ")) {
                drp.get(i).click();
                ;
            }

            //CHECKBOIXES
            List<WebElement> chk = driver.findElements(By.xpath(""));
            for (int j = 0; i < chk.size(); j++) {
                chk.get(j).click();
                ;
            }
            // =====================================================================================================================================
            //JAVASCRIPT EXECUTOR
            WebElement ele = driver.findElement(By.xpath(" "));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            //Scroll
            js.executeScript("Arguments[o],ScrollIntoView()", ele);
            //Input
            js.executeScript("Arguments[0],SetAttribute(input,value)", ele);
            //click
            js.executeScript("Arguments[0],click()", ele);
            //  ====================================================================================================================================
            //FRAMES
            WebElement frame = driver.findElement(By.xpath(""));
            //inside the frame
            driver.switchTo().frame(frame);
            driver.switchTo().frame(0);

            //outside the frame
            driver.switchTo().defaultContent();

            //================================================================================================================================
            // ALERT

            Alert al = driver.switchTo().alert();
            al.sendKeys(" ");
            al.accept();

            //dismiss alert
            al.dismiss();

            //==================================================================================================================================

            //Action class

            WebElement acti = driver.findElement(By.xpath(""));
            WebElement actions = driver.findElement(By.xpath(""));

            Actions action = new Actions(driver);
            action.moveToElement(acti).perform();
            action.contextClick(acti);
            action.doubleClick();
            action.dragAndDrop(acti, actions);

            // ===================================================================================================================================

            //  KEYBOARD ACTIONS
            Actions aon = new Actions(driver);

            aon.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
            aon.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
            //====================================================================================================================================

            //WINDOW HANDELS

            WebElement window = driver.findElement(By.xpath(""));
            window.click();

            Set<String> wind = driver.getWindowHandles();

            for (String windowid : wind) {
                String titles = driver.switchTo().window(windowid).getTitle();

                System.out.println(titles);

                if (titles.equals(" ") || titles.equals(" ")) {
                    driver.close();
                }

            }
//=================================================================================================================================================
            //SCREENSHOT
            TakesScreenshot ts=(TakesScreenshot)driver;
            Targetfile


            }

        }
    }
}