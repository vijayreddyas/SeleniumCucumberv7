package ecommerce.pages;

import ecommerce.constants.StaticTexts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * LoginPage used for having the Login page related methods and elements(Encapsulation)
 *
 * @author Vijay
 * Dec 29, 2021
 */
public class LoginPage extends BasePage {
    @FindBy(css = "#user-name")
    private WebElement usernameFld;

    @FindBy(id = "password")
    private WebElement passwordFld;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(css = "h3[data-test='error']")
    private WebElement loginErrorTxt;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logoutLink;

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement productsTxt;

    @FindBy(className = "bm-burger-button")
    private WebElement openMenuBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * verify SwagLabs page title
     * @param title
     * @author Vijay
     * Dec 29, 2021
     */
    public void verifySwagLabsPageTitle(String title) {
        String text = getTitle();
        Assert.assertEquals(text, title);
    }

    /**
     * login to the application
     * @param username
     * @param password
     * @author Vijay
     * Dec 29, 2021
     */
    public void login(String username, String password) {
        type(usernameFld, username);
        type(passwordFld, password);
        click(loginBtn);
    }

    /**
     * verify login fail when logged in with invalid details
     *
     * @author Vijay
     * Dec 29, 2021
     */
    public void verifyLoginFail() {
        try {
            loginErrorTxt.isDisplayed();
            Assert.assertEquals(getText(loginErrorTxt), StaticTexts.LOGIN_FAILURE_MSG);
        } catch (WebDriverException e) {
            e.printStackTrace();
            throw new RuntimeException("Login Error Message not shown");
        } catch (AssertionError e) {
            Assert.fail("Login is not failed with appropriate error message");
        }
    }

    /**
     * Verify user landed on HomePage post successful login
     *
     * @author Vijay
     * Dec 29, 2021
     */
    public void verifyHomePage() {
        try {
            productsTxt.isDisplayed();
        } catch (WebDriverException e) {
            e.printStackTrace();
            Assert.fail("Login is not success and user is not landed on the HomePage");
        }
    }

    /**
     * logout from the application
     *
     * @author Vijay
     * Dec 29, 2021
     */
    public void logout() {
        click(openMenuBtn);
        click(logoutLink);
        String text = getTitle();
        Assert.assertEquals(text, StaticTexts.SWAG_LABS_TITLE);
    }
}
