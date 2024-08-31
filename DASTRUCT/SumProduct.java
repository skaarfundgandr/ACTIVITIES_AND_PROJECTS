import java.util.Scanner;

public class SumProduct {
    public static void main(String[] args) {
        int input, sum = 0, product = 1;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter 10 numbers");
        for (int index = 0; index < 10; index++) {
            input = scan.nextInt();

            if (input > 0) {
                sum += input;
                product *= input;
            }
        }

        System.out.printf("Total sum: %d\nTotal product: %d\n", sum, product);
    }
}