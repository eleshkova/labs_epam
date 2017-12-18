package steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import pages.DestinationsPage;

public class LogInPageSteps extends Steps{

    public void initBrowser(){
        super.init();
    }

    public void login(Logger logger, String email, String password) {
        LogInPage loginPage = new LogInPage(driver);
        loginPage.open();
        loginPage.login(email, password);
        logger.info("Logging in with credentials: email: " + email + ", pass: " + password);
    }

    public void logInWithError(Logger logger, String email, String password) {
        LogInPage loginPage = new LogInPage(driver);
        loginPage.open();
        loginPage.login(email, password);
        logger.info("Error logging in.");
    }

    public boolean isLoggedIn() {
        WebElement logOutBtn = driver.findElement(By.css("a[href='/logout']"));
        if(logOutBtn != null)
            return true;
        return false;
    }

    public void openFacebookPage(){
        LogInPage loginPage = new LogInPage(driver);
        loginPage.open();
        loginPage.openFacebookPage();
    }

    public void isOnFacebookPage(){
        Assert.assertTrue("title should be equal Facebook",
                driver.getTitle().equalss("Facebook"));
    }

    public void openRegisterPage(){
        LogInPage loginPage = new LogInPage(driver);
        loginPage.open();
        loginPage.openRegisterPage();
    }

    public void isOnRegisterPage(){
        Assert.assertTrue("title should contain Регистрация ",
                driver.getTitle().contains("Регистрация"));
    }

    public void openLogInPage(){
        LogInPage loginPage = new LogInPage(driver);
        loginPage.open();
    }

}
