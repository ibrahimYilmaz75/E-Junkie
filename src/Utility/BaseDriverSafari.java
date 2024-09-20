package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseDriverSafari {   public static WebDriver driverSafari;

    static {
        driverSafari =new SafariDriver();

        driverSafari.manage().window().maximize();
        driverSafari.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driverSafari.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static void tearDown(){
        MyFunc.Bekle(3);
        driverSafari.quit();
    }
}
