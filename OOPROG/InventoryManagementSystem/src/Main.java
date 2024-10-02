public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        // Case 1
        PerishableProduct apple = new PerishableProduct();
        apple.setProductName("Apple");
        apple.setProductID("P001");
        apple.setQuantity(50);
        apple.setPrice(0.5);
        apple.setExpirationDate("2024-12-31");
        inv.addProduct(apple);

        // Case 2
        NonPerishableProduct rice = new NonPerishableProduct();
        rice.setProductName("Rice");
        rice.setProductID("NP001");
        rice.setQuantity(200);
        rice.setPrice(1.0);
        rice.setShelfLife(100);
        inv.addProduct(rice);

        // Case 3
    }
}
