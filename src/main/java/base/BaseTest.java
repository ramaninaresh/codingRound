package base;

import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver ;
    public static Properties properties;
    public String baseUrl="";

    @BeforeSuite
    public void suiteSetup() throws IOException {
        setDriverPath();
        loadProjectConfig();

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
    public void methodSetup()
    {
        baseUrl = properties.getProperty("BASE_URL");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }
}
