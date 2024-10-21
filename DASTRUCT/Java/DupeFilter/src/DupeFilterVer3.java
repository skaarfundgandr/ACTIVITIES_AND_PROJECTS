import java.util.Scanner;

public class DupeFilterVer3 {
    public static void main(String[] args) {
        boolean duplicate;

        int filteredSize = 0;
        int nums[] = new int[10];
        int filtered[] = new int[10];

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
            if (!duplicate) {
                filtered[filteredSize] = nums[i];
                ++filteredSize;
            }
        }
        for (int i = 0; i < filteredSize; i++)
            System.out.print(filtered[i] + " ");
        System.out.println();
    }
}