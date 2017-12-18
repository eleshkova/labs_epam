import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.HomePageSteps;
import driver.Driver;

public class HomePageTest {

    private HomePageSteps steps;

    private final Logger logger  = LogManager.getRootLogger();


    private final String DATE                = "22/12/2017";

    private final String PICK_UP_DATE        = "17/12/2017";
    private final String RETURN_DATE         = "31/12/2017";

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new HomePageSteps();
        steps.initBrowser();
    }

    @Test
    public void performSearchPath() {
        steps.searchPath(DATE);
        steps.isOnSchedulePage();
    }

    @Test
    public void performChangeLanguage(){
        steps.changeLanguage();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
        steps.isLanguageChanged();
    }

    @Test
    public void performChangeContrast(){
        steps.chooseContrast();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
        steps.isContrastChosen();
    }

    @Test
    public void testLoadingPage(){
        steps.openHomePage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
        long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
        logger.info("Page Load Time is " + (loadEventEnd - navigationStart)/1000 + " seconds.");
    }

    @Test
    public void testchangeSlide(){
        steps.changeSlide();
        steps.isSlideChanged();
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}
