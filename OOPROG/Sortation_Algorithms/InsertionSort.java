public class InsertionSort {
    public static void main(String[] args) {
        int nums[] = {1, 8, 2, 6, 4, 0, 9};

        System.out.println("Unsorted");
        printArray(nums);

        insertionSort(nums);

        System.out.println("Sorted:");
        printArray(nums);
    }
    static void printArray(int[] num){
        for (int i : num) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    static void insertionSort(int[] nums){
        int val, j, size;

        size = nums.length;

        for (int i = 1; i < size; i++){
            val = nums[i];

            for (j = i - 1; j >= 0 && nums[j] > val; j--)
                nums[j + 1] = nums[j];

            nums[j + 1] = val;
        }
    }
}