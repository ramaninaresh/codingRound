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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HotelBookingPage extends BasePageObject implements Object_Repo_All {

    private WebDriver driver=null;



    @FindBy(id = Hotel_ID_localityTextBox)
    private WebElement localityTextBox;

    @FindBy(xpath = Hotel_xpath_CheckInDate)
    private WebElement CheckInDate;

    @FindBy(xpath = Hotel_xpath_CheckOutDate)
    private WebElement CheckOutDate;

    @FindBy(id = Hotel_ID_travellersOnhome)
    private WebElement travellerSelection;

    @FindBy(id = Hotel_ID_SearchButton)
    private WebElement searchButton;

    @FindBy(xpath = Hotel_xpath_modifySearchLink)
    private WebElement modifySearchLink;

    @FindBy(xpath = Date_Picker_Table)
    private WebElement Date_Picker_Table_elem;



    public HotelBookingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitforPageLoad(20,driver,localityTextBox,"HotelBookingPage");
    }



    public boolean SearchHotel(String place,String travellerType,String beginDayOfMonth, String endDayOfMonth)
    {
        System.out.println("Searching Hotel");
        try {
            waitElementTobeClickable(20,driver,localityTextBox,"HotelBookingPage");
            localityTextBox.clear();
            localityTextBox.sendKeys(place);
            System.out.println("Waiting for list box to appear");
            Hard_wait(10000);
            System.out.println("Getting option from the list");
            List<WebElement> originOptions = driver.findElement(By.xpath("//li[@role='presentation']")).findElements(By.tagName("a"));
            System.out.println("List size for place is " + originOptions.size());
            originOptions.get(0).click();


            System.out.print("Updated: Location");

           CheckInDate.click();
            SelectDate(beginDayOfMonth);

            System.out.print("Updated: BeginDate");

            CheckOutDate.click();
            SelectDate(endDayOfMonth);

            System.out.print("Updated: EndDate");

            Select select = new Select(travellerSelection);
            System.out.println("Current Selected option : " + select.getFirstSelectedOption().getText());
            select.selectByVisibleText(travellerType);
            System.out.print("Selected: TravellerType");

            waitElementTobeClickable(20,driver,searchButton,"HotelBookingPage");
            searchButton.click();

            return true;
        }
        catch(Exception e){

            return  false;
        }


    }

    public boolean verifySearch()
    {   return modifySearchLink.isDisplayed();

    }

    public void SelectDate(String date)
    {


        List<WebElement> rows = Date_Picker_Table_elem.findElements(By.tagName("tr"));
        List<WebElement> columns = Date_Picker_Table_elem.findElements(By.tagName("td"));

        for (WebElement cell: columns)
        {
           if (cell.getText().equals(date))
           {
                cell.click();
                break;
            }
        }
    }

}
