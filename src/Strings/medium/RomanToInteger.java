package Strings.medium;

public class RomanToInteger {
    public static int romanToInt(String s) {
        int[] numbers =new int[s.length()];
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)){
                case 'M':
                    numbers[i]=1000;
                    break;
                case 'D':
                    numbers[i]=500;
                    break;
                case 'C':
                    numbers[i]=100;
                    break;
                case 'L':
                    numbers[i]=50;
                    break;
                case 'X' :
                    numbers[i]=10;
                    break;
                case 'V':
                    numbers[i]=5;
                    break;
                case 'I':
                    numbers[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<numbers.length-1;i++){
            if(numbers[i]<numbers[i+1])
                sum-=numbers[i];
            else
                sum+=numbers[i];
        }
        return sum+numbers[numbers.length-1];
    }

    public static void main(String[] args) {
        String input = "LVIII";
        System.out.println("The Integer for Roman: " + input + " is : " + romanToInt(input));
        String input2 = "MCMXCIV";
        System.out.println("The Integer for Roman: " + input2 + " is : " + romanToInt(input2));
    }
}
