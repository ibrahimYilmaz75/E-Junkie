package Ibrahim;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class IbrahimMain extends BaseDriver {
    @Test
    public void Test(){
        driver.get("https://www.e-junkie.com/");
        // Deneme süresi geçme
        WebElement webElement= driver.findElement(By.xpath("//a[@class='btn']"));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        WebElement element= driver.findElement(By.xpath("//div[@class='column is-2-desktop is-4-tablet is-4-mobile']"));
        element.click();


        // "see how it works" Buttonunu bulana kadar bekle
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@class='blue_btn']")));
        // Buttonu bul ve tıkla
        WebElement blueButton= driver.findElement(By.xpath("//a[@class='blue_btn']"));
        blueButton.click();

        // iframe'in locator'ını bul
        WebElement iframe= driver.findElement(By.cssSelector("div[class='video-container'] iframe"));
        driver.switchTo().frame(iframe);
        Actions aksiyonlar=new Actions(driver);


        // Videonun locator'ını bul ve oynat
        WebElement video= driver.findElement(By.xpath("//button[@title='Oynat']"));
        Action aksiyon1= aksiyonlar.moveToElement(video).click().build();
        aksiyon1.perform();

        // 10sn bekle
        MyFunc.Bekle(10);


        // Videoyu duraklat
        WebElement videoDuraklat= driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        js.executeScript("arguments[0].click();", videoDuraklat);

        // Anasayfaya (bir önceki iframe'e) geri dön
        driver.switchTo().parentFrame();

        // Boşluğa tıklamak(videodan çıkmak) için bekle
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='txn-popups']")));
        // Boşluğa tıkla ve videodan çık
        WebElement element2= driver.findElement(By.xpath("//div[@class='txn-popups']"));
        Action aksiyon3= aksiyonlar.moveToElement(element2).click().build();
        aksiyon3.perform();

        bekleKapat();
    }

}
