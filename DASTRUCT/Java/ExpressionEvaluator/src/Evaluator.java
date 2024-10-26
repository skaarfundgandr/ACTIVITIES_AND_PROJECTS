public class Evaluator {
    private String infix;
    private DoubleStack ds;

    public Evaluator(String exp) throws IllegalArgumentException {
        ds = new DoubleStack();
        if (exp.contains("(") || exp.contains(")")) {
            if ((new ParenthesisChecker()).check(exp)) {
                infix = (new InfixPostfix(exp)).getExpression();
            }
            throw new IllegalArgumentException("Expression is not a valid expression");
        } else {
            infix = (new InfixPostfix(exp)).getExpression();
        }
    }

    public double getResult() {
        double result = 0;
        for (int i = 0; i < infix.length(); i++) {
            if (isNum(infix.charAt(i))) {
                ds.push(charToDouble(infix.charAt(i)));
            } else {
                result = eval(ds.pop(), ds.pop(), infix.charAt(i));
                ds.push(result);
            }
        }
        return result;
    }

    private static double eval(double num1, double num2, char operator) throws IllegalArgumentException {
        double result;

        switch (operator) {
            case '+':
                result = num2 + num1;
                
                break;
            case '-':
                result = num2 - num1;

                break;
            case '*':
            case 'x':
                result = num2 * num1;

                break;
            case '/':
                result = num2 / num1;
                
                break;
            case '^':
                result = Math.pow(num2, num1);

                break;
            default:
                throw new IllegalArgumentException("Invalid operator on eval");
        }
        return result;
    }
    
    private static boolean isNum(char ch) {
        int ascii = (int) ch;

        if (ascii > 47 && ascii < 58)
            return true;
        return false;
    }

    private static double charToDouble(char ch) throws IllegalArgumentException{
        int ascii = (int) ch;

        if (ascii > 47 && ascii < 58) {
            return ascii - 48;
        }
        throw new IllegalArgumentException("Cannot convert to double input must be an int!");
    }
}
