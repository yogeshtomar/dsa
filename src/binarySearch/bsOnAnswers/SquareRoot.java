package binarySearch.bsOnAnswers;

public class SquareRoot {
    public static int getSquareRoot(int n) {
        int low = 1, high = n;

        while (low <= high) {
            long mid = low + (high - low)/2;
            long val = mid * mid;
            if (val <= (long) n) {
                low = (int) mid + 1;
            }
            else {
                high = (int) mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int n = 625;
        System.out.println("Square Root of " + n + " is :" + getSquareRoot(n));
    }
}
