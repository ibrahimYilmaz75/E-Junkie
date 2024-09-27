package SmokeTest;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.awt.event.KeyEvent;


public class ST_0301 extends BaseDriver {
    @Test
    public void AllTests() {
         WebSite();
          CreateAccount();
          LoginPage();
          ProductPage();
        AddProduct();
        PaymentPage();
        ProductDownload();

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

        WebElement confirmEmailBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[4]/form/div[2]/input"));
        actions.click(confirmEmailBox).sendKeys(SData.confrimEMail).build().perform();

        WebElement passwordBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[4]/form/div[3]/input"));
        actions.click(passwordBox).sendKeys(SData.password).build().perform();

        WebElement signUpButton = driver.findElement(By.xpath("//*[text()='Sign Up']"));
        actions.click(signUpButton).build().perform();

        wait.until(ExpectedConditions.textToBe(By.xpath("//*[text()='Email already exists!']"), "Email already exists!"));
        WebElement emailExists = driver.findElement(By.xpath("//*[text()='Email already exists!']"));
        Assert.assertEquals("Text not Found", emailExists.getText(), "Email already exists!");

        WebElement logoBackHomePage = driver.findElement(By.xpath("//a[@href='/']/img"));
        actions.click(logoBackHomePage).pause(1000).build().perform();
    }

    @Test()
    public void LoginPage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[starts-with (@id, 'Login')]")));
        WebElement loginButton = driver.findElement(By.xpath("//a[starts-with (@id, 'Login')]"));
        actions.click(loginButton).build().perform();


        WebElement emailLoginBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/form/div[1]/input"));
        actions.click(emailLoginBox).sendKeys(SData.eMail).pause(1000).build().perform();

        WebElement passwordLoginBox = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/form/div[2]/input"));
        actions.click(passwordLoginBox).sendKeys(SData.password).pause(1000).build().perform();

        WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
        actions.click(signInButton).build().perform();

        //Successful login Control
        WebElement loginControl = driver.findElement(By.xpath("//a[text()='Your E-junkie Shop']"));
        Assert.assertEquals("Text not Found", loginControl.getText(), "Your E-junkie Shop");

    }

    @Test
    public void ProductPage()
    {
        driver.navigate().back();
        driver.navigate().back();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='text']//h3[text()='Your online shop']")));
        WebElement yourOnlineShop = driver.findElement(By.xpath("//div[@class='text']//h3[text()='Your online shop']"));
        actions.click(yourOnlineShop).build().perform();

        WebElement viewDemoShopBtn = driver.findElement(By.xpath("//*[@id='create-store']/div[1]/a[2]"));
        js.executeScript("arguments[0].scrollIntoView();", viewDemoShopBtn);
        actions.click(viewDemoShopBtn).build().perform();

    }

    @Test
    public void AddProduct()
    {
        driver.get("https://shopdemo.fatfreeshop.com/");

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        WebElement addCart = driver.findElement(By.xpath("//*[contains(@onclick,'1595015')]"));
        actions.click(addCart).build().perform();

        WebElement yourCartWin = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));
        driver.switchTo().frame(yourCartWin);

        WebElement productCount=driver.findElement(By.xpath("//*[@id='Overlay']/div/div[2]/div/div[2]/div[1]/span"));
        String textControl=productCount.getText();
        Assert.assertEquals("Product number cannot be displayed",textControl,"1");
    }
    @Test
    public void PaymentPage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='Payment-Button CC']")));
        WebElement paymentBtn = driver.findElement(By.xpath("//button[@class='Payment-Button CC']"));
        paymentBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Email']")));
        WebElement emailBox = driver.findElement(By.cssSelector("input[placeholder='Email']"));
        actions.click(emailBox)
                .sendKeys(SData.eMail)
                .sendKeys(Keys.TAB)
                .sendKeys(SData.confrimEMail)
                .sendKeys(Keys.TAB)
                .sendKeys(SData.name)
                .sendKeys(Keys.TAB)
                .sendKeys(SData.phoneNum)
                .sendKeys(Keys.TAB)
                .sendKeys(SData.company)
                .click().perform();

        WebElement ccFrame = driver.findElement(By.xpath("//*[@id='Stripe-Element']/div/iframe"));
        driver.switchTo().frame(ccFrame);

        WebElement cartDetails = driver.findElement(By.xpath("//*[@id='root']/form/div/div[2]/span[1]/span[2]/div/div[2]/span/input"));
        cartDetails.sendKeys(SData.cartNo + SData.cartDate + SData.cartCvc);

        driver.switchTo().parentFrame();
        WebElement payButton = driver.findElement(By.xpath("//*[@id='Overlay']/div/div[2]/div/div[3]/div[2]/button[1]"));
        payButton.click();
    }
    @Test
    public void ProductDownload()
    {
      //  driver.get("https://www.fatfreecartpro.com/ecom/rp.php?rdffc=true&txn_id=st-ch_3Q3S8zFWSmRjvnlt1HdZw6UH&payer_email=avsdf%40gimal.com&client_id=341695&c_id=201212394&c_enc=37003ad151a164c7e1dffc7e7a342547&cart_metadata=%7B%22gtag%22%3A%7B%22gtag%22%3A%22UA-273877-2%22%2C%22_ga%22%3A%222.225085977.222744657.1727134772-1896904416.1727134772%22%7D%2C%22fbp%22%3A%7B%22fbp%22%3A%221714673711932838%22%7D%2C%22cart_source%22%3A%22https%3A%2F%2Fshopdemo.fatfreeshop.com%2F%22%2C%22em_updates%22%3Atrue%7D&firstLoad=true&&pending_reason=&_ga=2.225085977.222744657.1727134772-1896904416.1727134772&&gajs=&auser=&abeacon=&");
       // WebElement ccFrame = driver.findElement(By.xpath("//*[@id='Stripe-Element']/div/iframe"));
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='confirme_text']/span")));
        WebElement downloadBtn=driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[1]/div/div[2]/div[3]/a/span"));
        downloadBtn.click();


        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        MyFunc.Bekle(2);
        for (int i = 1; i <= 2 ; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
        MyFunc.Bekle(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        for (int i = 1; i <= 2 ; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_W);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }




    }

}