package org.example.Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static javax.swing.UIManager.get;

public class SelectDropDown {

    public static void main(String[]args) {
WebDriver driver=new ChromeDriver();

   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");;

        driver.manage().window().maximize();

        WebElement countrydropdown=driver.findElement((By.xpath("//select[@id=\"country\"]")));

        Select dropdown = new Select(countrydropdown);
/*
        dropdown.selectByVisibleText("Germany");
        dropdown.selectByValue("japan");
        dropdown.deselectByIndex(2);
*/
        List <WebElement>  options= dropdown.getOptions();

     /*   for(int i=0;i<options.size();i++)
        {
            System.out.println(options.get(i).getText());
        }
        */

        for(WebElement op:options){
            System.out.println(op.getText());
        }
    }}