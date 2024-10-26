public class ParenthesisChecker {
    private Stack stack;

    public ParenthesisChecker() {
        stack = new Stack();
    }

    public boolean check(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(str.charAt(i));
            } else if ((stack.peek() == '(') && (str.charAt(i) == ')')) {
                stack.pop();
            } else {
                stack.push(str.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}