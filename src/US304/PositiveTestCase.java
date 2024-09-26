package US304;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class PositiveTestCase extends BaseDriver {
    @Test
    public void Test1(){
        Actions actions=new Actions(driver);

        // main web page
        driver.get("https://shopdemo.fatfreeshop.com/");
        Assert.assertEquals("The web page that opens is not the correct web page.",driver.getCurrentUrl(),"https://shopdemo.fatfreeshop.com/");

        List<WebElement> elements = driver.findElements(By.xpath("//div[starts-with(@class,'basic')]//button"));
        for (WebElement e:elements){
            System.out.println(e.isDisplayed());
            System.out.println(e.isEnabled());
        }

        int number=(int) (Math.random()*(elements.size()-1)+1);
        String addToCartButton="(//div[starts-with(@class,'basic')]//button)["+number+"]";
        driver.findElement(By.xpath(addToCartButton)).click();

        // payment page
        WebElement frame=driver.findElement(By.xpath("//iframe[starts-with(@class,'EJ')]"));
        driver.switchTo().frame(frame);

        WebElement debitAndCreditCard = driver.findElement(By.xpath("//div[@class='Payment-Options']//button[contains(@class,'CC')]"));
        System.out.println(debitAndCreditCard.isDisplayed());
        System.out.println(debitAndCreditCard.isEnabled());
        debitAndCreditCard.click();

        // credit card web page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[contains(@class,'Billing')]//input[contains(@autocomplete,'mail')])[1]")));
        WebElement eMailBox=driver.findElement(By.xpath("(//p[contains(@class,'Billing')]//input[contains(@autocomplete,'mail')])[1]"));
        actions.click(eMailBox)
                .sendKeys(TestData.eMail)
                    .sendKeys(Keys.TAB)
                    .sendKeys(TestData.eMail)
                    .sendKeys(Keys.TAB)
                    .sendKeys(TestData.name)
                    .sendKeys(Keys.TAB)
                    .sendKeys(TestData.telephoneNumber)
                    .sendKeys(Keys.TAB)
                    .sendKeys(TestData.companyName)
                    .sendKeys(Keys.TAB)
                    .sendKeys(TestData.note)
                    .click().perform();

        WebElement creditCardFrame=driver.findElement(By.cssSelector("[name*='__privateStripeFrame']"));
        driver.switchTo().frame(creditCardFrame);
        WebElement creditCardNumberBox=driver.findElement(By.xpath("//span[contains(@class,'Input')]//input[contains(@name,'card')]"));
        creditCardNumberBox.sendKeys(TestData.creditCardNumber+TestData.creditCardDate+TestData.cvc);

        driver.switchTo().parentFrame();
        WebElement payButton=driver.findElement(By.xpath("//button[starts-with(@class,'Pay-B')]"));
        System.out.println(payButton.isEnabled());
        System.out.println(payButton.isDisplayed());
        actions.moveToElement(payButton).click().build().perform();
        driver.switchTo().defaultContent();

        // order list web page
        wait.until(ExpectedConditions.urlContains("fatfreecartpro.com"));
        WebElement message= driver.findElement(By.cssSelector("span[class*='green']"));
        Assert.assertEquals("The warning message is incorrect.",message.getText(),"your order is confirmed. Thank you!");

        bekleKapat();
    }
}
