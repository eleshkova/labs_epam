package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.concurrent.TimeUnit;

import listener.Listener;

public class Driver {

    private static WebDriver driver;
    private static EventFiringWebDriver eventDriver;
    private static Listener eventListener;

    public static WebDriver getDriver(){
        if (eventDriver == null){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            eventDriver = new EventFiringWebDriver(driver);
            eventListener = new Listener();
            eventDriver.register(eventListener);
            eventDriver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }

        return eventDriver;
    }

    public static void closeDriver(){
        eventDriver.quit();
        eventDriver = null;
    }
}
