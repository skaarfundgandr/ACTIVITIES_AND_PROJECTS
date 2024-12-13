import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char choice;

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("-- Data struct activities Menu --");
            System.out.println("1] Duplicate Filter");
            System.out.println("2] Even or Odd");
            System.out.println("3] Stack Array");
            System.out.println("4] Node List");
            System.out.println("5] Infix to Postfix with Evaluator");
            System.out.println("6] Queue Array");
            System.out.println("7] Queue Node");
            System.out.println("x] Exit");

            System.out.print("Enter your choice: ");
            choice = scan.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    new DupeFilter().menu();

                    break;
                case '2':
                    new EvenOdd().menu();

                    break;
                case '3':
                    new StackArrayMenu().menu();

                    break;
                case '4':
                    new NodeListMenu().menu();

                    break;
                case '5':
                    new ExpressionEvaluatorMenu().menu();

                    break;
                case '6':
                    new QueueArrayMenu().menu();

                    break;
                case '7':
                    new QueueNodeMenu().menu();

                    break;
                case 'x':
                    System.out.println("Thank you for using this program");

                    break;
                default:
                    System.out.println("Invalid choice!");

                    break;
            }
        } while (choice != 'x');
    }
}
