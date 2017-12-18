package steps;

import org.junit.Assert;
import pages.AirewardsPage;

public class RouteMapPageSteps extends Steps {

    public void initBrowser(){ super.init(); }

    public void selectDeparture(){
        RouteMapPage routeMapPage = new RouteMapPage(driver);
        routeMapPage.open();
        routeMapPage.selectDeparture();
    }

    public void departureIsSelected(){
        WebElement pTag = driver.findElement(By.id("connectionStatic"));
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        Assert.assertTrue("Display should be inline-block",
                pTag.getAttribute("style").equals("display: inline-block;"));
    }

    public void selectTicketType(){
        RouteMapPage routeMapPage = new RouteMapPage(driver);
        routeMapPage.open();
        routeMapPage.selectTicketType();
    }

    public void ticketTypeIsSelected(){
        WebElement aTag = driver.findElement(By.css("a[data-ticket-type='CHANGE']"));
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        Assert.assertTrue("Class should be active",
                aTag.getAttribute("class").equals("active"));
    }

    public void zoomInMap(){
        RouteMapPage routeMapPage = new RouteMapPage(driver);
        routeMapPage.open();
        routeMapPage.zoomInMap();
    }

    public void mapIsZoomedIn(){
        WebElement divTag = driver.findElement(By.css("div.gm-style>div>div"));
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        Assert.assertTrue("transform-origin should be 625px 280px 0px",
                divTag.getAttribute("style").equals("z-index: 1; position: absolute; top: 0px; left: 0px; " +
                        "width: 100%; transform-origin: 625px 280px 0px; transform: matrix(1, 0, 0, 1, -49, 0);"));
    }

    public void zoomOutMap(){
        RouteMapPage routeMapPage = new RouteMapPage(driver);
        routeMapPage.open();
        routeMapPage.zoomOutMap();
    }

    public void mapIsZoomedOut(){
        WebElement divTag = driver.findElement(By.css("div.gm-style>div>div"));
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        Assert.assertTrue("transform-origin should be 625px 280px 0px",
                divTag.getAttribute("style").equals("z-index: 1; position: absolute; top: 0px; left: 0px; " +
                        "width: 100%; transform-origin: 0px 0px 0px; transform: matrix(1, 0, 0, 1, -49, 0);"));
    }

    public void openRouteMapPage(){
        RouteMapPage routeMapPage = new RouteMapPage(driver);
        routeMapPage.open();
    }

}
