package US_301;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_301_ extends BaseDriver {
    @Test
    public void Test() {
        driver.get("https://shopdemo.fatfreeshop.com/");

        WebElement kıtap = driver.findElement(By.cssSelector("[class='box']>[style$='background-image: url(https://s3.amazonaws.com/static.e-junkie.com/products/thumbnails/1595015.png); border-radius: 4px 4px 0px 0px;']"));
        kıtap.click();
        MyFunc.Bekle(2);

        WebElement sepet = driver.findElement(By.xpath("//button[@type='submit']"));
        sepet.click();
        MyFunc.Bekle(2);

        Assert.assertTrue(driver.getCurrentUrl().equals("//button[@type='submit']"), "Kitap Sepete Eklenmedi");


        WebElement Promosyonbtn = driver.findElement(By.cssSelector("div[class='Actions']>:nth-child(2)"));
        Promosyonbtn.click();
        MyFunc.Bekle(2);


        WebElement kod= driver.findElement(By.cssSelector("[class='Actions']>:nth-child(3)>input[class='Promo-Code-Value']"));
        kod.sendKeys("1234");

        WebElement uygulabtn=driver.findElement(By.xpath("(//button[@type='button'])[3]"));
        uygulabtn.click();

        Assert.assertTrue(driver.getCurrentUrl().equals("div[id='SnackBar']"),"Geçersiz Promosyon Kodu");




        // [class='Actions']>:nth-child(3)>input[class='Promo-Code-Value']
        //(//input[@class='Promo-Code-Value'])[1].


        bekleKapat();
    }
}

