package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerServicePage extends Page {

    private final String BASE_URL = "http://www.lot.com/by/ru/customer-service";

    private final Logger logger   = LogManager.getRootLogger();

    public CustomerServicePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @FindBy(className = "logo")
    WebElement logoBtn;

    @FindBy(css = "ul.article-list>li")
    WebElement learnMoreBtn;

    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Customer Service page opened");
    }

    public void backToMain(){
        logoBtn.click();
    }

    public void learnMore(){ learnMoreBtn.click(); }

}
