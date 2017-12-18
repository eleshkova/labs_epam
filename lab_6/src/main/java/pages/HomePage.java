package pages;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends Page{
    private final Logger logger   = LogManager.getRootLogger();

    private final String BASE_URL = "http://www.lot.com/by/ru/;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @FindBy(id="language-options")
    WebElement changeLanguageBtn;

    @FindBy(id = "gblang-selector")
    WebElement languageToChoose;

    @FindBy(id = "accessibility-options")
    WebElement changeContrastBtn;

    @FindBy(id = "enableHighContrast")
    WebElement enableHighContrastBtn;

    @FindBy(id = "departureAirport")
    WebElement depatureSelector;

    @FindBy(id = "destinationAirport")
    WebElement destinationSelector;

    @FindBy(css = "option[value='VIE']")
    private WebElement departurePicker;

    @FindBy(css = "option[value='KEF']")
    private WebElement destinationPicker;

    @FindBy(className = "hasDatepicker")
    private List <WebElement> flightDate;

    @FindBy(id = "submit-booker")
    private WebElement scheduleSubmitBtn;

    @FindBy(css = "option[href='#3']")
    private WebElement changeSlideBtn;


    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Home page opened");
    }

    public void search(String date) {
        depatureSelector.click();
        departurePicker.click();
        logger.info("Departure airport chosen");
        destinationSelector.click();
        destinationPicker.click();
        logger.info("Destination airport chosen");
        flightDate.get(1).sendKeys(date);
        scheduleSubmitBtn.submit();
    }

    public void changeLanguage(){
        changeLangeageBtn.click();
        logger.info("click on dropdown to change language");
        languageToChoose.click();
        Driver.getDriver().manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        logger.info("language was chosen");
    }

    public void chooseContrast(){
        changeContrastBtn.click();
        logger.info("click on dropdown to change contrast");
        enableHighContrastBtn.click();
        Driver.getDriver().manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        logger.info("contrast was chosen");
    }
    public void changeSlide(){
        changeSlideBtn.click();
        logger.info("click on pagination to change slide");
        Driver.getDriver().manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        logger.info("slide was changed");
    }
}
