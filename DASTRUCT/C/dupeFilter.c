#include <stdbool.h>
#include <stdio.h>

int main(int argc, char const *argv[]){
    int nums[10];
    bool duplicate;

    printf("Enter 10 numbers:\n");
    for (int i = 0; i < 10; ++i) {
        duplicate = false;

        scanf("%d", nums + i);
        
        for (int j = 0; j < i; ++j) {
            if (nums[j] == nums[i]) {
                duplicate = true;
                break;
            }
        }
        if (!duplicate) {
            printf("%d ", nums[i]);
        }
    }
    printf("\n");

    return 0;
}