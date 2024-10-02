import java.util.ArrayList;

public class Inventory implements InventoryOperation {
    private ArrayList<Product> products = new ArrayList<Product>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added " + product.getProductName() + " with quantity " + product.getQuantity());
    }

    public void removeProduct(String productID) throws InsufficientStockException {
        if (products.removeIf(prod -> prod.getProductID().equals(productID))) {
            System.out.println("Product " + productID + " removed successfully");
        } else {
            throw new InsufficientStockException("Cannot find product " + productID);
        }
    }
}
