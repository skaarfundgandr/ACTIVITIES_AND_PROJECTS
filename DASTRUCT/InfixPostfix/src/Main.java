import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InfixPostfix inf;

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter expression: ");
        inf = new InfixPostfix(scan.nextLine());
        System.out.println(inf.evaluate());
    }
}
