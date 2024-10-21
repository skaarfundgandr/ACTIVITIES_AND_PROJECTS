#include <string.h>
#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 256

typedef struct node {
    char data[MAX_SIZE];
    struct node *next;
} node_t;

typedef struct stack {
    node_t *head;
    node_t *tail;
} stack_t;

node_t *node = NULL;
stack_t *stack = NULL;

void push(char* str);
void pop();
char* peek();

int main(int argc, char const *argv[]){
    push("Test");
    printf("%s\n", peek());
}

void push(char* str){
    node_t *new;

    if (!str) {
        return;
    }

    new = (node_t *) malloc(sizeof(node_t));

    strcpy(new->data, str);
    if (stack == NULL) {
        new->next = NULL;
        stack = (stack_t *) malloc(sizeof(stack_t));
        stack->head = stack->tail = new;
    } else {
        new->next = stack->head;
        stack->head = new;
    }
}

void pop() {
    node_t *temp;

    temp = stack->head;

    stack->head = stack->head->next;

    free(temp);
}

char* peek() {
    return stack->head->data;
}