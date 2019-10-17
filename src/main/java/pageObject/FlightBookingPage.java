package pageObject;

import base.BasePageObject;
import objectRepo.Object_Repo_All;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class FlightBookingPage extends BasePageObject implements Object_Repo_All {
    private WebDriver driver=null;

    @FindBy(id = Flight_ID_OneWay_Option)
    private WebElement Flight_OneWay_Option_elem;

    @FindBy(id = Flight_ID_from_option)
    private WebElement Flight_ID_from_option_elem;

    @FindBy(id = Flight_ID_to_option)
    private WebElement Flight_ID_to_option_elem;

    @FindBy(xpath = Flight_xpath_cal)
    private WebElement Flight_xpath_cal_elem;

    @FindBy(id = Flight_ID_search_button)
    private WebElement Flight_ID_search_button_elem;

    @FindBy(className = Flight_class_searchSummary)
    private WebElement Flight_class_searchSummary_elem;


    public FlightBookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitforPageLoad(20,driver,Flight_ID_from_option_elem,"FlightBookingPage");
    }

    public boolean bookFlight()
    {   try
        {
        waitElementTobeClickable(20, driver, Flight_OneWay_Option_elem, "FlightBookingPage");
        Flight_OneWay_Option_elem.click();


        waitElementTobeClickable(20, driver, Flight_ID_from_option_elem, "FlighBookingPage");
        Flight_ID_from_option_elem.clear();
        Flight_ID_from_option_elem.sendKeys("Bangalore");
        Hard_wait(10000);
        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        originOptions.get(0).click();


        waitElementTobeClickable(20, driver, Flight_ID_to_option_elem, "FlightBookingPage");
        Flight_ID_to_option_elem.clear();
        Flight_ID_to_option_elem.sendKeys("Delhi");
        Hard_wait(10000);
        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        destinationOptions.get(0).click();


        waitElementTobeClickable(20, driver, Flight_xpath_cal_elem, "FlighBookingPage");
        Flight_xpath_cal_elem.click();


        waitElementTobeClickable(20, driver, Flight_ID_search_button_elem, "FlighBookingPage");
        Flight_ID_search_button_elem.click();

        return true;
    }
    catch (Exception e)
    {
       return false;
    }

}

    public Boolean verifyBooking()
    {
        return Flight_class_searchSummary_elem.isDisplayed();

    }
}
