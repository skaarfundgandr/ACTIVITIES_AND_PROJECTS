import java.util.ArrayList;

public class Inventory implements InventoryOperation {
    private ArrayList<Product> products = new ArrayList<Product>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added " + product.getProductName() + " with quantity " + product.getQuantity());
    }

    public void removeProduct(String productID) throws ProductNotFoundException {
        if (products.removeIf(prod -> prod.getProductID().equals(productID))) {
            System.out.println("Product " + productID + " removed successfully");
        } else {
            throw new ProductNotFoundException("Cannot find product " + productID);
        }
    }
}
