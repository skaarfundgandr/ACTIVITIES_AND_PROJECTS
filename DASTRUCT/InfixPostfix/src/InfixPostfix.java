public class InfixPostfix {
    private Stack stack;

    public String convert() {
        return null;
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