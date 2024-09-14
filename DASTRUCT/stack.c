#include <stdlib.h>
#include <stdio.h>

typedef struct stack {
    int data;
    struct stack *next;
} stack_t;

stack_t* push(stack_t **stack, int data);
int pop(stack_t **stack);
int peek(stack_t **stack);

int main(int argc, char const *argv[]) {
    stack_t *stck = NULL;
    int data, input;

    stck = push(&stck, 5);
    stck = push(&stck, 7);
    stck = push(&stck, 9);

    printf("%d\n", pop(&stck));
    printf("%d\n", pop(&stck));

    printf("%d\n", peek(&stck));
    printf("%d\n", pop(&stck));
}

stack_t* push(stack_t **stack, int data) {
    stack_t *new;

    new = (stack_t *) malloc(sizeof(stack_t));

    new->data = data;
    if (stack == NULL) {
        new->next = NULL;
    } else {
        new->next = *stack;
    }
    return new;
}

int pop(stack_t **stack) {
    stack_t *temp = *stack;
    int data = temp->data;

    *stack = (*stack)->next;

    free(temp);

    return data;
}

int peek(stack_t **stack) {
    stack_t *current = *stack;
    if (stack == NULL) {
        fprintf(stderr, "Stack must not be null\n");
        exit(1);
    } else {
        return current->data;
    }
}