package ecommerce.base;

import ecommerce.helpers.LoadConfigs;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * DriverFactory helps in creating the driver based on the run type and browser
 * @author Vijay
 * Dec 29, 2021
 */
public class DriverFactory {
    public static String os = System.getProperty("os.name").toLowerCase();

    /**
     * initialise the driver based on the browser type
     * @param browser
     * @return {@link org.openqa.selenium.WebDriver} instance.
     * @author Vijay
     * Dec 29, 2021
     */
    public static WebDriver initializeDriver(String browser) {
        WebDriver driver = null;
        String runMode = LoadConfigs.getInstance().getRunType();
        if (runMode.equalsIgnoreCase("local")) {
            switch (browser) {
                case "GoogleChrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "MozillaFireFox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "MSEdge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "Safari":
                    if (os.contains("mac")) {
                        WebDriverManager.safaridriver().setup();
                        driver = new SafariDriver();
                    }
                    break;
                default:
                    System.out.println("Please select the correct browser type");
                    break;
            }
        } else if (runMode.equalsIgnoreCase("remote")) {
            URL hubUrl = null;
            try {
                hubUrl = new URL("http://" + LoadConfigs.getInstance().getHost() + ":" + LoadConfigs.getInstance().getPort() + "/wd/hub");
                System.out.println("Selenium Hub URL :: " + hubUrl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                System.out.println("Error occurred @ HubURL Definition");
            }
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            switch (browser) {
                case "MozillaFireFox":
                    desiredCapabilities.setCapability("marionette", true);
                    desiredCapabilities.setBrowserName("firefox");
                    driver = getRemoteWebDriver(hubUrl, desiredCapabilities);
                    break;
                case "GoogleChrome":
                    desiredCapabilities.setBrowserName("chrome");
                    driver = getRemoteWebDriver(hubUrl, desiredCapabilities);
                    break;
                case "MSEdge":
                    desiredCapabilities.setBrowserName("edge");
                    driver = getRemoteWebDriver(hubUrl, desiredCapabilities);
                    break;
                default:
                    System.out.println("Please select the correct browser type");
                    break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }

    /**
     * created the RemoteWebDriver instance using the provided Selenium Grid/Selenoid details & Capabilities
     * @param hubUrl, desiredCapabilities
     * @return {@link org.openqa.selenium.remote.RemoteWebDriver} instance.
     * @author Vijay
     * Dec 29, 2021
     */
    private static RemoteWebDriver getRemoteWebDriver(URL hubUrl, DesiredCapabilities desiredCapabilities) {
        try {
            return new RemoteWebDriver(hubUrl, desiredCapabilities);
        } catch (WebDriverException e) {
            if (e.getMessage().contains("Unable to bind")) {
                try {
                    Thread.sleep(Integer.parseInt(LoadConfigs.getInstance().getBindExceptionTimeOut("60000")));
                    return new RemoteWebDriver(hubUrl, desiredCapabilities);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    System.out.println("Error while retrying to initialize WebDriver");
                }
            } else {
                e.printStackTrace();
            }
        }
        return null;
    }
}