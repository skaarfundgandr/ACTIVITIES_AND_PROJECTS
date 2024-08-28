public class BubbleSort{
    public static void main(String[] args) {
        int[] arr = {7,3,4,1,0};

        System.out.println("Unsorted Array: ");
        printArray(arr);

        sort(arr);

        System.out.println("Sorted array: ");
        printArray(arr);
    }
    static void sort(int[] num){
        int temp, size;
        boolean swapped;

        size = num.length;

        for (int i = 0; i < size; i++) {
            swapped = false;

            for (int index = 0; index < size - i - 1; index++) {
                if (num[index] > num[index + 1]) {
                    temp = num[index + 1];
                    num[index + 1] = num[index];
                    num[index] = temp;
                    swapped = true;
                }
            }

            if (swapped == false) break;
        }
    }
    static void printArray(int[] num){
        for (int i : num) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}