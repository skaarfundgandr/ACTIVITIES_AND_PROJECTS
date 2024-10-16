import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpressionEvaluator exp;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter expression: ");
        try {
            exp = new ExpressionEvaluator(scan.nextLine());
            System.out.println(exp.evaluate());
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
