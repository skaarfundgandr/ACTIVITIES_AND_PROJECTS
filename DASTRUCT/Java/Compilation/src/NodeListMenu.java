import java.util.Scanner;

public class NodeListMenu {
    public void menu() {
        char choice;

        NodeList nodeList = new NodeList();
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("-- Node List Menu --");
            System.out.println("1] Add an item");
            System.out.println("2] Delete an item");
            System.out.println("3] Display List (FIFO)");
            System.out.println("4] Display List (LIFO)");
            System.out.println("x] Exit Program");

            System.out.print("Enter your choice: ");
            choice = scan.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    System.out.println("Enter value to add: ");
                    nodeList.add(scan.nextLine());

                    break;
                case '2':
                    System.out.println("Enter the location of the value you want to delete:");
                    nodeList.delete(scan.nextInt());
                    scan.nextLine(); // Discard rest of input

                    break;
                case '3':
                    nodeList.displayFIFO();

                    break;

                case '4':
                    nodeList.displayLIFO();

                    break;

                case 'x':
                    System.out.println("Thank you for using this program!");

                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 'x');
    }
}
