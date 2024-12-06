package Strings.hard;

public class RepeatedStringMatch {
    public static int repeatedStringMatch(String a, String b) {
        int repeatCount = 1;
        StringBuilder sb = new StringBuilder(a);

        while (sb.length() < b.length()) {
            sb.append(a);
            repeatCount++;
        }

        if (sb.indexOf(b) != -1) {
            return repeatCount;
        }

        sb.append(a);
        repeatCount++;

        if (sb.indexOf(b) != -1) {
            return repeatCount;
        }

        return -1;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";
        System.out.println("Minimum repeats for \"" + a + "\" to contain \"" + b + "\": " + repeatedStringMatch(a, b)); // Expected output: 3

        a = "a";
        b = "aa";
        System.out.println("Minimum repeats for \"" + a + "\" to contain \"" + b + "\": " + repeatedStringMatch(a, b)); // Expected output: 2

        a = "abc";
        b = "wxyz";
        System.out.println("Minimum repeats for \"" + a + "\" to contain \"" + b + "\": " + repeatedStringMatch(a, b)); // Expected output: -1
    }
}
