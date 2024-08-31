import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        int input, numEven = 0, numOdd = 0, even[], odd[];
        odd = new int[10];
        even = new int[10];

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter 10 numbers:");
        for (int index = 0; index < 10; index++) {
            input = scan.nextInt();
            
            if (input % 2 == 0) {
                even[numEven] = input;
                ++numEven;
            }
            if (input % 2 == 1) {
                odd[numOdd] = input;
                ++numOdd;
            }
        }

        System.out.println("Even\t\tOdd");
        for (int index = 0; index < (numEven > numOdd ? numEven : numOdd); index++) {
            if (index < numEven) {
                System.out.print(even[index]);
            }
            if (index < numOdd) {
                System.out.print("\t\t" + odd[index]);
            }

            System.out.println();
        }
    }
}