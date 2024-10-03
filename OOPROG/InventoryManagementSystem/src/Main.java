public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        // Case 1
        PerishableProduct apple = new PerishableProduct();
        apple.setProductName("Apple");
        apple.setProductID("P001");
        apple.setQuantity(50);
        apple.setPrice(0.5);
        apple.setExpirationDate("2024-12-31");
        inventory.addProduct(apple);

        // Case 2
        NonPerishableProduct rice = new NonPerishableProduct();
        rice.setProductName("Rice");
        rice.setProductID("NP001");
        rice.setQuantity(200);
        rice.setPrice(1.0);
        rice.setShelfLife(100);
        inventory.addProduct(rice);

        // Case 3
        try {
            apple.updateStock(30);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Case 4
        try {
            apple.updateStock(30);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Case 5
        try {
            inventory.removeProduct("P001");
        } catch (InsufficientStockException e) {
            System.out.println(e.getMessage());
        }

        // Case 6
        try {
            apple.removeStock(160);
        } catch (InsufficientStockException e) {
            System.out.println(e.getMessage());
        }

        // Case 7
        try {
            apple.updateStock(-10);
        } catch (InvalidQuantityException e) {
            System.out.println(e.getMessage());
        }
    }
}
