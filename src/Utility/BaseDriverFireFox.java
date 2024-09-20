package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseDriverFireFox {  public static WebDriver driverFireFox;

    static {
        driverFireFox =new FirefoxDriver();

        driverFireFox.manage().window().maximize();
        driverFireFox.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driverFireFox.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static void tearDown(){
        MyFunc.Bekle(3);
        driverFireFox.quit();
    }
}
