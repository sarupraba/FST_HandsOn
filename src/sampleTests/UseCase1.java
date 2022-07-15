package sampleTests;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.moneycontrolHomepage;

public class UseCase1{

	moneycontrolHomepage hmpage = new moneycontrolHomepage();
    /**
     * Rigorous Test :-)
     * @throws Exception 
     */
    @Test
    public void loginToMoneyControl_withValidCreds() throws Exception
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\002K80744\\HandsonWorkspace\\SeleniumHandsonFST\\src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.manage().deleteAllCookies();
        driver.get("http://www.moneycontrol.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        
        String parent=driver.getWindowHandle();
        Thread.sleep(3000);
        System.out.println("parent window: "+parent);
        Set<String>allwindow=driver.getWindowHandles();
        int count=allwindow.size();
        System.out.println("count:"+count);
        
        boolean alertwindow = driver.findElement(hmpage.alertpopup).isDisplayed();
        System.out.println(alertwindow);
        if(alertwindow) {
        	driver.findElement(hmpage.noThanks_btn).click();
        }
        
        
        driver.findElement(hmpage.userLink_xpath).click();
        driver.findElement(hmpage.login_xpath).click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(hmpage.iframe_id));
        driver.findElement(hmpage.email_xpath).sendKeys("saruprabaibmtest@gmail.com");
        driver.findElement(hmpage.password_xpath).sendKeys("Password@1");
        driver.findElement(hmpage.loginButton_id).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(hmpage.username_xpath));
        String logedinusername =driver.findElement(hmpage.username_xpath).getText();
        System.out.println(logedinusername);
        assertTrue(logedinusername.contains("Sarupraba"));
        driver.findElement(hmpage.username_xpath).click();
        driver.findElement(hmpage.logout_xpath).click();
        driver.close();
    }

}
