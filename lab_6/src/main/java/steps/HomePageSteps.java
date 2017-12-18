package steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;

import pages.MainPage;

public class HomePageSteps extends Steps {

    public void initBrowser(){
        super.init();
    }

    public void openHomePage(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
    }

    public void searchPath(String date) {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.search(date);
    }

    public void isOnSchedulePage() {
        Assert.assertTrue("title should contain Lot-Airways",
                driver.getTitle().contains("Lot-Airways"));
    }

    public void changeLanguage(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.changeLanguage();
    }

    public void isLanguageChanged(){
        WebElement bodyTag = driver.findElement(By.xpath("//body"));
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        Assert.assertTrue("Language should be English",
                bodyTag.getAttribute("data-lang").equals("en"));
    }

    public void chooseContrast(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.chooseContrast();
    }

    public void isContrastChosen(){
        WebElement bodyTag = driver.findElement(By.xpath("//body"));
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        Assert.assertTrue("Contrast should be high",
                bodyTag.getAttribute("class").equals("high-contrast"));
    }

    public void changeSlide(){
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.changeSlide();
    }

    public void isSlideChanged(){
        WebElement sliderNav = driver.findElement(By.xpath(".//*[text()='Go to slide 3']/.."));
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        Assert.sliderNav("Third slide should be active",
                bodyTag.getAttribute("class").equals("active"));
    }

}
