class Node {
    Node previous;
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
    }
}

public class Stack {
    private Node tail;
    private Node head;

    public boolean push(char c) {
        Node newNode = new Node(c);
        newNode.previous = null;
        newNode.next = null;

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = tail.next;
        }
        return true;
    }

    public char pop() {
        char data;
        if (isEmpty()) {
            return '\0';
        }
        data = peek();
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.previous;
        }
        if (tail != null) { // Null check to prevent NullPointerExceptions
            tail.next = null;
        }
        return data;
    }

    public char peek() {
        if (isEmpty()) {
            return '\0'; // Returns null byte character to prevent reading from null
        }
        return tail.data;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void displayAll() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.data);
            curr = curr.next;
        }
        System.out.println();
    }
}
