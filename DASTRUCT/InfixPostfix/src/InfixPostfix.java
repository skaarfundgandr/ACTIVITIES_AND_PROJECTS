public class InfixPostfix {
    private Stack stack;

    public InfixPostfix(String exp) {
        stack = new Stack();

        convert(exp);
    }

    public void display() {
        stack.displayAll();
    }

    private void convert(String in) {
        char curr;
        Stack temp = new Stack();

        for (int i = 0; i < in.length(); ++i) {
            curr = in.charAt(i);

            if (isAlphaNumeric(in.charAt(i))) {
                stack.push(in.charAt(i));
            } else if (in.charAt(i) == '(') {
                temp.push(in.charAt(i));
            } else if (in.charAt(i) == ')') { // Push elements into final stack until ')' is encountered
                while (!temp.isEmpty() && temp.peek() != '(') {
                    stack.push(temp.pop());
                }
                temp.pop();
            } else { // If operator is found push elements into final stack until top is of lower or equal precedence
                while (!temp.isEmpty() && (checkPrecedence(curr) <= checkPrecedence(temp.peek()))) {
                    stack.push(temp.pop());
                }
                temp.push(curr);
            }
        }
        while (!temp.isEmpty()) { // Push rest into final stack
            stack.push(temp.pop());
        }

        temp = null; // Deallocate temp stack
    }
    // Check if character is alphanumeric(0-9, A-Z, a-z) using ASCII values
    private static boolean isAlphaNumeric(char c) {
        int ascii = (int) c;

        if (ascii < 48) {
            return false;
        } else if (ascii > 57 && ascii < 65) {
            return false;
        } else if (ascii < 97 && ascii > 122) {
            return false;
        } else {
            return true;
        }
    }
    /*
     *  Precedence checker for operators
     *  Lower precedence values are prioritized
     */
    private static int checkPrecedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0; // Base condition(if character is not an operator)
        }
    }
}