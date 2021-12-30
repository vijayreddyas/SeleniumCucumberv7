package ecommerce.domainobjects;

/**
 * CheckOutDetails is a Domain Object that holds the product details
 * @author Vijay
 * Dec 29, 2021
 */
public class Product {
    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
