public class InfixPostfix {
    private static Stack stack[][] = new Stack[2][4];

    public InfixPostfix(String input) {
        for (int i = 0; i < stack.length; i++) {
            for (int j = 0; j < stack[i].length; j++) {
                stack[i][j] = new Stack();
            }
        }
        sortByPrecedence(input);
    }

    public double evaluate() {
        double num = -1, total = 0;

        for (int i = 0; i < stack.length; i++) {
            while (!stack[i][0].isEmpty()) {
                for (int j = 1; j < 4; j++) {
                    if (!stack[i][j].isEmpty()) {
                        if (num == -1) {
                            num = eval(strToDouble(stack[i][0].pop()), strToDouble(stack[i][0].pop()), stack[i][j].pop().charAt(0));
                        } else {
                            num = eval(num, strToDouble(stack[i][0].pop()), stack[i][j].pop().charAt(0));
                        }
                    }
                }
                total += num;
            }
        }

        return total;
    }

    private static void sortByPrecedence(String input) {
        int end_idx = 0, start_idx = 0;
        boolean hasParenthesis = false;

        for (int i = 0; i < input.length(); i++) {
            start_idx = i;
            if (input.charAt(i) == '(') {
                hasParenthesis = true;
                i++;
                while (hasParenthesis) {
                    if (input.charAt(i) == ')') {
                        hasParenthesis = false;
                        break;
                    }
                    if (isNum(input.charAt(i))) {
                        end_idx = i + 1;
                    } else if (isOperator(input.charAt(i))) {
                        stack[0][0].push(input.substring(start_idx, end_idx));
                        stack[0][checkPrecedence(input.charAt(i))].push(input.substring(i, i + 1));
                        start_idx = end_idx = i;
                    } else {
                        start_idx++;
                    }
                    i++;
                }
            } else {
                while (i < input.length() && isNum(input.charAt(i))) {
                    end_idx = i + 1;
                    i++;
                }
                if (i < input.length() && isOperator(input.charAt(i))) {
                    stack[1][checkPrecedence(input.charAt(i))].push(input.substring(i, i + 1));
                }
                stack[1][0].push(input.substring(start_idx, end_idx));
            }
        }
    }
    
    private static int checkPrecedence(char operator) throws IllegalArgumentException {
        switch (operator) {
            case '^':
                return 1;
            case '*':
            case 'x':
            case '/':
                return 2;
            case '+':
            case '-':
                return 3;
        
            default:
                throw new IllegalArgumentException("Invalid operator on checkPrecedence");
        }
    }

    private static boolean isNum(char input) {
        int asciiValue = (int)(input);

        return (asciiValue >= '0' && asciiValue <= '9');
    }

    private static boolean isOperator(char input) {
        switch (input) {
            case '+':
            case '-':
            case '*':
            case 'x':
            case '^':
                return true;
            default:
                return false;
        }
    }

    private static double strToDouble(String str) throws IllegalArgumentException {
        int pos = 1, asciiValue;
        double num = 0;
        
        if (str == null) {
            throw new IllegalArgumentException("Error at strToDouble null argument found");
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            asciiValue = (int) (str.charAt(i));
            if (isNum(str.charAt(i))) {
                num += ((asciiValue - '0' ) * pos);
                pos *= 10;
            }
        }
        return num;
    }
    
    private static double eval(double num1, double num2, char operator) throws IllegalArgumentException {
        double result;

        switch (operator) {
            case '+':
                result = num1 + num2;
                
                break;
            case '-':
                result = num1 - num2;

                break;

            case '*':
            case 'x':
                result = num1 * num2;

                break;
            case '/':
                result = num1 / num2;
                
                break;
            case '^':
                result = Math.pow(num1, num2);

                break;
            default:
                throw new IllegalArgumentException("Invalid operator on eval");
        }
        return result;
    }
}
