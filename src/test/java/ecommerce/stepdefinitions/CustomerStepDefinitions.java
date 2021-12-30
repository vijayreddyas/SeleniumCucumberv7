package ecommerce.stepdefinitions;

import ecommerce.base.TestContext;
import ecommerce.domainobjects.CheckOutDetails;
import io.cucumber.java.en.And;

/**
 * CustomerStepDefinitions holds the execution specifications
 *
 * @author Vijay
 * Dec 29, 2021
 */
public class CustomerStepDefinitions {
    private final TestContext context;

    public CustomerStepDefinitions(TestContext context) {
        this.context = context;
    }

    @And("My billing details are")
    public void MyBillingDetailsAre(CheckOutDetails checkOutDetails) {
        context.checkOutDetails = checkOutDetails;
    }
}