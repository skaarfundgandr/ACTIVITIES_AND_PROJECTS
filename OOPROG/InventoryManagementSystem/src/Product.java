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

    public void addStock(int amount) throws InvalidQuantityException {
        if (amount < 0) {
            throw new InvalidQuantityException("Quantity cannot be negative!");
        }
        quantity += amount;
    }

    public void removeStock(int amount) throws InvalidQuantityException, InsufficientStockException {
        if (amount < 0) {
            throw new InvalidQuantityException("Quantity cannot be negative!");
        }
        if ((quantity - amount) < 0) {
            throw new InsufficientStockException("Insufficient stock for " + productName);
        }
        quantity -= amount;
        System.out.println(productName + " new quantity is " + quantity);
    }
}
