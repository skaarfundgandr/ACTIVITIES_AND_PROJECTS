class Node {
    Node previous;
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        next = previous = null;
    }
}

public class NodeList {
    Node head;
    Node tail;
    int counter;

    public NodeList() {
        head = null;
        tail = null;
        counter = 0;
    }

    public boolean add(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            newNode.previous = null;
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }

        counter++;

        return true;
    }

    public boolean delete(int location) {
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
        if (curr == head) {
            head = head.next;
            head.previous = curr.previous;
        } else if (curr == tail) {
            tail = tail.previous;
            tail.next = curr.next;
        } else {
            curr.previous.next = curr.next;
            curr.next.previous = curr.previous;
        }
        curr = null;

        --counter;
        return true;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void displayFIFO() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public void displayLIFO() {
        Node curr = tail;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.previous;
        }
    }
}