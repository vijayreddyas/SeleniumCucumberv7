package ecommerce.stepdefinitions;

import ecommerce.base.TestContext;
import ecommerce.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * CheckOutStepDefinitions holds the execution specifications
 *
 * @author Vijay
 * Dec 29, 2021
 */
public class CheckOutStepDefinitions {
    private final CheckOutPage checkOutPage;
    private final HomePage homePage;
    private final CartPage cartPage;
    private final TestContext context;

    public CheckOutStepDefinitions(TestContext context) {
        this.context = context;
        checkOutPage = PageFactoryManager.getCheckOutPage(context.driver);
        homePage = PageFactoryManager.getHomePage(context.driver);
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
        checkOutPage.fillCheckoutInfo(context.checkOutDetails.getFirstName(), context.checkOutDetails.getLastName(),
                context.checkOutDetails.getPostalCode());
    }

    @And("I place an order")
    public void iPlaceAnOrder() {
        checkOutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        checkOutPage.verifyOrderPlacement();
    }
}