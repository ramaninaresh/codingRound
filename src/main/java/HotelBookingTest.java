import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.HotelBookingPage;
import pageObject.SignInPage;

public class HotelBookingTest extends BaseTest {



   @Test
    public void shouldBeAbleToSearchForHotels() {
       HomePage homePage = new HomePage(driver);
       homePage.click_Hotel_Tab();

       HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
       boolean searchOperation=hotelBookingPage.SearchHotel("Banglore","1 room, 2 adults");
       if(searchOperation) {
           boolean result = hotelBookingPage.verifySearch();
           Assert.assertTrue(result, "Result is not successfull");
       }
       else
       {
           Assert.assertTrue(false,"Result is not successfull");
       }




    }

}
