package Strings.easy;

public class LargestOddNumberInString {
    public static String largestOddNumber(String num) {
        for (int i = num.length()-1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i+1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String a = "35427";
        System.out.println("The largest odd number in String: " + a + " is : " + largestOddNumber(a));
        String b = "52";
        System.out.println("The largest odd number in String: " + b + " is : " + largestOddNumber(b));
        String c = "4206";
        System.out.println("The largest odd number in String: " + c + " is : " + largestOddNumber(c));
    }
}
