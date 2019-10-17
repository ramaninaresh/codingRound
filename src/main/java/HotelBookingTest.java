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
       boolean searchOperation=hotelBookingPage.SearchHotel(
                        properties.getProperty("HOTEL_PLACE"),
                        properties.getProperty("HOTEL_TRAVELLER_TYPE"),
                        properties.getProperty("HOTEL_BEGIN_DAY_OF_MONTH"),
                        properties.getProperty("HOTEL_END_DAY_OF_MONTH"))
               ;
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
