package pages;

import org.openqa.selenium.By;

public class moneycontrolHomepage {
    public By alertpopup = By.xpath("//div[@class='wzrk-alert wiz-show-animate']");
    public By noThanks_btn = By.xpath("//div[@class='wzrk-alert wiz-show-animate']//button[@class='No thanks']");
    public By userLink_xpath = By.xpath("//a[@class='userlink']");
    public By iframe_id = By.id("myframe");
    public By login_xpath = By.xpath("//a[@title=\"Log In\"]");
    public By email_xpath = By.xpath("//input[@placeholder=\"Email or Mobile Number or User ID\"]");
    public By password_xpath = By.xpath("//form[@id='login_form']//input[@placeholder=\"Password\"]");
    public By loginButton_id = By.id("ACCT_LOGIN_SUBMIT");
    public By username_xpath = By.xpath("//span[@class=\"usr_nm\"]");
    public By logout_xpath = By.xpath("//div[@class=\"top_fr clearfix\"]//a[@title='Logout']");

}
