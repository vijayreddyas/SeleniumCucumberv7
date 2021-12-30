package ecommerce.base;

import ecommerce.domainobjects.CheckOutDetails;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

/**
 * TestContext helps in sharing the driver, scenario & Billing details among the scenario and steps
 * This is implemented using the Pico Container concepts
 * @author Vijay
 * Dec 29, 2021
 */
public class TestContext {
    public WebDriver driver;
    public Scenario scenario;
    public CheckOutDetails checkOutDetails;
    public TestContext() {
    }
}