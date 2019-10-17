package pageObject;

import base.BasePageObject;
import objectRepo.Object_Repo_All;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SignInPage extends BasePageObject implements Object_Repo_All {
    private WebDriver driver=null;

    @FindBy(id = signInPage_SignIn_ID)
    private WebElement SignIn_link;

    @FindBy(id = signInPage_SignIn_Button_ID)
    private WebElement SignIn_Button;

    @FindBy(id = signInPage_error_message_ID)
    private WebElement error_message;

    @FindBy(xpath = Signin_Model_Iframe_xPath)
    private WebElement Signin_Model_Iframe;

    public SignInPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver, this);
        waitforPageLoad(5,driver,SignIn_link,"SignInPage");
    }

    public String getUnsuccessfulLoginMessage()
    {   waitElementTobeVisible(5,driver,error_message,"SignInPage");
        return error_message.getText();

    }

    public Boolean loginWithoutData(){

        waitElementTobeClickable(2,driver,SignIn_link,"SignInPage");
        SignIn_link.click();
        System.out.println("Link clicked: SignIn");

        System.out.println("Switching to: Iframe");
        try {
            driver.switchTo().frame(Signin_Model_Iframe);
            System.out.println("Switching to Iframe completed");
            waitElementTobeClickable(2,driver,SignIn_Button,"SignInPage");
            SignIn_Button.click();
            System.out.println("Button clicked: SignIn");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;

        }
        return true;


    }


}
