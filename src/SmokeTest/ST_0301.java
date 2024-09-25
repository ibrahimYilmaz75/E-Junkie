package SmokeTest;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.event.KeyEvent;

public class ST_0301 extends BaseDriver {
    @Test
    public void AllTests()
    {
        // WebSite();
        //  CreateAccount();
        //  LoginPage();
        //  ProductPage();
        AddProduct();
        //AddProductWindow();

    }

    @Test
    public void WebSite()
    {
        driver.navigate().to("https://www.e-junkie.com/");
        driver.navigate().refresh();
        wait.until(ExpectedConditions.urlToBe("https://www.e-junkie.com/"));

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        wait.until(ExpectedConditions.urlToBe("https://www.e-junkie.com/"));
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_CONTROL);

    }

    @Test
    public void CreateAccount()
    {

        WebElement CreateAccountButton = driver.findElement(By.linkText("Get Started"));
        actions.click(CreateAccountButton).build().perform();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        wait.until(ExpectedConditions.urlToBe("https://www.e-junkie.com/ej/dashboard/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.e-junkie.com/ej/dashboard/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div/div/div[4]/form/div[1]/input")));
        WebElement emailBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[4]/form/div[1]/input"));
        actions.click(emailBox).sendKeys(SData.eMail).build().perform();

        WebElement confirmEmailBox=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[4]/form/div[2]/input"));
        actions.click(confirmEmailBox).sendKeys(SData.confrimEMail).build().perform();

        WebElement passwordBox=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[4]/form/div[3]/input"));
        actions.click(passwordBox).sendKeys(SData.password).build().perform();

        WebElement signUpButton=driver.findElement(By.xpath("//*[text()='Sign Up']"));
        actions.click(signUpButton).build().perform();

        wait.until(ExpectedConditions.textToBe(By.xpath("//*[text()='Email already exists!']"),"Email already exists!"));
        WebElement emailExists=driver.findElement(By.xpath("//*[text()='Email already exists!']"));
        Assert.assertEquals("Text not Found",emailExists.getText(),"Email already exists!");

        WebElement logoBackHomePage=driver.findElement(By.xpath("//a[@href='/']/img"));
        actions.click(logoBackHomePage).pause(1000).build().perform();
    }

    @Test()
    public void LoginPage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[starts-with (@id, 'Login')]")));
        WebElement loginButton =driver.findElement(By.xpath("//a[starts-with (@id, 'Login')]"));
        actions.click(loginButton).build().perform();


        WebElement emailLoginBox=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/form/div[1]/input"));
        actions.click(emailLoginBox).sendKeys(SData.eMail).pause(1000).build().perform();

        WebElement passwordLoginBox=driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/form/div[2]/input"));
        actions.click(passwordLoginBox).sendKeys(SData.password).pause(1000).build().perform();

        WebElement signInButton=driver.findElement(By.xpath("//button[text()='Sign In']"));
        actions.click(signInButton).build().perform();
        MyFunc.Bekle(10);

        //Successful login Control
        WebElement  loginControl=driver.findElement(By.xpath("//a[text()='Your E-junkie Shop']"));
        Assert.assertEquals("Text not Found",loginControl.getText(),"Your E-junkie Shop");

    }

    @Test
    public void ProductPage()
    {driver.navigate().back();driver.navigate().back();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='text']//h3[text()='Your online shop']")));
        WebElement yourOnlineShop = driver.findElement(By.xpath("//div[@class='text']//h3[text()='Your online shop']"));
        actions.click(yourOnlineShop).build().perform();

        WebElement viewDemoShopBtn=driver.findElement(By.xpath("//*[@id='create-store']/div[1]/a[2]"));
        js.executeScript("arguments[0].scrollIntoView();",viewDemoShopBtn);
        actions.click(viewDemoShopBtn).build().perform();

    }
    @Test
    public void AddProduct()
    {
        driver.get("https://shopdemo.fatfreeshop.com/");

        WebElement productText=driver.findElement(By.xpath("//div[@class='basicDetails']//h4[contains(text(), 'Tangible')]"));
        String text = productText.getText();

        WebElement addCart=driver.findElement(By.xpath("//div[@class='basicDetails']//h4[contains(text(), 'Tangible')]/following-sibling::button"));
        actions.moveToElement(addCart).click().build().perform();

        WebElement yourCartWin=driver.findElement(By.xpath("/html/body/iframe[2]"));
        driver.switchTo().frame(yourCartWin);

        wait.until(ExpectedConditions.textToBe(By.xpath("//h5[contains (text(), 'Tangible')]"),"Demo Tangible Item"));
        WebElement iframeProductText=driver.findElement(By.xpath("//h5[contains (text(), 'Tangible')]"));
        Assert.assertTrue("Text not Found",iframeProductText.getText().contains(text));


    }

//    public void AddProductWindow()
//    {    WebElement shadowHost=driver.findElement(By.cssSelector("//ion-icon[@name='add']"));
//
//        WebElement svgElement=driver.findElement(By.cssSelector("svg.s-ion-icon"));
//        js.executeScript("arguments[0].click();", svgElement);
//
//
//
//    }
}
