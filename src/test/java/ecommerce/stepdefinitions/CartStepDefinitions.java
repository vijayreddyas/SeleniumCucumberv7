package ecommerce.stepdefinitions;

import ecommerce.base.TestContext;
import ecommerce.domainobjects.Product;
import ecommerce.pages.CartPage;
import ecommerce.pages.HomePage;
import ecommerce.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

/**
 * CartStepDefinitions holds the execution specifications
 *
 * @author Vijay
 * Dec 29, 2021
 */
public class CartStepDefinitions {
    private final HomePage homePage;
    private final CartPage cartPage;
    private final TestContext context;

    public CartStepDefinitions(TestContext context) {
        this.context = context;
        homePage = PageFactoryManager.getHomePage(context.driver);
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        homePage.openCart();
        cartPage.verifyProductQtyInCart(product.getName(), quantity);
    }

    @And("I have product added in the cart")
    public void iHaveAProductInTheCart() {
        homePage.addProductToCart("Sauce Labs Backpack");
        homePage.verifyProductAddedToCart("Sauce Labs Backpack");
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        homePage.openCart();
        cartPage.clickCheckoutButton();
    }
}