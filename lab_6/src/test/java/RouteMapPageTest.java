import driver.Driver;
import steps.DestinationPageSteps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RouteMapPageTest {

    private RouteMapPageSteps steps;

    private final Logger logger  = LogManager.getRootLogger();

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new RouteMapPageSteps();
        steps.initBrowser();
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }

    @Test
    public void performSelectDeparture(){
        steps.selectDeparture();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
        steps.departureIsSelected();
    }

    @Test
    public void performSelectTicketType(){
        steps.selectTicketType();
        steps.ticketTypeIsSelected();
    }

    @Test
    public void performZoomInMap(){
        steps.zoomInMap();
        steps.mapIsZoomedIn();
    }

    @Test
    public void performZoomOutMap(){
        steps.zoomOutMap();
        steps.mapIsZoomedOut();
    }

    @Test
    public void testLoadingPage(){
        steps.openDestinationPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
        long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
        logger.info("Page Load Time is " + (loadEventEnd - navigationStart)/1000 + " seconds.");
    }
}
