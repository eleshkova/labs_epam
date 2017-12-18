import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.CustomerServicePageSteps;

public class CustomerServicePageTest  {

    private CustomerServicePageSteps steps;

    private final Logger logger  = LogManager.getRootLogger();

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new CustomerServicePageSteps();
        steps.initBrowser();
    }

    @Test
    public void performBackToMain(){
        steps.backToMain();
        String parentWindow = Driver.getDriver().getWindowHandle();
        Set<String> handles =  Driver.getDriver().getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                Driver.getDriver().switchTo().window(windowHandle);
                Driver.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                steps.isOnMainPage();
            }
        }
    }

    @Test
    public void performLearnMore(){
        steps.learnMore();
        steps.isOnLearnMore();
    }


    @Test
    public void testLoadingPage{
        steps.openCustomerServicePage();
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
