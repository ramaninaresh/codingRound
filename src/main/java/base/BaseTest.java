package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.javafx.PlatformUtil;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;




public class BaseTest {

    public WebDriver driver ;
    public static Properties properties;
    public String baseUrl="";
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    @BeforeSuite
    public void suiteSetup() throws IOException {

        loadProjectConfig();
        extentReports = new ExtentReports(System.getProperty("user.dir") + "/report/test" + new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(Calendar.getInstance().getTime()) + ".html", false);


    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");

        }
    }

    public void loadProjectConfig() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties")));

    }

    @BeforeMethod
    public void methodSetup(Method method)
    {   setDriverPath();
        baseUrl = properties.getProperty("BASE_URL");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        extentTest = extentReports.startTest(method.getName());
        extentTest.log(LogStatus.INFO, method.getName() + " test Started");
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException
    {
        if (result.getStatus() == ITestResult.SUCCESS) {

            extentTest.log(LogStatus.PASS, result.getName() + " test is pass");
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
        } else if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
            String screen = getScreenShot("");
            extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screen));
        } else if (result.getStatus() == ITestResult.STARTED) {
            extentTest.log(LogStatus.INFO, result.getName() + " test is started");
        }
        extentReports.endTest(extentTest);
        extentReports.flush();
        //	log.info(result.getName() + "() test method Ended");
        System.out.println("Quiting Driver");
        driver.quit();
    }

    public String getScreenShot(String imageName) throws IOException {

        if (imageName.equals("")) {
            imageName = "blank";
        }
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String imagelocation = System.getProperty("user.dir") + "//screenshot//";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String actualImageName = imagelocation + imageName + "_" + formater.format(calendar.getTime()) + ".png";
        File destFile = new File(actualImageName);
        FileUtils.copyFile(image, destFile);
        return actualImageName;
    }
}
