package Ibrahim;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Us_303_Kadriye extends BaseDriver {

    @Test

    public void Test404()
    {
        driver.get("https://shopdemo.fatfreeshop.com/?");
        Actions actions=new Actions(driver);
        // JavascriptExecutor js=(JavascriptExecutor)driver;


        WebElement addToCart= driver.findElement(By.xpath("//*[contains(@onclick,'1595015')]"));
        addToCart.click();

        WebElement iframe=driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(iframe);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Payment-Button CC']")));
        WebElement creditCart=driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        creditCart.click();

        //WebElement iframee=driver.findElement(By.id("stripeXDM_default644953_provider"));
        // driver.switchTo().frame(iframee);

        // driver.switchTo().frame(iframe);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Email']")));
        WebElement email=driver.findElement(By.cssSelector("input[placeholder='Email']"));
        actions.click(email)
                .sendKeys("kadriyealsancak@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("kadriyealsancak@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Kadriye")
                .sendKeys(Keys.TAB)
                .sendKeys("05425240516")
                .sendKeys(Keys.TAB)
                .sendKeys("Company")
                .sendKeys(Keys.TAB)
                .sendKeys("nothing")
                .sendKeys(Keys.TAB)
                .sendKeys("1111 11111 1111")
                .click().perform();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Kart numaranız eksik.']")));
        WebElement results= driver.findElement(By.xpath("//*[text()='Kart numaranız eksik.']"));
        System.out.println("results.getText() = " +"Kart numaranız eksik.");

        //String expectedUrl="https://shopdemo.fatfreeshop.com/?";
        //String actualUrl= driver.getCurrentUrl();
        //Assert.assertEquals(expectedUrl,actualUrl);





    }
}


