package binarySearch.bsOnAnswers;

public class NthRoot {
    public static int getNthRoot(int number, int nThRoot) {
        int low = 1, high = number;
        while (low <= high) {
            int mid = (low + (high - low)/2);
            int midN = func(mid, number, nThRoot);
            if (midN == 1) {
                return mid;
            }
            else if (midN == 0){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int func(int mid, int number, int nthRoot) {
        long ans = 1;
        for (int i = 1; i <= nthRoot; i++) {
            ans = ans * mid;
            if (ans > number) {
                return 2;
            }
        }
        if (ans == number) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = 3, m = 27;
        int ans = getNthRoot(m, n);
        System.out.println("The " + n +  "th root of "+  m + " is: " + ans);
    }
}