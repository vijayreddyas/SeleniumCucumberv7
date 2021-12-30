package ecommerce.pages;

import org.openqa.selenium.WebDriver;

/**
 * PageFactoryManager used for creating the instances for page objects based on the null check
 *
 * @author Vijay
 * Dec 29, 2021
 */
public class PageFactoryManager {
    private static LoginPage loginPage;
    private static HomePage homePage;
    private static CartPage cartPage;
    private static CheckOutPage checkOutPage;

    public static LoginPage getLoginPage(WebDriver driver){
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }

    public static HomePage getHomePage(WebDriver driver){
        return homePage == null ? new HomePage(driver) : homePage;
    }

    public static CartPage getCartPage(WebDriver driver) {
        return cartPage == null ? new CartPage(driver) : cartPage;
    }

    public static CheckOutPage getCheckOutPage(WebDriver driver) {
        return checkOutPage == null ? new CheckOutPage(driver) : checkOutPage;
    }
}