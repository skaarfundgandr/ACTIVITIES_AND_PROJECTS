import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        char choice;
        QueueArray qa;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter size: ");
        qa = new QueueArray(scan.nextInt());
        scan.nextLine();

        System.out.println("-- Queue Array Menu --");
        System.out.println("1] Enqueue an item");
        System.out.println("2] Dequeue");
        System.out.println("3] Show front");
        System.out.println("4] Display Queue");
        System.out.println("x] Exit Program");
        while (true) {
            System.out.print("Enter choice: ");
            choice = scan.nextLine().charAt(0);
            if (choice == '1') {
                System.out.println("Enter value to enqueue");
                if (qa.enque(scan.nextLine())) {
                    System.out.println("Successfully added to queue");
                } else {
                    System.out.println("Queue is full");
                }
            }
            else if (choice == '2') {
                if (qa.deque()) {
                    System.out.println("Front of queue successfully removed");
                } else {
                    System.out.println("Queue is already empty");
                }
            }
            else if (choice == '3') {
                if (qa.front() != null) {
                    System.out.println("Front element is:\n" + qa.front());
                } else {
                    System.out.println("Queue is empty");
                }
            }
            else if (choice == '4') {
                qa.display();
            }
            else if (choice == 'x') {
                System.out.println("Thank you for using this program");
                break;
            }
            else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
