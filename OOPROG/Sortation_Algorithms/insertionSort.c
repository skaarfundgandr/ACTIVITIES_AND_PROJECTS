#include <stdio.h>

void printArray(int arr[], int size);
void insertionSort(int arr[], int size);

int main(int argc, char const *argv[]){
    int size;
    int nums[] = {1, 8, 2, 6, 4, 0, 9};

    size = sizeof(nums) / sizeof(nums[0]);

    printf("Unsorted:\n");
    printArray(nums, size);

    insertionSort(nums, size);

    printf("Sorted:\n");
    printArray(nums, size);

    return 0;
}

void printArray(int arr[], int size){
    for (int i = 0; i < size; ++i) printf("%d ", arr[i]);
    printf("\n");
}

void insertionSort(int arr[], int size){
    int val, j;

    for (int i = 1; i < size; ++i) {
        val = arr[i];
        j = i - 1;

        while (j >= 0 && arr[j] > val) {
            arr[j + 1] = arr[j];
            --j;
        }
        arr[j + 1] = val;
    }
}