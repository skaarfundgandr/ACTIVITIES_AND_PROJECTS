class Node {
    char data;
    Node next;
}
public class Stack {
    public Node head;
    
    public void push(char character) {
        Node curr = new Node();

        curr.data = character;

        if (head == null) {
            curr.next = null;
            head = curr;
        } else {
            curr.next = head;
            head = curr;
        }
        
    }

    public char peek() {
        return head.data;
    }

    public boolean pop() {
        if (head == null) {
            return false;
        } else {
            head = head.next;
        }
        return true;
    }

    public boolean isEmpty() {
        return head == null;
    }
}