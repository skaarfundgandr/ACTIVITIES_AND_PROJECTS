public class InfixPostfix {
    private Stack stack;

    public InfixPostfix(String s) {
        Stack temp = new Stack();
        stack = new Stack();

        for (int i = 0; i < s.length(); ++i) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (checkPrecedence(stack.peek()) > checkPrecedence(s.charAt(i))) {

            } else if (checkPrecedence(stack.peek()) < checkPrecedence(s.charAt(i))) {

            } else {

            }
        }
    }

    public void convert() {

    }

    public void display() {
        stack.displayAll();
    }

    private static int checkPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 3;
            case '*':
            case '/':
                return 2;
            case '^':
                return 1;
            default:
                return 0;
        }
    }
}