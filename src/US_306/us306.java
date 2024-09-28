package US_306;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class us306 extends BaseDriver {
    @Test
    public void US_306(){

        driver.get("https://shopdemo.fatfreeshop.com/");


        WebElement ContactUs= driver.findElement(By.className("contact"));
        ContactUs.click();

        WebElement name= driver.findElement(By.id("sender_name"));
        name.sendKeys("Banu");

        WebElement Email= driver.findElement(By.id("sender_email"));
        Email.sendKeys("hbanu2617@gmail.com");

        WebElement Subject= driver.findElement(By.id("sender_subject"));
        Subject.sendKeys("E-Junkie");

        WebElement Message= driver.findElement(By.name("sender_message"));
        Message.sendKeys("Team-9 Is always successful");

        WebElement SendMessage= driver.findElement(By.id("send_message_button"));
        SendMessage.click();
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        MyFunc.Bekle(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Boolean isAlertPresent = (Boolean) js.executeScript("return window.alert != undefined;");
        if (isAlertPresent) {

            driver.switchTo().alert().accept();
        }
        Assert.assertFalse("Recaptcha didn't match",SendMessage.getText().equals("send_message_button"));

    }
}

