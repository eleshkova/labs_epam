package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogInPage extends Page {

    private final String BASE_URL = "http://www.lot.com/by/ru/login";

    private final Logger logger   = LogManager.getRootLogger();

    public LogInPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @FindBy(css = "form[action='/signin/facebook']")
    private WebElement socialNetworksBtn;

    @FindBy(id = "login")
    private WebElement inputLogin;

    @FindBy(id = "pass")
    private WebElement inputPassword;

    @FindBy(css = "input[type='submit']")
    private WebElement buttonSubmit;

    @FindBy(className = "validation-error")
    private WebElement errorMsg;

    @FindBy(css = "a[href='register']")
    WebElement registerBtn;

    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Log In page opened");
    }

    public void login(String username, String password) {
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        logger.info("Log In performed");
    }

    public void openFacebookPage(){
        socialNetworksBtn.click();
        logger.info("connecting to social network");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public String getErrorMsg() {
        return errorMsg.getText();
    }

    public void openRegisterPage(){
        registerBtn.click();
        logger.info("registration page was opened");
    }

}
