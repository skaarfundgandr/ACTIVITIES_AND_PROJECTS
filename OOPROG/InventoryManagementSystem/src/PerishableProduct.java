public class PerishableProduct extends Product {
    private String productID;
    private String productName;
    private int quantity;
    private double price;
    private String expirationDate;

    // Setters
    public void setExpirationDate(String str) {
        expirationDate = str;
    }

    // Getter
    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void updateStock(int amount) throws InvalidQuantityException {
        quantity += amount;
        if (amount > 100) {
            throw new InvalidQuantityException("Error! Amount must not be more than 100");
        }
    }

    public String toString() {
        return  "ProductID: " + productID + "\n" +
                "Product name: " + productName + "\n" +
                "Quantity: " + quantity + "\n" +
                "Price: PHP" + price + "\n" +
                "Expiration date: " + expirationDate + "\n";
    }
}
