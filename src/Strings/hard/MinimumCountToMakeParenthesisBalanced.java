package Strings.hard;

public class MinimumCountToMakeParenthesisBalanced {
    public static int minCount(String str) {
        int openCount = 0;
        int closedCount = 0;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                openCount++;
            }
            else if (c == ')') {
                if (openCount > 0) {
                    openCount--;
                }
                else {
                    closedCount++;
                }
            }
        }
        return openCount + closedCount;
    }

    public static void main(String[] args) {
        String input = "())";
        System.out.println("Minimum add to make \"" + input + "\" valid: " + minCount(input));

        input = "(((";
        System.out.println("Minimum add to make \"" + input + "\" valid: " + minCount(input));

        input = "()";
        System.out.println("Minimum add to make \"" + input + "\" valid: " + minCount(input));

        input = "()))((";
        System.out.println("Minimum add to make \"" + input + "\" valid: " + minCount(input));
    }
}
