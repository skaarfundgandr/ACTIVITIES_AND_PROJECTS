class NodeDouble {
    NodeDouble previous;
    double data;
    NodeDouble next;

    public NodeDouble(double data) {
        this.data = data;
    }
}

public class DoubleStack {
    private NodeDouble head;
    private NodeDouble tail;

    public boolean push(double data) {
        NodeDouble newNode = new NodeDouble(data);
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

    public double pop() {
        double data;
        if (isEmpty()) {
            return -1;
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

    public double peek() {
        return tail.data;
    }

    public boolean isEmpty() {
        return tail == null;
    }
}
