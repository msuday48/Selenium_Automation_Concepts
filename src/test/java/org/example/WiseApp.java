package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Scanner;

public class WiseApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");

        String str = sc.nextLine();

        String[] words = str.split("");

        String reverseString = " ";

        for (String s : words) {
            String rev = " ";


            for (int i = str.length() - 1; i >= 0; i--) {
                rev = rev + str.charAt(i);
            }
            reverseString = reverseString + rev + "";
        }
    }
}