public class InfixPostfix {
    private Stack stack;

    public InfixPostfix(String s) {
        stack = new Stack();

        convert(s);
    }

    public void display() {
        stack.displayAll();
    }

    private void convert(String in) {
        Stack temp = new Stack();

        for (int i = 0; i < in.length(); ++i) {
            if (isAlphaNumeric(in.charAt(i))) {
                stack.push(in.charAt(i));
            } else if (in.charAt(i) == '(') {
                stack.push(in.charAt(i));
            } else if (in.charAt(i) == ')') {
                
            }
            // while (checkPrecedence(stack.peek()) > checkPrecedence(in.charAt(i))) {
            //     if (stack.peek() == '\0') break;
            //     temp.push(stack.pop());
            // }
            // stack.push(in.charAt(i));
            // while (!temp.isEmpty()) {
            //     stack.push(temp.pop());
            // }
        }

        temp = null;
    }
    private static boolean isAlphaNumeric(char c) {
        int ascii = (int) c;

        if (ascii < 48) {
            return false;
        } else if (ascii > 57 && ascii < 65) {
            return false;
        } else if (ascii < 97 || ascii > 122) {
            return false;
        } else {
            return true;
        }
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