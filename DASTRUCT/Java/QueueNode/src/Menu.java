import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        char choice;

        QueueNode qn = new QueueNode();
        Scanner scan = new Scanner(System.in);

        System.out.println("-- Queue Node Menu --");
        System.out.println("1] Enqueue an item");
        System.out.println("2] Dequeue");
        System.out.println("3] Show front");
        System.out.println("4] Show last");
        System.out.println("5] Display Queue");
        System.out.println("x] Exit Program");
        while (true) {
            System.out.print("Enter choice: ");
            choice = scan.nextLine().charAt(0);
            if (choice == '1') {
                System.out.println("Enter value to enqueue:");
                qn.enqueue(scan.nextLine());
                System.out.println("Successfully added to queue");
            } else if (choice == '2') {
                if (qn.dequeue()) {
                    System.out.println("Front of queue successfully removed");
                } else {
                    System.out.println("Queue is already empty");
                }
            } else if (choice == '3') {
                if (qn.isEmpty()) {
                    System.out.println("Queue is empty");
                } else {
                    System.out.println("Front: " + qn.front());
                }
            } else if (choice == '4') {
                if (qn.isEmpty()) {
                    System.out.println("Queue is empty");
                } else {
                    System.out.println("Last: " + qn.last());
                }
            } else if (choice == '5') {
                System.out.println(qn);
            } else if (choice == 'x') {
                System.out.println("Thank you for using this program");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
