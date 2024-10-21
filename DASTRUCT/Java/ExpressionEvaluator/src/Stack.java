public class Stack {
    private Node head;

    public void push(String str) {
        Node curr = new Node();

        curr.data = str;

        if (this.head == null) {
            curr.next = null;
            this.head = curr;
        } else {
            curr.next = head;
            this.head = curr;
        }
    }

    public String pop() {
        String data;

        data = head.data;
        head = head.next;

        return data;
    }

    public String peek() {
        return head.data;
    }

    public void delete() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
