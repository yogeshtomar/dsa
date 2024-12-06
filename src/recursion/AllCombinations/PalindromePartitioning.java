package recursion.AllCombinations;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String string) {
        List<List<String>> result = new ArrayList<>();
        partitionHelper(0, string, new ArrayList<>(), result);
        return result;
    }
    private static void partitionHelper(int index, String string, List<String> current, List<List<String>> result) {
        if (index == string.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < string.length(); ++i) {
            if (isPalindrome(string, index, i)) {
                current.add(string.substring(index, i+1));
                partitionHelper(index+1, string, current, result);
                current.removeLast();
            }
        }
    }

    private static boolean isPalindrome(String string, int start, int end) {
        while (start <= end) {
            if (string.charAt(start++) != string.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println("Palindromic Partition are:");
        System.out.println(partition(s));
    }
}
