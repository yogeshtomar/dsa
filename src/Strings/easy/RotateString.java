package Strings.easy;

public class RotateString {
    public static boolean isRotation(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        String concatinated = s + s;
        return concatinated.contains(goal);
    }

    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";

        System.out.println("Can \"" + s + "\" be rotated to \"" + goal + "\"? " + isRotation(s, goal));

        s = "abcde";
        goal = "abced";
        System.out.println("Can \"" + s + "\" be rotated to \"" + goal + "\"? " + isRotation(s, goal));
    }
}
