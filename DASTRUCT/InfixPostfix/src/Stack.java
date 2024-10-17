class Node {
    char data;
    Node next;

    public Node(char data) {
        this.data = data;
    }
}

public class Stack {
    private Node head;

    public boolean push(char c) {
        Node newNode = new Node(c);

        if (head == null) {
            head = newNode;
            head.next = null;
        } else {
            head.next = newNode;
            head = head.next;
        }
        return true;
    }

    public char pop() {
        char data;
        if (isEmpty()) {
            return '\0';
        }
        data = peek();
        head = head.next;

        return data;
    }

    public char peek() {
        if (isEmpty()) {
            return '\0';
        }
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void displayAll() {
        Node curr = head;

        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
