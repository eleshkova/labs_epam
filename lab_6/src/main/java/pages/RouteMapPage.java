package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;
import java.lang.*;


public class RouteMapPage extends Page {
    private final Logger logger   = LogManager.getRootLogger();
    private final String BASE_URL = "http://www.lot.com/by/ru/routemap";

    public DestinationsPage(WebDriver webDriver) {
        super(webDriver);

        PageFactory.initElements(this.webDriver, this);
    }
    @FindBy(id = "departureAirport")
    WebElement departureSelectorBtn;

    @FindBy(css = "option[value='MSQ']")
    WebElement departureOptionBtn;

    @FindBy(css = "a[data-ticket-type='CHANGE']")
    WebElement ticketTypeBtn;

    @FindBy(css = "input[type='submit']")
    WebElement routeSubmitBtn;

    @FindBy(className = "custom-zoom-more")
    WebElement largerMapBtn;

    @FindBy(className = "custom-zoom-less")
    WebElement smallerMapBtn;



    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Route map page was opened");
    }

    public void selectDeparture(){
        departureSelectorBtn.click();
        departureOptionBtn.click();
        logger.info("departure airport was selected");
        routeSubmitBtn.click();
        logger.info("searching routes for this airport");
    }
    public void selectTicketType(){
        ticketTypeBtn.click();
        logger.info("ticket type was chosen");
    }

    public void zoomInMap(){
        largerMapBtn.click();
        logger.info("map was zoomed in");
    }

    public void zoomOutMap(){
        smallerMapBtn.click();
        logger.info("map was zoomed out");
    }
}
