package ecommerce.stepdefinitions;

import ecommerce.base.TestContext;
import ecommerce.constants.StaticTexts;
import ecommerce.domainobjects.LoginDetails;
import ecommerce.helpers.LoadConfigs;
import ecommerce.pages.LoginPage;
import ecommerce.pages.PageFactoryManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * LoginStepDefinitions holds the execution specifications
 *
 * @author Vijay
 * Dec 29, 2021
 */
public class LoginStepDefinitions {
    private final LoginPage loginPage;
    private final TestContext context;

    public LoginStepDefinitions(TestContext context) {
        this.context = context;
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }

    @Given("I'm on SwagLabs LoginPage")
    public void iMOnSwagLabsLoginPage() {
        loginPage.load(LoadConfigs.getInstance().getUrl());
        loginPage.verifySwagLabsPageTitle(StaticTexts.SWAG_LABS_TITLE);
    }

    @When("My Login details are")
    public void myLoginDetailsAre(LoginDetails loginDetails) {
        loginPage.login(loginDetails.getUsername(), loginDetails.getPassword());
    }

    @Then("Login should be success/failure")
    public void loginShouldBeSuccess() {
        if(context.scenario.getName().contains("invalid")) {
            loginPage.verifyLoginFail();
        } else {
            loginPage.verifyHomePage();
            loginPage.logout();
        }
    }
}