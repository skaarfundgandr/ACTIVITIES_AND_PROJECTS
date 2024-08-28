#include <stdio.h>

void printArray(int arr[], int size);
void selectionSort(int arr[], int size);
void swap(int *x, int *y);

int main(int argc, char const *argv[]){
    int size;
    int nums[] = {1, 8, 2, 6, 4, 0, 9};

    size = sizeof(nums) / sizeof(nums[0]);

    printf("Unsorted:\n");
    printArray(nums, size);

    selectionSort(nums, size);

    printf("Sorted:\n");
    printArray(nums, size);

    return 0;
}

void printArray(int arr[], int size){
    for (int i = 0; i < size; ++i) printf("%d ", arr[i]);
    printf("\n");
}

void selectionSort(int arr[], int size){
    int min_pos;

    for (int i = 0; i < size; ++i) {
        min_pos = i;

        for (int j = i + 1; j < size; ++j) {
            if (arr[j] < arr[min_pos]) {
                min_pos = j;
            }
        }

        swap(&arr[min_pos], &arr[i]);
    }
}

void swap(int *x, int *y){
    int temp = *y;

    *y = *x;
    *x = temp;
}