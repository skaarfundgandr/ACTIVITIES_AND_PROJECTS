import java.util.Scanner;

public class SumProduct {
    public void menu() {
        long input, sum = 0, product = 1;

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter 10 numbers");
        for (int index = 0; index < 10; index++) {
            input = scan.nextLong();

            if (input > 0) {
                sum += input;
                product *= input;
            }
        }

        System.out.printf("Total sum: %d\nTotal product: %d\n", sum, product);
    }
}