package ecommerce.stepdefinitions;

import ecommerce.base.TestContext;
import ecommerce.constants.StaticTexts;
import ecommerce.domainobjects.LoginDetails;
import ecommerce.domainobjects.Product;
import ecommerce.helpers.LoadConfigs;
import ecommerce.pages.CartPage;
import ecommerce.pages.HomePage;
import ecommerce.pages.LoginPage;
import ecommerce.pages.PageFactoryManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * HomeStepDefinitions holds the execution specifications
 *
 * @author Vijay
 * Dec 29, 2021
 */
public class HomeStepDefinitions {
    private final LoginPage loginPage;
    private final HomePage homePage;
    private final CartPage cartPage;
    private final TestContext context;

    public HomeStepDefinitions(TestContext context) {
        this.context = context;
        loginPage = PageFactoryManager.getLoginPage(context.driver);
        homePage = PageFactoryManager.getHomePage(context.driver);
        cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @Given("I'm on the Products Page LoggedIn With Details")
    public void iMOnTheProductsPageLoggedInWithDetails(LoginDetails loginDetails) {
        loginPage.load(LoadConfigs.getInstance().getUrl());
        loginPage.verifySwagLabsPageTitle(StaticTexts.SWAG_LABS_TITLE);
        loginPage.login(loginDetails.getUsername(), loginDetails.getPassword());
        loginPage.verifyHomePage();
    }


    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product) {
        homePage.addProductToCart(product.getName());
        homePage.verifyProductAddedToCart(product.getName());
    }
}