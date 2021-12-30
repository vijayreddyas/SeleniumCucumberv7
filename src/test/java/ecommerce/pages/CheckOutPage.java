package ecommerce.pages;

import ecommerce.constants.StaticTexts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * CheckOutPage used for having the CheckOut page related methods and elements(Encapsulation)
 *
 * @author Vijay
 * Dec 29, 2021
 */
public class CheckOutPage extends BasePage {
    @FindBy(css = "#first-name")
    private WebElement firstNameFld;

    @FindBy(css = "#last-name")
    private WebElement lastNameFld;

    @FindBy(id = "postal-code")
    private WebElement postalCodeFld;

    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(className = "inventory_item_name")
    private WebElement productName;

    @FindBy(className = "cart_quantity")
    private WebElement quantity;

    @FindBy(id = "finish")
    private WebElement finishBtn;

    @FindBy(className = "complete-header")
    private WebElement orderConfirmationTxt;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement checkoutCompleteTxt;

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    /**
     * fill the checkout information on the CheckOut page and click on Continue Button
     * @param firstName
     * @param lastName
     * @param postalCode
     * @author Vijay
     * Dec 29, 2021
     */
    public void fillCheckoutInfo(String firstName, String lastName, String postalCode) {
        type(firstNameFld, firstName);
        type(lastNameFld, lastName);
        type(postalCodeFld, postalCode);
        click(continueBtn);
    }

    /**
     * Click on Finish button to place order
     * @author Vijay
     * Dec 29, 2021
     */
    public void placeOrder() {
        click(finishBtn);
    }

    /**
     * verify the order placement
     * @author Vijay
     * Dec 29, 2021
     */
    public void verifyOrderPlacement() {
        try {
            Assert.assertEquals(getText(checkoutCompleteTxt), StaticTexts.CHECKOUT_COMPLETE_MSG);
            Assert.assertEquals(getText(orderConfirmationTxt), StaticTexts.ORDER_SUCCESS_MSG);
        } catch (WebDriverException | AssertionError e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to complete the checkout");
        }
    }
}