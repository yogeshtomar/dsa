package Strings.medium;

public class MaxNestingDepthOfParenthesis {
    public static int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                depth++;
                maxDepth = depth > maxDepth ? depth : maxDepth;
            } else if (c == ')') {
                depth--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        String input = "(1+(2*3)+((8)/4))+1";
        System.out.println("Max Depth for String : " + input + " is: " + maxDepth(input));
        input = "(1)+((2))+(((3)))";
        System.out.println("Max Depth for String : " + input + " is: " + maxDepth(input));
    }
}
