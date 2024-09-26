public class Stack {
    private Node head;

    public void push(String str) {
        Node curr = new Node();

        curr.data = str;

        if (head == null) {
            curr.next = null;
            head = curr;
        } else {
            curr.next = head;
            head = curr;
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
}
