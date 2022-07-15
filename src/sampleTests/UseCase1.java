package sampleTests;

import static org.testng.Assert.assertTrue;

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
     */
    @Test
    public void loginToMoneyControl_withValidCreds()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\002K80744\\HandsonWorkspace\\SeleniumHandsonFST\\src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("http://www.moneycontrol.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        
        driver.switchTo().alert().dismiss();
        
        
        driver.findElement(hmpage.userLink_xpath).click();
        driver.findElement(hmpage.login_xpath).click();
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
