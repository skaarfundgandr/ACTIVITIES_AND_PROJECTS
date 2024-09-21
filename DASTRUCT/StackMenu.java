import java.util.Scanner;

public class StackMenu {
    private String[] str;
    private int count;
    
    public StackMenu(int size) {
        if (size <= 0) {
            System.out.println("Invalid size! Size must not be less than 1! Size is now reverted to default");
            str = new String[10];
        } else {
            str = new String[size];
        }
        count = 0;
    }
    public StackMenu() {
        this(10);
    }
    private boolean isEmpty() {
        return count == 0;
    }
    private boolean isFull() {
        return count == str.length;
    }
    public boolean push(String val) {
        if (!isFull()) {
            str[count++] = val;
            return true;
        }
        return false;
    }
    public boolean pop() {
        if (!isEmpty()) {
            str[count-1] = null;
            count--;
            return true;
        }
        return false;
    }
    public String peek() {
        if (!isEmpty()) {
            return str[count-1];
        }
        return null;
    }
    public void display() {
        if (!isEmpty()) {
            for (int i = count - 1; i >= 0; i--) {
                System.out.println("[" + str[i] + "]");
            }
        } else {
            System.out.println("Stack is empty");
        }
    }
    public static void main(String[] args) {
        char choice;
        StackMenu stack;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter size: ");
        stack = new StackMenu(scan.nextInt());
        scan.nextLine();
        
        System.out.println("-- Stack Array Menu --");
        System.out.println("1] Push an item");
        System.out.println("2] Pop");
        System.out.println("3] Peek");
        System.out.println("4] Display Stack");
        System.out.println("x] Exit Program");
        while (true) {
            System.out.print("Enter choice: ");
            choice = scan.nextLine().charAt(0);
            if (choice == '1') {
                System.out.println("Enter value to push");
                if (stack.push(scan.nextLine())) {
                    System.out.println("Successfully added to stack");
                } else {
                    System.out.println("Stack is full");
                }
            }
            else if (choice == '2') {
                if (stack.pop()) {
                    System.out.println("Top of stack successfully removed");
                } else {
                    System.out.println("Stack is already empty");
                }
            }
            else if (choice == '3') {
                if (stack.peek() != null) {
                    System.out.println("Top element is:\n" + stack.peek());
                } else {
                    System.out.println("Stack is empty");
                }
            }
            else if (choice == '4') {
                stack.display();
            }
            else if (choice == 'x') {
                System.out.println("Thank you for using this program");
                break;
            }
            else {
                System.out.println("Invalid choice!");
            }
        }
    }
}