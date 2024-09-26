package kursatibrahim;

import Utility.MyFunc;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class kursatibrahimmain {
    @Test

    public void Test07(){
        WebDriver driver1=new ChromeDriver();
        driver1.get("https://shopdemo.e-junkie.com");


        MyFunc.Bekle(1);

        WebElement ecommarce= driver1.findElement(By.className("EJ-ShopLink"));
        MyFunc.isDisplayed(ecommarce,"ecommarce");
        MyFunc.isEnabled(ecommarce,"ecommarce");
        ecommarce.click();

        MyFunc.Bekle(2);


        WebElement ejunkielogo= driver1.findElement(By.xpath("//div[contains (@class, 'column')]/div/a[@href='/']"));
        MyFunc.isDisplayed(ejunkielogo,"E Junkie Logo");
        MyFunc.isEnabled(ejunkielogo,"E Junkie Logo");
        ejunkielogo.click();
        Assert.assertEquals("URL NOT FOUNDED",driver1.getCurrentUrl(),"https://www.e-junkie.com/");

        MyFunc.Bekle(2);
        driver1.quit();





    }

}
