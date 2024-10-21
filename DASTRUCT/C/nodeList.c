#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

typedef struct node {
    struct node *previous;
    int data;
    struct node *next;
} node_t;

typedef struct nodeList {
    node_t *head;
    node_t *tail;
    int count;
} nodeList_t;

bool add(int item);
bool delete(int location);
bool isEmpty();
void displayFIFO();
void displayLIFO();

nodeList_t *nodeList = NULL;

int main(int argc, char const *argv[]){
    if (isEmpty()) {
        printf("List is empty\n");
    }

    add(1);
    add(2);
    add(3);
    add(4);

    if (!isEmpty()) {
        printf("List is populated\n");
        displayFIFO();
        displayLIFO();
    }

    delete(0);
    delete(1);

    displayFIFO();
    displayLIFO();

    printf("%d\n", nodeList->count);

    return 0;
}

bool add(int item) {
    node_t *newNode = (node_t *) malloc(sizeof(node_t));

    newNode->data = item;
    newNode->next = NULL;

    if (isEmpty()) {
        if (nodeList == NULL) {
            nodeList = (nodeList_t *) malloc(sizeof(nodeList_t));
            nodeList->count = 0;
        }

        newNode->previous = NULL;

        nodeList->head = newNode;
        nodeList->tail = newNode;
    } else {
        newNode->previous = nodeList->tail;
        nodeList->tail->next = newNode;
        nodeList->tail = nodeList->tail->next;
    }

    nodeList->count++;
    return true;
}

bool delete(int location){
    if (isEmpty()) {
        return false;
    } else {
        int curr_idx = 0;
        node_t *curr = nodeList->head;

        while (curr != NULL && curr_idx < location) {
            curr = curr->next;

            curr_idx++;
        }

        if (curr == NULL) {
            return false;
        } else if (curr == nodeList->head) {
            nodeList->head = curr->next;
            nodeList->head->previous = curr->previous;
        } else if (curr == nodeList->tail) {
            nodeList->tail = curr->previous;
            nodeList->tail->next = curr->next;
        } else {
            curr->previous->next = curr->next;
            curr->next->previous = curr->previous;
        }
        nodeList->count--;

        free(curr);
    }

    return true;
}

bool isEmpty() {
    if (nodeList == NULL) {
        return true;
    }
    return nodeList->head == NULL;
}

void displayFIFO() {
    if (isEmpty()) {
        printf("List is empty!\n");
    } else {
        node_t *curr = nodeList->head;

        while (curr != NULL) {
            printf("%d ", curr->data);
            curr = curr->next;
        }
        printf("\n");
    }
}

void displayLIFO() {
    if (isEmpty()) {
        printf("List is empty\n");
    } else {
        node_t *curr = nodeList->tail;

        while (curr != NULL) {
            printf("%d ", curr->data);

            curr = curr->previous;
        }
        printf("\n");
    }
}