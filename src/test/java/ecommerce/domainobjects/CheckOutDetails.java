package ecommerce.domainobjects;

/**
 * CheckOutDetails is a Domain Object that holds the checkout details to be shared in further steps
 * @author Vijay
 * Dec 29, 2021
 */
public class CheckOutDetails {
    private String firstName;
    private String lastName;
    private String postalCode;

    public CheckOutDetails(String firstName, String lastName,
                          String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}