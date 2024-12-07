import java.util.Scanner;

public class DupeFilter {
    public void menu() {
        boolean duplicate;

        int nums[] = new int[10];

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            nums[i] = scan.nextInt();

            duplicate = false;

            for (int j = 0; j < i; j++) {
                if (nums[j] == nums[i]) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate)
                System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}