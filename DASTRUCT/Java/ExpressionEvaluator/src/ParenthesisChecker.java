public class ParenthesisChecker {
    private Stack stack;

    public ParenthesisChecker() {
        stack = new Stack();
    }

    public boolean check(String str) {
        char currentCharacter;

        for (int i = 0; i < str.length(); i++) {
            currentCharacter = str.charAt(i);

            if (currentCharacter == '(' || currentCharacter == ')') {
                if (stack.isEmpty()) {
                    stack.push(currentCharacter);
                } else if ((stack.peek() == '(') && (currentCharacter == ')')) {
                    stack.pop();
                } else {
                    stack.push(currentCharacter);
                }
            }
        }

        return stack.isEmpty();
    }
}