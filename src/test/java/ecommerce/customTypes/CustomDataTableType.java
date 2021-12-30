package ecommerce.customTypes;

import ecommerce.domainobjects.CheckOutDetails;
import ecommerce.domainobjects.LoginDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;

/**
 * CustomDataTableType is used for having all the Custom Data Table types
 * @author Vijay
 * Dec 29, 2021
 */
public class CustomDataTableType {

    /**
     * Create the Custom Data Table for the values/parameters that are coming from the login step definition(ecommerce.stepdefinitions.LoginStepDefinitions)
     * @param entry
     * @return {@link ecommerce.domainobjects.LoginDetails} instance.
     * @author Vijay
     * Dec 29, 2021
     */
    @DataTableType
    public LoginDetails loginDetailsEntry(Map<String, String> entry) {
        return new LoginDetails(entry.get("username"),
                entry.get("password"));
    }

    /**
     * Create the Custom Data Table for the values/parameters that are coming from the Customer step definition(ecommerce.stepdefinitions.CustomerStepDefinitions)
     * @param entry
     * @return {@link ecommerce.domainobjects.CheckOutDetails} instance.
     * @author Vijay
     * Dec 29, 2021
     */
    @DataTableType
    public CheckOutDetails checkOutDetailsEntry(Map<String, String> entry){
        return new CheckOutDetails(entry.get("firstname"),
                entry.get("lastname"),
                entry.get("postal"));
    }
}
