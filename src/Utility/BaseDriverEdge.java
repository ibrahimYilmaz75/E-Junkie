package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BaseDriverEdge { public static WebDriver driverEdge;

    static {
        driverEdge =new EdgeDriver();

        driverEdge.manage().window().maximize();
        driverEdge.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driverEdge.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public static void tearDown(){
        MyFunc.Bekle(3);
        driverEdge.quit();
    }
}
