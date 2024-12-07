public class InfixPostfix {
    private Stack stack;

    public InfixPostfix(String exp) {
        stack = new Stack();

        convert(exp);
    }

    public void display() {
        stack.displayAll();
    }

    public String getExpression() {
        return stack.toString();
    }

    private void convert(String in) throws IllegalArgumentException {
        char curr;
        Stack temp = new Stack();

        if (new ParenthesisChecker().check(in)) {
            for (int i = 0; i < in.length(); ++i) {
                curr = in.charAt(i);
    
                if (isNum(in.charAt(i))) {
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
        } else {
            throw new IllegalArgumentException("Invalid Expression");
        }
    }
    // Check if character is a number
    private static boolean isNum(char c) {
        int ascii = (int) c;

        return (ascii > 47 && ascii < 58);
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