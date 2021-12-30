package ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * HomePage used for having the Home page related methods and elements(Encapsulation)
 *
 * @author Vijay
 * Dec 29, 2021
 */
public class HomePage extends BasePage {
    @FindBy(className = "shopping_cart_badge")
    private WebElement cartQuantityBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * add product to cart
     * @param product
     * @author Vijay
     * Dec 29, 2021
     */
    public void addProductToCart(String product) {
        String customIdentifier = product.toLowerCase().replace(" ", "-");
        WebElement addToCartBtn = driver.findElement(By.cssSelector("#add-to-cart-" + customIdentifier));
        click(addToCartBtn);
    }

    /**
     * verify product that is added to cart
     * @param product
     * @author Vijay
     * Dec 29, 2021
     */
    public void verifyProductAddedToCart(String product) {
        String customIdentifier = product.toLowerCase().replace(" ", "-");
        WebElement removeFromCartBtn = driver.findElement(By.cssSelector("#remove-" + customIdentifier));
        try {
            removeFromCartBtn.isDisplayed();
        } catch (WebDriverException e) {
            e.printStackTrace();
            throw new RuntimeException("Product not added to cart & Remove button is not shown");
        }
    }

    /**
     * open the cart page
     * @author Vijay
     * Dec 29, 2021
     */
    public void openCart() {
        click(cartQuantityBtn);
    }
}