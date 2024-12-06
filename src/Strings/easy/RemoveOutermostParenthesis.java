package Strings.easy;

public class RemoveOutermostParenthesis {
    public static String removeOuterParenthesis(String string) {
        StringBuilder sb = new StringBuilder();
        int openCount = 0;

        for (char ch : string.toCharArray()) {
            if (ch == '(') {
                if (openCount > 0) {
                    sb.append(ch);
                }
                openCount++;
            }
            else {
                openCount--;
                if (openCount > 0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "(()())(())";
        String output = removeOuterParenthesis(input);
        System.out.println("Result after removing outermost parentheses: " + output);
    }
}
