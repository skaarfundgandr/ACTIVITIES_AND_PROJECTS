class Node {
    Node previous;
    String data;
    Node next;
}

public class NodeList {
    Node head;
    Node tail;
    int counter;

    public NodeList() {
        head = tail = null;
        counter = 0;
    }

    boolean add(Node item) {
        Node newNode = item;
        Node curr;

        if (head == null) {
            newNode.previous = null;
            head = tail = newNode;
        } else {
            curr = head;
            while (curr != null) {
                curr = curr.next;
            }
        }

        newNode.previous = tail;
        tail = newNode;
        counter++;

        return true;
    }

    boolean delete(int location) {
        Node curr;
        int curr_idx = 0;

        if (isEmpty()) {
            return false;
        } else {
            curr = head;
            while (curr != null && curr_idx < location) {
                curr = curr.next;
                curr_idx++;
            }
        }
        if (curr == null) {
            return false;
        }
        curr.previous.next = curr.next;
        curr = null;

        return true;
    }

    boolean isEmpty() {
        return head == null;
    }

    void display() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        
    }
}
