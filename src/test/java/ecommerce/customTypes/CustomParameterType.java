package ecommerce.customTypes;

import ecommerce.domainobjects.Product;
import io.cucumber.java.ParameterType;

/**
 * CustomParameterType is used for matching the parameter value coming from Gherkin/Step Definition
 * @author Vijay
 * Dec 29, 2021
 */
public class CustomParameterType {
    /**
     * Create the Custom Data Table for the values/parameters that are coming from the login step definition(ecommerce.stepdefinitions.CartStepDefinitions)
     * @param name
     * @return {@link ecommerce.domainobjects.Product} instance.
     * @author Vijay
     * Dec 29, 2021
     */
    @ParameterType(".*")
    public Product product(String name) {
        return new Product(name.replace("\"", ""));
    }
}