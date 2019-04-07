package te.interview.prep.stacks_queues;

import java.util.Stack;

public class ParenthesesValidator {

    public boolean isValid(String input) {
        if(input == null) return false;
        if(input.isEmpty()) return true;

        Stack<Character> openParentheses = new Stack<>();
        for(char c : input.toCharArray()) {
            if (isOpeningParentheses(c)) {
                openParentheses.push(c);
            } else if(openParentheses.isEmpty() || !isValid(openParentheses.pop(), c)) {
                return false;
            }
        }

        return openParentheses.isEmpty();
    }

    private boolean isOpeningParentheses(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isValid(char opening, char closing) {
        switch(opening) {
            case '(': return closing == ')';
            case '[': return closing == ']';
            case '{': return closing == '}';
            default: return false;
        }
    }
}
