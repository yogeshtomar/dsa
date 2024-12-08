package dynamicProgramming.mcmAndPartitioning;

import java.util.Stack;

public class EvaluateBooleanExpression {
    public static boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();

        for (char currChar : expression.toCharArray()) {
            if (currChar == ',' || currChar == '(') {
                continue;
            }
            if (currChar == 't' || currChar == 'f' || currChar == '!' ||
                    currChar == '&' || currChar == '|') {
                stack.push(currChar);
            }
            else if (currChar == ')') {
                boolean hasTrue = false;
                boolean hasFalse = false;

                while (stack.peek() != '!' && stack.peek() != '&' && stack.peek() != '|') {
                    char top = stack.pop();
                    if (top == 't') hasTrue = true;
                    if (top == 'f') hasFalse = true;
                }

                char operator = stack.pop();
                if (operator == '!') {
                    stack.push(hasTrue ? 'f' : 't');
                } else if (operator == '&' ) {
                    stack.push(hasFalse ? 'f' : 't');
                } else {
                    stack.push(hasTrue ? 't' : 'f');
                }
            }
        }
        return stack.peek() == 't';
    }

    public static void main(String[] args) {
        String expression1 = "|(&(t,f,t),!(t))";
        String expression2 = "&(t,t,t)";
        String expression3 = "!(&(t,t,f))";

        System.out.println("Result for '" + expression1 + "': " + parseBoolExpr(expression1)); // Expected: false
        System.out.println("Result for '" + expression2 + "': " + parseBoolExpr(expression2)); // Expected: true
        System.out.println("Result for '" + expression3 + "': " + parseBoolExpr(expression3)); // Expected: true
    }
}
