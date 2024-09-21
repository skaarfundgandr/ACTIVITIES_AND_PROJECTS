import java.util.Scanner;

public class StackArray {
    private String[] str;
    private int count;
    
    public StackArray(int size) {
        str = new String[size];
        count = 0;
    }
    public StackArray() {
        this(10);
    }
    private boolean isEmpty() {
        return count == 0;
    }
    private boolean isFull() {
        return count == str.length - 1;
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
        StackArray stack = new StackArray(5);
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter elements to fill the stack");
        while (stack.push(scan.nextLine())) {} // Fill the stack

        System.out.print("Top element is: ");
        System.out.println(stack.peek());

        stack.display();
        while (stack.pop()) {} // Recursively empty the stack

        stack.display();
    }
}