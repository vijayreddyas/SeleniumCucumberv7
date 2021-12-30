package ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * CartPage used for having the Cart page related methods and elements(Encapsulation)
 *
 * @author Vijay
 * Dec 29, 2021
 */
public class CartPage extends BasePage {
    @FindBy(id = "checkout")
    private WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * verify the product name and quantity on the cart page
     * @param product
     * @param quantity
     * @author Vijay
     * Dec 29, 2021
     */
    public void verifyProductQtyInCart(String product, Integer quantity) {
        try {
            WebElement qty = driver.findElement(By.xpath("//div[text()='" + product + "']/../../../div[@class='cart_quantity']"));
            waitForElementVisible(qty);
            Assert.assertEquals(String.valueOf(quantity), getText(qty));
        } catch (AssertionError e) {
            Assert.fail("Product quantity added to the cart is not matching");
        }
    }

    /**
     * click the checkout button
     * @author Vijay
     * Dec 29, 2021
     */
    public void clickCheckoutButton() {
        click(checkoutBtn);
    }
}