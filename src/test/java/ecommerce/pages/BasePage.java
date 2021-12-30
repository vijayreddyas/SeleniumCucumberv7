package ecommerce.pages;

import ecommerce.constants.TimeOuts;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage helps in creating the driver instance and acts as a super class for all the remaining page object classes
 * Also contains reusable Selenium methods
 *
 * @author Vijay
 * Dec 29, 2021
 */
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor to initialise the driver, wait object and PageFactory
     * Also contains reusable Selenium methods
     *
     * @author Vijay
     * Dec 29, 2021
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(TimeOuts.EXPLICIT_TIME_OUT_IN_SECONDS));
        PageFactory.initElements(driver, this);
    }

    /**
     * loads the application on the browser with the given url
     *
     * @param url
     * @author Vijay
     * Dec 29, 2021
     */
    public void load(String url) {
        driver.get(url);
    }

    /**
     * inputs the text into the given field
     *
     * @param webElement
     * @param text
     * @author Vijay
     * Dec 29, 2021
     */
    public void type(WebElement webElement, String text) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.sendKeys(text);
        } catch (WebDriverException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to input text to element");
        }
    }

    /**
     * click the given element
     *
     * @param webElement
     * @author Vijay
     * Dec 29, 2021
     */
    public void click(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        } catch (WebDriverException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to click element");
        }
    }

    /**
     * wait for the given element to be visible
     *
     * @param webElement
     * @author Vijay
     * Dec 29, 2021
     */
    public void waitForElementVisible(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (WebDriverException e) {
            e.printStackTrace();
            throw new RuntimeException("Element is not visible");
        }
    }

    /**
     * returns the text from the given element
     *
     * @param webElement
     * @return text
     * @author Vijay
     * Dec 29, 2021
     */
    public String getText(WebElement webElement) {
        String text = "";
        try {
            text = webElement.getText().trim();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get text from Element");
        }
        return text;
    }

    /**
     * returns the current page title
     *
     * @author Vijay
     * Dec 29, 2021
     */
    public String getTitle() {
        String text = "";
        try {
            text = driver.getTitle();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get the title of the page");
        }
        return text;
    }

    /**
     * captures the screenshot of the page in focus
     *
     * @author Vijay
     * Dec 29, 2021
     */
    public byte[] getScreenshot() {
        return ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * attaches the captured screenshot to the given scenario on report
     *
     * @param scenario
     * @author Vijay
     * Dec 29, 2021
     */
    public void captureScreenshotAndAttachToReport(Scenario scenario) {
        scenario.attach(getScreenshot(), "image/png", scenario.getName());
    }
}