#include <pthread.h>
#include <unistd.h>
#include <stdio.h>

typedef char ALIGN[16];

typedef union mallocList {
    struct {
        size_t size;
        unsigned is_free;
        union mallocList *next;
    } memBlock;
    ALIGN alBytes;
} mallocList_t;

mallocList_t *head, *tail;
pthread_mutex_t lock_thread;

void *myMalloc(size_t size);
void memFree(void *memBlock);
mallocList_t *getFreeBlock(size_t size);

int main(int argc, char *argv[]){
    int *testArr, *testArr2;
    // Test arrays
    testArr = (int *)(myMalloc(sizeof(int) * 3));
    testArr2 = (int *)(myMalloc(sizeof(int) * 3));

    *testArr = 1;
    *(testArr+1) = 8;
    *testArr2 = 9;
    *(testArr2+1) = 5;

    printf("%d\n", *testArr);
    printf("%d\n", *(testArr + 1));

    printf("%d\n", *testArr2);
    printf("%d\n", *(testArr2+1));
    return 0;
}

void *myMalloc(size_t size) {
    size_t memSize;
    void *memBlock;
    mallocList_t *header;

    if (!size) { // Check if size is not NULL
        return NULL;
    }

    pthread_mutex_lock(&lock_thread); // Lock thread

    header = getFreeBlock(size); 
    // Mark memory block as in use if free block is found
    if (header) {
        header->memBlock.is_free = 0;
        pthread_mutex_unlock(&lock_thread);
        return (void*)(header + 1);
    }

    memSize = sizeof(mallocList_t) + size; // Calculate size to be allocated
    memBlock = sbrk(memSize); // Expand heap memory to accomodate

    if (memBlock == (void*) - 1) { // sbrk returns (void *) - 1 if memory allocation has failed
        pthread_mutex_unlock(&lock_thread); // Unlock thread
        return NULL;
    }
    // Adds current memory block to list
    header = memBlock;
    header->memBlock.size = size;
    header->memBlock.is_free = 0;
    header->memBlock.next = NULL;

    if (!head) {
        head = header;
    }
    if (tail) {
        tail->memBlock.next = header;
    }
    tail = header;
    pthread_mutex_unlock(&lock_thread);
    return (void*)(header + 1); // Return address of memory block
}
void memFree(void *memBlock) {
    mallocList_t *header, *temp;
    void *programbreak;

    if (!memBlock) { // Make sure memBlock is not NULL
        return;
    }

    pthread_mutex_lock(&lock_thread); // Lock current thread
    header = (mallocList_t *) memBlock - 1;

    programbreak = sbrk(0); // Get current heap address / size
    // Check if memory to be freed is on the end of the heap
    if ((char *) memBlock + header->memBlock.size == programbreak) {
        if (head == tail) {
            head = tail = NULL;
        } else {
            temp = head;

            while (temp) { // Find memory block to be freed in list
                if (temp->memBlock.next == tail) {
                    temp->memBlock.next = NULL;
                    tail = temp;
                }
                temp = temp->memBlock.next;
            }
        }
        sbrk(0 - sizeof(mallocList_t) - header->memBlock.size); // Shrink heap by the size of block to be freed
        
        pthread_mutex_unlock(&lock_thread);
        return;
    }
    header->memBlock.is_free = 1; // Mark block as freed
    pthread_mutex_unlock(&lock_thread); // Unlock thread
}

mallocList_t *getFreeBlock(size_t size) {
    mallocList_t *current = head;

    while (current) {
        if (current->memBlock.is_free && current->memBlock.size >= size) {
            return current;
        }
        current = current->memBlock.next;
    }
    return NULL;
}