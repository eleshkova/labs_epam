package steps;

import org.junit.Assert;

import pages.AirewardsPage;
import pages.BookFlightsPage;

public class CustomerServicePageSteps extends Steps{

    public void initBrowser(){
        super.init();
    }

    public void backToMain(){
        CustomerServicePage customerServicePage = new CustomerServicePage(driver);
        customerServicePage.open();
        customerServicePage.backToMain();
    }

    public void isOnMainPage(){
        Assert.assertTrue("title should start with LOT Polish Airlines",
                driver.getTitle().startsWith("LOT Polish Airlines"));
    }

    public void learnMore(){
        CustomerServicePage customerServicePage = new CustomerServicePage(driver);
        customerServicePage.open();
        customerServicePage.learnMore();
    }

    public void isOnLearnMore(){
        Assert.assertTrue("title should contain Подготовка",
                driver.getTitle().contains("Подготовка"));
    }

    }
    public void openCustomerServicePage(){
        CustomerServicePage customerServicePage = new CustomerServicePage(driver);
        customerServicePage.open();
    }
}
