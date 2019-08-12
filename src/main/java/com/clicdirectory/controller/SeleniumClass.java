package com.clicdirectory.controller;

import com.clicdirectory.entity.Groupdata;
import com.clicdirectory.entity.Messagestack;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class SeleniumClass {

    public  void sel(java.util.List<Groupdata> list, Messagestack ms) throws InterruptedException, NoSuchElementException, ElementNotVisibleException, AWTException {
        Scanner in = new Scanner(System.in);
        //System.out.print("Enter your message:");
        String message=ms.message;
//        Robot robot = new Robot();

        WebDriver driver=new ChromeDriver();
        driver.get("https://web.whatsapp.com/");


        @SuppressWarnings("SpellCheckingInspection") String str[]= new String[list.size()];
        for(int j=0;j<list.size();j++)
        {
            str[j]=list.get(j).groupname;
        }
        for(int i=0;i<str.length;i++) {
            WebElement s;
            WebDriverWait wait = new WebDriverWait(driver, 20);
            s = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"side\"]/div[1]/div/label/input")));
            s.sendKeys(str[i]);
            WebDriverWait wait1 = new WebDriverWait(driver, 10);
            try {
                wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@*='" + str[i] + "']"))).click();
                //driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div/div/div")).click();


                driver.findElement(By.className("_2S1VP")).sendKeys(message);

                driver.findElement(By.className("_35EW6")).click();

                Thread.sleep(2000);

                driver.findElement(By.className("jN-F5")).clear();



            }
            catch (Exception e){
                System.out.println(str[i]+" is not found.");

                driver.findElement(By.className("jN-F5")).clear();
            }
        }
        //       Thread.sleep(2000);


        driver.close();
    }
}
