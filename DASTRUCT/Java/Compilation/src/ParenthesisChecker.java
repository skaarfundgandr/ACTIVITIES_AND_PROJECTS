class Stack {
    class Node {
        char data;
        Node next;
    }
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

public class ParenthesisChecker {
    private Stack stack;

    public ParenthesisChecker() {
        stack = new Stack();
    }

    public boolean check(String str) {
        char currentCharacter;

        for (int i = 0; i < str.length(); i++) {
            currentCharacter = str.charAt(i);

            if (currentCharacter == '(' || currentCharacter == ')') {
                if (stack.isEmpty()) {
                    stack.push(currentCharacter);
                } else if ((stack.peek() == '(') && (currentCharacter == ')')) {
                    stack.pop();
                } else {
                    stack.push(currentCharacter);
                }
            }
        }

        return stack.isEmpty();
    }
}