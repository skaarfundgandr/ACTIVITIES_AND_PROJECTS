import java.util.Scanner;

class QueueNode {
    class Node {
        String data;
        Node next;

        public Node(String str) {
            this.data = str;
        }
    }
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

public class QueueNodeMenu {
    public void menu() {
        char choice;

        QueueNode qn = new QueueNode();
        Scanner scan = new Scanner(System.in);

        System.out.println("-- Queue Node Menu --");
        System.out.println("1] Enqueue an item");
        System.out.println("2] Dequeue");
        System.out.println("3] Show front");
        System.out.println("4] Show last");
        System.out.println("5] Display Queue");
        System.out.println("x] Exit Program");
        while (true) {
            System.out.print("Enter choice: ");
            choice = scan.nextLine().charAt(0);
            if (choice == '1') {
                System.out.println("Enter value to enqueue:");
                qn.enqueue(scan.nextLine());
                System.out.println("Successfully added to queue");
            } else if (choice == '2') {
                if (qn.dequeue()) {
                    System.out.println("Front of queue successfully removed");
                } else {
                    System.out.println("Queue is already empty");
                }
            } else if (choice == '3') {
                if (qn.isEmpty()) {
                    System.out.println("Queue is empty");
                } else {
                    System.out.println("Front: " + qn.front());
                }
            } else if (choice == '4') {
                if (qn.isEmpty()) {
                    System.out.println("Queue is empty");
                } else {
                    System.out.println("Last: " + qn.last());
                }
            } else if (choice == '5') {
                System.out.println(qn);
            } else if (choice == 'x') {
                System.out.println("Thank you for using this program");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }
}
