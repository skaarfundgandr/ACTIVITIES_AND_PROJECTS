class Node {
    String data;
    Node next;

    public Node(String str) {
        this.data = str;
    }
}

public class QueueNode {
    Node head;
    Node tail;

    public void enqueue(String data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public boolean dequeue() {
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }

            return true;
        }
        return false;
    }

    public void front() {
        if (!isEmpty()) {
            System.out.println("[" + head.data + "]");
        } else {
            System.out.println("Queue is empty");
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node currNode = head;

            while (currNode != null) {
                System.out.print(" [" + currNode.data + "] ->");

                currNode = currNode.next;
            }
            System.out.println();
        }
    }
    public boolean isEmpty() {
        return head == null && tail == null;
    }
}
