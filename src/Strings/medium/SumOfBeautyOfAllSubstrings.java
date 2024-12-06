package Strings.medium;

public class SumOfBeautyOfAllSubstrings {
    public static int beautySum(String string) {
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            int[] charCount = new int[26];
            for (int j = i; j < string.length(); j++) {
                charCount[string.charAt(j) - 'a']++;
                int beauty = getMaxCount(charCount) - getMinCount(charCount);
                sum += beauty;
            }
        }
        return sum;
    }

    private static int getMaxCount(int[] count) {
        int max = 0;

        for (int i = 0; i < count.length; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }

    private static int getMinCount(int[] count) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            min = count[i] != 0 ? Math.min(min, count[i]) : min;
        }
        return min;
    }

    public static void main(String[] args) {
        String s = "aabcb";
        System.out.println("The beauty sum for String : " + s + " is: " + beautySum(s));
        String input = "aabcbaa";
        System.out.println("The beauty sum for String : " + input + " is: " + beautySum(input));
    }
}
