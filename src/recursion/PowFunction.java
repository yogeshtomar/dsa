package recursion;

public class PowFunction {
    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1 / pow(x, -n);
        }

        double half = pow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        }
        else {
            return x * half * half;
        }
    }

    public static void main(String[] args) {
        System.out.println("2^10 = " + pow(2, 10)); // Expected output: 1024.0
        System.out.println("2^-2 = " + pow(2, -2)); // Expected output: 0.25
        System.out.println("3^5 = " + pow(3, 5));   // Expected output: 243.0
        System.out.println("5^0 = " + pow(5, 0));   // Expected output: 1.0
        System.out.println("2^1 = " + pow(2, 1));
    }
}
