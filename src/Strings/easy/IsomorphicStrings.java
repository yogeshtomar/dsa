package Strings.easy;

public class IsomorphicStrings {
    public static boolean isIsomorchic(String s, String t) {
        int[] m = new int[256];
        int[] n = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (m[s.charAt(i)] != n[t.charAt(i)]) {
                return false;
            }
            m[s.charAt(i)] = n[t.charAt(i)] = i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";

        System.out.println(s + " and " + t +  " are isomorphic: " + isIsomorchic(s, t));
    }
}
