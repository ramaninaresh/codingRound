package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.SignInPage;

public class BasePageObject {
    public void waitElementTobeClickable(int seconds,WebDriver driver, WebElement element,String pageName)
    {
        System.out.println("Waiting for element to be clickable on " + pageName );
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));


    }

    public void waitElementTobeVisible(int seconds,WebDriver driver,WebElement element,String pageName)
    {
        System.out.println("Waiting for element to be visible on" + pageName );
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOf(element));


    }

    public void waitforPageLoad(int seconds, WebDriver driver, WebElement element, String pageName)
    {
        System.out.println("Waiting for Page to load :" + pageName);
        WebDriverWait wait = new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));


    }

    public void Hard_wait(int Millseconds)
    {
        try {
            Thread.sleep(Millseconds);
        }
        catch(Exception e)
        {

        }
    }



}
