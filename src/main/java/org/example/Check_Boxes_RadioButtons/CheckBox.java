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
import java.util.List;

public class CheckBox {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        driver.manage().window().maximize();

        List<WebElement> checkboxes=driver.findElements(By.xpath(" "));

        System.out.println(checkboxes.size());

        for(int i=0;i<checkboxes.size();i++){

            checkboxes.get(i).click();
        }

        for(WebElement ck:checkboxes){
            ck.click();
        }

        // //Select last 2 checkboxes
        //        // total Number of checkboxes-how many checkboxes to be selected= startign index
        //        //7-3= 4 ( startign index)

        for(int i=4;i<checkboxes.size();i++){

            checkboxes.get(i).click();
        }

        //clear/Uncheck checkboxes

        //Using normal for loop
        /*for(int i=0;i<3;i++)
        {
            checkboxes.get(i).click();
        }*/

		/*for(int i=0;i<checkboxes.size();i++)
		{
			if(checkboxes.get(i).isSelected())
			{
			checkboxes.get(i).click();
			}
    */
}}