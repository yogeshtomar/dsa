package recursion.subsequencePattern;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    private static final String[] KEYPAD = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        String possibleCharacters = KEYPAD[digit];

        for (char c : possibleCharacters.toCharArray()) {
            current.append(c);
            backtrack(digits, index+1, current, result);
            current.deleteCharAt(current.length()-1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> result = letterCombinations(digits);
        System.out.println("Combination for digits :");
        System.out.println(result);
    }
}
