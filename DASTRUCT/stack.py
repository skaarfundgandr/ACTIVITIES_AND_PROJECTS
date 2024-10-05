class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Stack:
    def __init__(self):
        self.head = None
        self.tail = None

    def push(self, data):
        if self.head is None:
            self.head = Node(data)
            self.tail = self.head
        else:
            newNode = Node(data)
            self.tail.next = newNode
            self.tail = newNode

    def pop(self):
        if self.head is not None:
            self.head = self.head.next

    def peek(self):
        if self.head is not None:
            return self.head.data