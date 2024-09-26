package US_305;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class US305 extends BaseDriver {

    @Test
    public void test() throws AWTException {
        Actions actions=new Actions(driver);

        //main page
        driver.get("https://shopdemo.fatfreeshop.com/");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement demoEbook = driver.findElement(By.xpath("//*[text()='Demo eBook']"));
        demoEbook.click();

        WebElement addToCard = driver.findElement(By.xpath("//*[text()='ADD TO CART']"));
        addToCard.click();
        MyFunc.Bekle(2);

        //payment page
        WebElement iframe1=driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe1);
        MyFunc.Bekle(2);


        WebElement payment = driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
        payment.click();
        MyFunc.Bekle(2);

       // credit card info page
        driver.findElement(By.cssSelector(" [placeholder='Email'][type='email']")).sendKeys("tester@gmail.com");

        driver.findElement(By.cssSelector("[placeholder='Confirm Email']")).sendKeys("tester@gmail.com");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Email']")));
        driver.findElement(By.cssSelector(" [placeholder='Name On Card'][type='text']")).sendKeys("Test Engineer");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.switchTo().frame(1);

        WebElement cardnumber=driver.findElement(By.xpath("//*[@name='cardnumber']"));
        cardnumber.sendKeys("4242 4242 4242 4242");

        driver.findElement(By.xpath("//*[@name='exp-date']")).sendKeys("12/24");

        driver.findElement(By.cssSelector("[name='cvc']")).sendKeys("000");

        driver.switchTo().parentFrame();

        WebElement payButton=driver.findElement(By.xpath("//button[starts-with(@class,'Pay-B')]"));

        actions.moveToElement(payButton).click().build().perform();

        driver.switchTo().defaultContent();

        MyFunc.Bekle(15);

        WebElement greenText=driver.findElement(By.xpath("//*[@class='green_text_margin']"));

        WebElement download=driver.findElement(By.xpath("//*[text()='Download']"));
        download.click();

        // order price, total price

        WebElement eBookPrice=driver.findElement(By.xpath("//*[text()='Qty(1) USD 0.50']"));
        String eBookPriceText=eBookPrice.getText();

        WebElement totalPrice=driver.findElement(By.xpath("(//*[text()='USD 0.50'])[2]"));
        String totalPriceText=totalPrice.getText();

        double eBookPrice2=Double.parseDouble(eBookPriceText.replace("Qty(1) USD","").trim());
        double totalPrice2=Double.parseDouble(totalPriceText.replace("USD","").trim());

        if (eBookPrice2==totalPrice2)
            System.out.println("eBook fiyatı ile Total Fiyat eşit: " + totalPrice2);
        else System.out.println("Fiyatlar eşit değil!");


        driver.quit();


    }

}
