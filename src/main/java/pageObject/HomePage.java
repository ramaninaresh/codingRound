package pageObject;



import base.BasePageObject;
import objectRepo.Object_Repo_All;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePageObject implements Object_Repo_All {
    private WebDriver driver=null;

    @FindBy(linkText = signInPage_Your_trip_link)
    private WebElement Your_trip_link;

    @FindBy(linkText = Hotel_link_text)
    private WebElement Hotel_link_text_elem;

    @FindBy(linkText = Flight_link_text)
    private WebElement Flight_link_text_elem;

    public HomePage(WebDriver driver) {
        System.out.println("Initializing Page: HomePage");
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitforPageLoad(20,driver,Your_trip_link,"HomePage");
    }

    public void click_YourTrips()
    {
        waitElementTobeClickable(20,driver,Your_trip_link,"HomePage");
        Your_trip_link.click();
    }

    public void click_Hotel_Tab()
    {
        waitElementTobeClickable(20,driver,Hotel_link_text_elem,"HomePage");
        Hotel_link_text_elem.click();
    }

    public void click_Flight_Tab()
    {
        waitElementTobeClickable(20,driver,Flight_link_text_elem,"HomePage");
        Flight_link_text_elem.click();
    }

}
