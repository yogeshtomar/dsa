package recursion;

public class CountGoodNumbers {
    private static final long MOD = 1_000_000_007;

    public static long countGoodNumbers(long n) {
        long  evenCount = (n + 1)/2;
        long oddCount = (n/2);

        long evenWays = powerMod(5, evenCount);
        long oddWays = powerMod(4, oddCount);

        return (evenWays * oddWays) % MOD;
    }

    private static long powerMod(long x, long n)  {
        if (n == 0) {
            return 1;
        }

        long half = powerMod(x, n/2);
        half = (half * half) % MOD;

        if (n % 2 != 0) {
            half = (half * x) % MOD;
        }

        return half;
    }

    public static void main(String[] args) {
        long n1 = 1;
        System.out.println("Good number count for " + n1 +" : " + countGoodNumbers(n1));
        long n2 = 4;
        System.out.println("Good number count for :" + n2 + " : " + countGoodNumbers(n2) );
        long n3 = 50;
        System.out.println("Food number count for : " + n3 + " : " + countGoodNumbers(n3));
    }
}
