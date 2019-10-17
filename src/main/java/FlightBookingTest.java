import base.BaseTest;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.FlightBookingPage;
import pageObject.HomePage;

import java.util.List;

public class FlightBookingTest extends BaseTest {




    @Test
    public void testThatResultsAppearForAOneWayJourney() {

        HomePage homePage = new HomePage(driver);
        homePage.click_Flight_Tab();

        FlightBookingPage flightBookingPage = new FlightBookingPage(driver);
        boolean flightbookingOperation=flightBookingPage.bookFlight();
        if (flightbookingOperation) {
            Boolean result = flightBookingPage.verifyBooking();
            Assert.assertTrue(result, "Booking was not completed ");
        }
        else
        {
            Assert.assertTrue(false,"Booking was unSuccessfull");
        }


    }

}
