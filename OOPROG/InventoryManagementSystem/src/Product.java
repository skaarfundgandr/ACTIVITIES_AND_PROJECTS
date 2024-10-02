public class Product {
    private String productID;
    private String productName;
    private int quantity;
    private double price;

    // Setters
    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int num) {
        quantity = num;
    }

    public void setPrice(double num) {
        price = num;
    }
    // Getters
    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void updateStock(int amount) {
        quantity += amount;
    }
}
