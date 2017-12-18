import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import steps.BookFlightsPageSteps;
import steps.Steps;
import driver.Driver;

import java.util.concurrent.TimeUnit;

public class LogInPageTest {
    private LogInPageSteps steps;

    private final String LOGIN = "ekaterinaleshkova@gmail.com";
    private final String LOGIN_ERR = "ekaterinaleshkova";
    private final String PASSWORD = "SignInTest1";

    private final Logger logger  = LogManager.getRootLogger();

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new LogInPageSteps();
        steps.initBrowser();
    }

    @Test
    public void performLogIn() {
        steps.login(LOGIN, PASSWORD);
        steps.isLoggedIn();
    }

    @Test
    public void performErrorLogIn() {
        steps.logInWithError(LOGIN_ERR, PASSWORD);
        steps.isLoggedIn();
    }

    @Test
    public void performOpenRegisterPage(){
        steps.openRegisterPage();
        String parentWindow = Driver.getDriver().getWindowHandle();
        Set<String> handles =  Driver.getDriver().getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                Driver.getDriver().switchTo().window(windowHandle);
                Driver.getDriver().manage().timeouts().pageLoadTimeout(31, TimeUnit.SECONDS);
                steps.isOnRegisterPage();
            }
        }
    }

    @Test
    public void performOpenFacebookPage(){
        steps.openFacebookPage();
        String parentWindow = Driver.getDriver().getWindowHandle();
        Set<String> handles =  Driver.getDriver().getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                Driver.getDriver().switchTo().window(windowHandle);
                Driver.getDriver().manage().timeouts().pageLoadTimeout(31, TimeUnit.SECONDS);
                steps.isOnFacebookPage();
            }
        }
    }

    @Test
    public void testLoadingPage(){
        steps.openLogInPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
        long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
        logger.info("Page Load Time is " + (loadEventEnd - navigationStart)/1000 + " seconds.");
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
