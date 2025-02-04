#include <stdio.h>
#include <string.h>

int main (int argc, char const **argv) {
    int len, end_idx, palindrome = 1;
    char *input;

    printf("Enter a string: ");
    scanf("%s", input);

    len = strlen(input);
    end_idx = len - 1;

    for (int i = 0; i < len / 2; ++i) {
        if (input[i] != input[end_idx - i]) {
            palindrome = 0;
            break;
        }
    }

    if (palindrome) {
        printf("Palindrome\n");
    } else {
        printf("Not palindrome\n");
    }
}