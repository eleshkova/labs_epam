package pages;

import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Page {

    protected WebDriver webDriver;

    public abstract void open();

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void loadPage(){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        long loadEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
        long navStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
        Logger logger   = LogManager.getRootLogger();
        logger.info("Page Load Time: " + (loadEventEnd - navigationStart)/1000 + " s.");
    }
}
