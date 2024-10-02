import java.util.ArrayList;

public class Inventory implements InventoryOperation {
    private ArrayList<Product> products = new ArrayList<Product>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added " + product.getProductName() + " with quantity " + product.getQuantity());
    }

    public void removeProduct(String productID) {
        products.removeIf(prod -> prod.getProductID().equals(productID));
    }

    private boolean isDuplicate(Product product) {
        String productID = product.getProductID();
        return products.stream().anyMatch(prod -> prod.getProductID().equals(productID));
    }
}
