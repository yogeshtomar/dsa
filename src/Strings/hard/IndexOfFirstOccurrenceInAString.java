package Strings.hard;

public class IndexOfFirstOccurrenceInAString {
    private static final int prime = 101;
    public static int indexOfFirstOccurrence(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();

        if (m > n) {
            return -1; // Needle is longer than haystack, not possible
        }

        long needleHash = createHash(needle, m);
        long haystackHash = createHash(haystack, m);

        // Iterate over the haystack
        for (int i = 0; i <= n - m; i++) {
            // Check if the current window hash matches the needle hash
            if (needleHash == haystackHash && checkEqual(haystack, needle, i)) {
                return i; // Needle found at index i
            }

            // Recalculate hash for the next window
            if (i < n - m) {
                haystackHash = recalculateHash(haystack, haystackHash, i, i + m, m);
            }
        }

        return -1; // Needle not found
    }

    private static long createHash(String str, int length) {
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash += (long) (str.charAt(i) * Math.pow(prime, i));
        }
        return hash;
    }

    private static long recalculateHash(String str, long oldHash, int oldIndex, int newIndex, int patternLength) {
        long newHash = oldHash - str.charAt(oldIndex);
        newHash /= prime;
        newHash += (long) (str.charAt(newIndex) * Math.pow(prime, patternLength - 1));
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
        String haystack = "ababcaababcaabc";
        String needle = "ababcaabc";
        System.out.println("Haystack: " + haystack + ", Needle: " + needle);
        System.out.println("First occurrence of " + needle + " is at index: " + indexOfFirstOccurrence(haystack, needle));
    }
}
