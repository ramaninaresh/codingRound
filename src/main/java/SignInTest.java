import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.SignInPage;


public class SignInTest extends BaseTest {



    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
        HomePage homePage = new HomePage(driver);
        homePage.click_YourTrips();

        SignInPage signInPage = new SignInPage(driver);
        boolean result=signInPage.loginWithoutData();

        if(result)
        {
            String errors1=signInPage.getUnsuccessfulLoginMessage();
            System.out.println("Actual error message : "+errors1 );
            Assert.assertTrue(errors1.contains("There were errors in your submission"));
        }
        else
        {
            Assert.assertTrue(false,"Not able to process the Login mehtod");
        }
    }



}
