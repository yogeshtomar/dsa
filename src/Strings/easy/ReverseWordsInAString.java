package Strings.easy;

public class ReverseWordsInAString {
    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        int low = 0, high = words.length-1;
        while (low <= high) {
            String temp = words[low];
            words[low] = words[high];
            words[high] = temp;
            low++;
            high--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length-1; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.append(words[words.length - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "this is an amazing program";
        String output = reverseWords(input);
        System.out.println("The input string is: " + input);
        System.out.println("The output is : " + output);
    }
}
