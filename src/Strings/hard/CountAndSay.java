package Strings.hard;

public class CountAndSay {
    public static String countAndSay(int n) {
        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j-1)) {
                    count++;
                }
                else {
                    sb.append(count).append(result.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count).append(result.charAt(result.length()-1));
            result = sb.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        int input = 4;
        System.out.println("Count And Say for n = " + input + " : " + countAndSay(input));
    }
}
