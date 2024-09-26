package Utility;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class MyFunc {
    public static void Bekle(long saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void isDisplayed(WebElement element, String elementName){
        System.out.println(elementName +" is Displayed : " +element.isDisplayed());
        Assert.assertTrue(elementName+" isn't Displayed ",element.isDisplayed());
    }
    public static void isEnabled(WebElement element,String elementName){
        System.out.println(elementName +" is Enabled : " +element.isEnabled());
        Assert.assertTrue(elementName+" isn't Enabled ",element.isEnabled());
    }
    public static void isSelected(WebElement element,String elementName){
        System.out.println(elementName +" is Selected : " +element.isSelected());
        Assert.assertTrue(elementName+" isn't Selected ",element.isSelected());

    }
    public static void textIsDisplayed(WebElement element,String expectedText,String elementName){
        System.out.println(elementName +" text : " +element.getText());
        Assert.assertEquals(elementName+" text does not match ",expectedText,element.getText());
    }
}

