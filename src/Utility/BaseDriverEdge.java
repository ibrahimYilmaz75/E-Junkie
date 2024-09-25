package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class BaseDriverEdge { public static WebDriver driverEdge;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;
    public static Actions actions;
    public static Robot robot;
    static {
        driverEdge =new EdgeDriver();
        wait = new WebDriverWait(driverEdge,Duration.ofSeconds(20));
        js=(JavascriptExecutor)driverEdge;
        actions=new Actions(driverEdge);

        driverEdge.manage().window().maximize();
        driverEdge.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driverEdge.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static void tearDown(){
        MyFunc.Bekle(3);
        driverEdge.quit();
    }
}
