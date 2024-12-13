import java.util.Scanner;

public class ExpressionEvaluatorMenu {

    public void menu(){
        char choice;

        Scanner scan = new Scanner(System.in);

        System.out.println("Simple infix to postfix program");
        System.out.println("1. Convert to postfix");
        System.out.println("2. Evaluate");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        choice = scan.nextLine().charAt(0);

        while (choice != '3') {
            if (choice == '1') {
                System.out.println("Enter infix expression");
                try {
                    InfixPostfix inf = new InfixPostfix(scan.nextLine());
                    System.out.println("Postfix: " + inf.getExpression());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == '2') {
                System.out.println("Enter Expression: ");
                try {
                    Evaluator ev = new Evaluator(scan.nextLine());

                    System.out.println(ev.getResult());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == '3') {
                break;
            } else {
                System.out.print("Invalid Choice! Please try again: ");
            }
            System.out.print("Enter your choice: ");
            choice = scan.nextLine().charAt(0);
        }
        System.out.println("Thank you for using this program");
    }
}