package Strings.medium;

public class StringToIntegerAtoi {
    public static int myAtoi(String string) {
        int index = 0;
        int total = 0;
        int sign = 1;

        if (string.length() == 0) {
            return 0;
        }

        while (index < string.length() && string.charAt(index) == ' ') {
            index++;
        }
        if (index == string.length()) return 0;

        if (string.charAt(index) == '+' || string.charAt(index) == '-') {
            sign = string.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < string.length()) {
            int digit = string.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            if (Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total*10  + digit;
            index++;
        }
        return total * sign;
    }

    public static void main(String[] args) {
        String s = "-042";
        System.out.println("String is : " + s + " And Integer is : " + myAtoi(s));
    }
}
