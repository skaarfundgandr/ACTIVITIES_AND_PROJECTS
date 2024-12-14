import java.util.Scanner;

class StackNode {
    class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            next = null;
        }
    }
    Node head;

    private boolean isEmpty() {
        return head == null;
    }

    public boolean push(String data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        return true;
    }

    public boolean pop() {
        if (!isEmpty()) {
            head = head.next;
            return true;
        }

        return false;
    }

    public String peek() {
        if (!isEmpty()) {
            return head.data;
        }

        return "Stack is empty";
    }

    public void display() {
        if (!isEmpty()) {
            Node curr = head;
            while (curr != null) {
                System.out.println(curr.data);
                curr = curr.next;
            }
        } else {
            System.out.println("Stack is empty");
        }
    }
}

public class StackNodeMenu {
    public void menu() {
        char choice;

        StackNode stack = new StackNode();
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("-- Stack Node Menu --");
            System.out.println("1] Push an item");
            System.out.println("2] Pop");
            System.out.println("3] Peek");
            System.out.println("4] Display all");
            System.out.println("x] Exit Program");

            System.out.print("Enter your choice: ");
            choice = scan.nextLine().charAt(0);

            switch (choice) {
                case '1':
                    System.out.println("Enter value to push: ");
                    stack.push(scan.nextLine());

                    break;
                case '2':
                    if (stack.pop()) {
                        System.out.println("Item successfully popped");
                    } else {
                        System.out.println("Stack is already empty");
                    }

                    break;
                case '3':
                    System.out.print("Top element is: ");
                    System.out.println(stack.peek());

                    break;
                case '4':
                    stack.display();

                    break;
                case 'x':
                    System.out.println("Thank you for using this program");

                    break;
                default:
                    System.out.println("Invalid choice!");

                    break;
            }
        } while (choice != 'x');
    }
}
