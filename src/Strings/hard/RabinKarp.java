package Strings.hard;

public class RabinKarp {
    private static final int prime = 101;

    public static int search(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        if (m > n) {
            return -1;
        }

        long patternHash = createHash(pattern, m);
        long textHash = createHash(text, m);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && checkEqual(text, pattern, i)) {
                return i;
            }

            if (i < n - m) {
                textHash = recalculateHash(text, textHash, i, i + m, m);
            }
        }
        return -1;
    }

    private static long createHash(String string, int length) {
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash += (long) (string.charAt(i) * Math.pow(prime, i));
        }
        return hash;
    }

    private static long recalculateHash(String string, long oldHash, int oldIndex, int newIndex, int patternLength) {
        long newHash = oldHash - string.charAt(oldIndex);
        newHash = newHash / prime;
        newHash += (long) (string.charAt(newIndex) * Math.pow(prime, patternLength-1));
        return newHash;
    }

    private static boolean checkEqual(String text, String pattern, int start) {
        for (int i = 0; i < pattern.length(); i++) {
            if (text.charAt(start + i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String text = "ababcabcabababd";
        String pattern = "babd";
        int result = search(text, pattern);
        System.out.println(result != -1 ? "pattern found at index: " + result : "Pattern not found");

    }
}
