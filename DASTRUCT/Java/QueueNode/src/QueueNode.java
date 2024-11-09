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

    public String front() {
        if (!isEmpty()) {
            return "[" + head.data + "]";
        } else {
            return "Queue is empty";
        }
    }

    public String last() {
        if (!isEmpty()) {
            return "[" + tail.data + "]";
        }
        return "Queue is empty";
    }
    @Override
    public String toString() {
        String str = "";

        if (isEmpty()) {
            str += "Queue is empty";
        } else {
            Node currNode = head;

            str += "First: " + front() + "\n";
            str += "Last: " + last() + "\n\n";
            while (currNode != null) {
                str += "[" + currNode.data + "] -> ";
                currNode = currNode.next;
            }
            str += "NULL";
        }
        return str;
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
