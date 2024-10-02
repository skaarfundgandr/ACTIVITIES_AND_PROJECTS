public class NonPerishableProduct extends Product {
    private String productID;
    private String productName;
    private int quantity;
    private double price;
    private int shelfLife;

    // Setter
    public void setShelfLife(int num) {
        shelfLife = num;
    }
    // Getter
    public int getShelfLife() {
        return shelfLife;
    }

    public String toString() {
        return  "ProductID: " + productID + "\n" +
                "Product name: " + productName + "\n" +
                "Quantity: " + quantity + "\n" +
                "Price: PHP" + price + "\n" +
                "Shelf life: " + shelfLife + " days\n";
    }
}
