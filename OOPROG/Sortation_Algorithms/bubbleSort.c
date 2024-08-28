#include <stdio.h>
#include <stdbool.h>

void swap(int *x, int *y);
void bubbleSort(int arr[], int iter);
void printArr(int arr[], int size);

int main(int argc, char const **argv){
    int size;
    int array[] = {1, 8, 2, 6, 4, 0, 9};

    size = sizeof(array) / sizeof(array[0]);

    printf("Unsorted array:\n");
    printArr(array, size);

    bubbleSort(array, size);

    printf("Sorted array:\n");
    printArr(array, size);

    return 0;
}

void swap(int *x, int *y){
    int temp = *y;

    *y = *x;
    *x = temp;
}

void bubbleSort(int arr[], int iter){
    bool swapped;

    for (int i = 0; i < iter; ++i) {
        swapped = false;

        for (int j = 0; j < iter - i - 1; ++j) {
            if (arr[j] > arr[j + 1]) {
                swap(&arr[j], &arr[j + 1]);
                swapped = true;
            }
        }

        if (swapped == false) break;
    }
}

void printArr(int arr[], int size){
    for (int i = 0; i < size; ++i) printf("%d ", arr[i]);
    printf("\n");
}