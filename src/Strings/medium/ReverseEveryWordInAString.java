package Strings.medium;

public class ReverseEveryWordInAString {
    public static String reverseEveryWord(String input) {
        String[] words = input.split(" ");
         int low = 0, high = words.length-1;
         while (low <= high) {
             String temp = words[low];
             words[low] = words[high];
             words[high] = temp;
             low++;
             high--;
         }

         StringBuilder sb = new StringBuilder();
         int i = 0;
         for (i = 0; i < words.length-1; i++) {
             sb.append(words[i]);
             sb.append(" ");
         }
         sb.append(words[i]);
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "the sky is blue";
        System.out.println("String: " + input);
        System.out.println("String after reversing every word: \n" + reverseEveryWord(input));
    }
}
