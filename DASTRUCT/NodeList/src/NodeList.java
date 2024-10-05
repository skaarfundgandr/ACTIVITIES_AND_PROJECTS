public class NodeList {
    Node head;
    Node tail;
    int counter;

    public NodeList() {
        head = null;
        tail = null;
        counter = 0;
    }

    public boolean add(Node item) {
        Node newNode = item;

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
        curr.previous.next = curr.next;
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
