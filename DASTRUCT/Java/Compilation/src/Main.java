import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char choice;

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("-- Data struct activities Menu --");
            System.out.println("1] Sum Product");
            System.out.println("2] Duplicate Filter");
            System.out.println("3] Even or Odd");
            System.out.println("4] Stack Array");
            System.out.println("5] Stack Node");
            System.out.println("6] Node List");
            System.out.println("7] Infix to Postfix with Evaluator");
            System.out.println("8] Queue Array");
            System.out.println("9] Queue Node");
            System.out.println("x] Exit");

            System.out.print("Enter your choice: ");
            choice = scan.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    new SumProduct().menu();

                    break;
                case '2':
                    new DupeFilter().menu();

                    break;
                case '3':
                    new EvenOdd().menu();

                    break;
                case '4':
                    new StackArrayMenu().menu();

                    break;
                case '5':
                    new StackNodeMenu().menu();

                    break;
                case '6':
                    new NodeListMenu().menu();

                    break;
                case '7':
                    new ExpressionEvaluatorMenu().menu();

                    break;
                case '8':
                    new QueueArrayMenu().menu();

                    break;
                case '9':
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
