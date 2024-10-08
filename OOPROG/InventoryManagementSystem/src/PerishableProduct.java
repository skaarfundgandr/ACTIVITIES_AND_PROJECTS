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
    public void addStock(int amount) throws InvalidQuantityException {
        if (amount < 0) {
            throw new InvalidQuantityException("Quantity cannot be negative");
        }
        if ((super.getQuantity() + amount) > 100) {
            throw new InvalidQuantityException("Cannot exceed maximum quantity of 100 for perishable products.");
        } else {
            super.setQuantity(super.getQuantity() + amount);
            System.out.println(super.getProductName() + " new quantity is " + super.getQuantity());
        }
    }

    public String toString() {
        return  "ProductID: " + super.getProductID() + "\n" +
                "Product name: " + super.getProductName() + "\n" +
                "Quantity: " + super.getQuantity() + "\n" +
                "Price: PHP" + super.getPrice() + "\n" +
                "Expiration date: " + expirationDate + "\n";
    }
}
